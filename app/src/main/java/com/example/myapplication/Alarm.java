package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent){
        String sound = intent.getStringExtra("ringtone");
           //set ringtone

           /*if(sound.equals(null)) {
               mp=MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
               mp.start();
               Toast.makeText(context, "Time to wakeup!!" + sound, Toast.LENGTH_LONG).show();
           }*/
           /*switch(sound){
               case("birds"):
                   mp = MediaPlayer.create(context, R.raw.birds);
                   mp.start();
                   mp.setLooping(true);
                   Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();
                   break;
               case("owl"):
                   mp = MediaPlayer.create(context, R.raw.owl);
                   mp.start();
                   mp.setLooping(true);
                   Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();
                   break;
                   case("rooster"):
                   mp = MediaPlayer.create(context, R.raw.rooster);
                   mp.start();
                   mp.setLooping(true);
                   Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();
                   break;
              /* default:
                   mp=MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
                   mp.start();
                   Toast.makeText(context, "Time to wakeup!!" + sound, Toast.LENGTH_LONG).show();*/

          if(sound.equals("birds")) {
                mp = MediaPlayer.create(context, R.raw.birds);
                mp.start();
                mp.isLooping();
                Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();

            }
            else if(sound.equals("owl")){
                mp = MediaPlayer.create(context, R.raw.owl);
                mp.start();
                mp.isLooping();
                Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();

            }
            else if(sound.equals("rooster")){
                mp = MediaPlayer.create(context, R.raw.rooster);
                mp.start();
                mp.isLooping();
                Toast.makeText(context, "Time to wakeup!!", Toast.LENGTH_LONG).show();
            }
            else {
                   mp = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
                   mp.start();
                   Toast.makeText(context, "Time to wakeup!!" + sound, Toast.LENGTH_LONG).show();
               }


        }

}
