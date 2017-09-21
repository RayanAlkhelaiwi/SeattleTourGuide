package com.example.android.seattletourguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rean on 9/21/2017.
 */

public class ActivitiesCategory extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer.stop();
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_attraction_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.mipmap.ic_launcher));

        AttractionAdapter attractionAdapter = new AttractionAdapter(this, cityAttractions, R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CityAttraction attraction = cityAttractions.get(position);

                releaseMediaPlayer();

                // Request audio focus for playback
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //Audio Focus is granted.

                    mediaPlayer = MediaPlayer.create(ActivitiesCategory.this, attraction.getmPlaceAudioVideo());
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {

            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
