package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThemeFragment extends Fragment {

    private TextView theme, themeTitle;
    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_theme, container, false);

        radioGroup = v.findViewById(R.id.idRGgroup);
        theme = v.findViewById(R.id.idtvTheme);
        themeTitle = v.findViewById(R.id.title);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // on radio button check change
                switch (checkedId) {
                    case R.id.idRBLight:
                        // set text to text view as light mode.
                        theme.setText("Light Theme");
                        theme.setVisibility(View.INVISIBLE);
                        // on below line changing theme to light mode.
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case R.id.idRBDark:
                        // this method is called when dark radio button is selected
                        theme.setText("Dark Theme");
                        theme.setVisibility(View.INVISIBLE);
                        // change theme to dark mode.
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                }

            }
        });
        return v;
    }
}