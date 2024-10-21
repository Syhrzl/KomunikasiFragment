package com.example.komunikasifragmentifangustian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    private TextView textViewMessage;

    // Jika ingin menggunakan newInstance
    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        textViewMessage = view.findViewById(R.id.textViewMessage);  // Pastikan id sesuai dengan XML

        // Mendapatkan pesan yang diteruskan dari FirstFragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            String message = bundle.getString("message");
            textViewMessage.setText(message);
        }

        return view;
    }
}
