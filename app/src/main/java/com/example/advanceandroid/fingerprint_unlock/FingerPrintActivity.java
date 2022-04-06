package com.example.advanceandroid.fingerprint_unlock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Toast;

import com.example.advanceandroid.databinding.ActivityFingerPrintBinding;

import java.util.concurrent.Executor;

public class FingerPrintActivity extends AppCompatActivity {

    private ActivityFingerPrintBinding binding;
    private androidx.biometric.BiometricPrompt prompt;
    private BiometricPrompt.PromptInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFingerPrintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BiometricManager manager = BiometricManager.from(this);

        switch (manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK| BiometricManager.Authenticators.BIOMETRIC_STRONG)) {

            case BiometricManager.BIOMETRIC_SUCCESS:
                Toast.makeText(this, "U can use Biometric Authentication", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(this, "U Do not Have Biometric Authentication", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(this, "Biometric Sensor not available", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(this, "Device Does not have any FingerPrint Saved", Toast.LENGTH_SHORT).show();
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(this);

        prompt = new BiometricPrompt(FingerPrintActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(FingerPrintActivity.this, "Login SuccessFul", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        info = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Login")
                .setSubtitle("Put Your Finger")
                .setNegativeButtonText("Use Password")
                .build();

        binding.btnBioMetric.setOnClickListener(view -> {

            prompt.authenticate(info);

        });

    }
}
