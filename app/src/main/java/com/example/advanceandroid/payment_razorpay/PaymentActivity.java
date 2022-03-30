package com.example.advanceandroid.payment_razorpay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.advanceandroid.R;
import com.example.advanceandroid.databinding.ActivityPaymentBinding;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    private ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Checkout.preload(getApplicationContext());

        binding.btnPayment.setOnClickListener(view -> {
            Checkout checkout = new Checkout();
            checkout.setKeyID("rzp_test_6lbvAaMBT5lf7o");

//            checkout.setImage(R.drawable.ic_payment);

            final Activity activity = this;

            try {
                JSONObject options = new JSONObject();

                options.put("name", "Arpit Parekh");
                options.put("description", "Reference No. #123456");
                options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//                options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", "50000");//pass amount in currency subunits
                options.put("prefill.email", "gaurav.kumar@example.com");
                options.put("prefill.contact","9601397062");
                JSONObject retryObj = new JSONObject();
                retryObj.put("enabled", true);
                retryObj.put("max_count", 4);
                options.put("retry", retryObj);

                checkout.open(activity, options);

            } catch(Exception e) {
                Log.i("payment",e.toString());
            }

        });


    }

    @Override
    public void onPaymentSuccess(String s) {
        binding.tvPayment.setText("Payment SuccessFull\n"+s);
    }

    @Override
    public void onPaymentError(int i, String s) {
        binding.tvPayment.setText("Payment Fail\n"+s);
    }
}