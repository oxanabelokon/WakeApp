package com.example.myapplication;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RingtoneFragment extends Fragment{

    private Button set, birdsPlay,owlPlay,roosterPlay,pause,bellPlay ;
    private TextView sound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ringtone, container, false);


        sound = v.findViewById(R.id.soundView);


        //birds sound
        birdsPlay = v.findViewById(R.id.birds);
        final MediaPlayer mp=MediaPlayer.create(getActivity(),R.raw.birds);
        birdsPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                sound.setText("birds");
                sound.setVisibility(View.INVISIBLE);
            }
        });

        //owl sound
        owlPlay = v.findViewById(R.id.owl);
        final MediaPlayer mp2=MediaPlayer.create( getActivity(),R.raw.owl);
        owlPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                sound.setText("owl");
                sound.setVisibility(View.INVISIBLE);
            }
        });

        //rooster sound
        roosterPlay = v.findViewById(R.id.rooster);
        final MediaPlayer mp3=MediaPlayer.create( getActivity(),R.raw.rooster);
        roosterPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
                sound.setText("rooster");
                sound.setVisibility(View.INVISIBLE);
            }
        });

        //bell sound
        bellPlay = v.findViewById(R.id.bell);
        final MediaPlayer mp4=MediaPlayer.create( getActivity(),R.raw.bell);
        bellPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
                sound.setText("bell");
                sound.setVisibility(View.INVISIBLE);
            }
        });

        //pause ringtone
        pause=v.findViewById(R.id.btnPause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()) {
                    mp.pause();
                }
                else if(mp2.isPlaying()){
                    mp2.pause();
                }
                else if(mp3.isPlaying()) {
                    mp3.pause();
                }
                else if(mp4.isPlaying()) {
                    mp4.pause();
                }
                else
                    Toast.makeText(getActivity(), "Nothing is playing", Toast.LENGTH_SHORT).show();
            }
        });

        //set ringtone
        set = v.findViewById(R.id.btnSet);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("sound", sound.getText().toString());
                startActivity(intent);*/

                if (mp.isPlaying()) {
                    //sound.setText("birds");
                    mp.stop();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("sound", sound.getText().toString());
                    startActivity(intent);
                } else if (mp2.isPlaying()) {
                   // sound.setText("owl");
                    mp2.stop();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("sound", sound.getText().toString());
                    startActivity(intent);
                } else if (mp3.isPlaying()) {
                    //sound.setText("rooster");
                    mp3.stop();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("sound", sound.getText().toString());
                    startActivity(intent);
                }
                else if (mp4.isPlaying()) {
                    //sound.setText("bell");
                    mp4.stop();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("sound", sound.getText().toString());
                    startActivity(intent);
                }
               else
                   Toast.makeText(getActivity(), "Nothing is playing", Toast.LENGTH_SHORT).show();

           }
        });

        return v;
    }


}