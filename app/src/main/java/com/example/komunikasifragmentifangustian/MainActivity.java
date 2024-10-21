package com.example.komunikasifragmentifangustian;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mulai dengan FirstFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FirstFragment())
                    .commit();
        }
    }

    // Implementasi method dari interface untuk menerima data dari FirstFragment
    @Override
    public void onMessageSend(String message) {
        // Membuat instance dari SecondFragment dan meneruskan data sebagai Bundle
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        secondFragment.setArguments(bundle);

        // Replace fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)  // Agar bisa kembali ke FirstFragment
                .commit();
    }
}
