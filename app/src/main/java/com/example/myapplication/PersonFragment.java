package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.io.InputStream;


public class PersonFragment extends Fragment {

    private EditText editName;
    private TextView welcome, enterNameText;
    private Button save, back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_person, container, false);;
        editName = v.findViewById(R.id.editName);
        save = v.findViewById(R.id.btnSave);
        welcome = v.findViewById(R.id.txtView_Welcome);
        back = v.findViewById(R.id.btnBack);
        enterNameText=v.findViewById(R.id.txtName);

        //save user name
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcome.setText("Welcome to Alarm App, " + editName.getText().toString() + "!!");
                editName.setVisibility(View.GONE);
                enterNameText.setVisibility(View.INVISIBLE);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Puzzle.class);
                intent.putExtra("name", editName.getText().toString());
                getActivity().startActivity(intent);
            }
        });

        return v;
    }
}