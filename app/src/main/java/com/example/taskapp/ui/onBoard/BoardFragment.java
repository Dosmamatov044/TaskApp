package com.example.taskapp.ui.onBoard;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskapp.MainActivity;
import com.example.taskapp.R;


public class BoardFragment extends Fragment {

    TextView textTitle, textDesc;
    Button button;


    public BoardFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final OnBoardActivity onBoardActivity = (OnBoardActivity) getActivity();
        textTitle = view.findViewById(R.id.textTitle);
        textDesc = view.findViewById(R.id.textDesc);
        button = view.findViewById(R.id.button_Getstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onBoardActivity, MainActivity.class);
                startActivity(intent);
                onBoardActivity.finish();
            }
        });
        ImageView image = view.findViewById(R.id.imageView);
        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                image.setImageResource(R.drawable.oneph);
                textTitle.setText("Hi");

                button.setVisibility(View.GONE);
                break;
            case 1:
                image.setImageResource(R.drawable.twoph);
                textTitle.setText("how are you");
                ;
                button.setVisibility(View.GONE);
                break;
            case 2:
                image.setImageResource(R.drawable.threeph);
                textTitle.setText("I am bad");

                button.setVisibility(View.VISIBLE);
                break;
        }
    }
}