package com.example.bottomnavigation.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavigation.R;

public class Fragment_Find extends Fragment {
    private View mainView;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.module_fragment_find, container, false);
        context = mainView.getContext();

        mainView.findViewById(R.id.image_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "nihao", Toast.LENGTH_LONG).show();
            }
        });
        return mainView;
    }
}