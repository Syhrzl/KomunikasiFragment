package com.example.komunikasifragmentifangustian;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    private EditText editTextMessage;
    private Button buttonSend;
    private OnMessageSendListener messageSendListener;

    // Interface untuk komunikasi
    public interface OnMessageSendListener {
        void onMessageSend(String message);
    }

    // Jika kamu ingin menggunakan newInstance
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            messageSendListener = (OnMessageSendListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnMessageSendListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        editTextMessage = view.findViewById(R.id.editTextMessage);  // Pastikan id sesuai dengan XML
        buttonSend = view.findViewById(R.id.buttonSend);  // Pastikan id sesuai dengan XML

        buttonSend.setOnClickListener(v -> {
            String message = editTextMessage.getText().toString();
            messageSendListener.onMessageSend(message);
        });

        return view;
    }
}
