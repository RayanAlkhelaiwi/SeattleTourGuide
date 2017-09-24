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

public class CoffeehousesCategory extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    //On the change of AudioFocus state
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //In case of loss transient
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                //In case of AudioFocus gain
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
                //In case of AudioFocus loss
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer.stop();
                releaseMediaPlayer();
            }
        }
    };

    //Release media player once it's completed, or finished
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //ArrayList that holds the places information
        final ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Cozy Coffee", "1010 Mainone Street", "Monday - Sunday", "7:30 AM - 9:30 PM", 0, R.drawable.coffeehouse_list));
        cityAttractions.add(new CityAttraction("Ultra Coffee", "1001 Maintwo Street", "Monday - Sunday", "9 AM - 10:30 PM", 0, R.drawable.coffeehouse_list));
        cityAttractions.add(new CityAttraction("Stars Coffee", "1100 Mainthree Street", "Monday - Saturday", "8:30 AM - 8:30 PM", 0, R.drawable.coffeehouse_list));

        //Custom adapter that accepts the context, ArrayList and the color of the list item
        AttractionAdapter attractionAdapter = new AttractionAdapter(this, cityAttractions, R.color.primary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        //On the click of single item, it play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CityAttraction attraction = cityAttractions.get(position);

                releaseMediaPlayer();

                //Request audio focus for playback
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        //Use the music stream
                        AudioManager.STREAM_MUSIC,
                        //Request permanent audio focus
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //Audio Focus is granted

                    mediaPlayer = MediaPlayer.create(CoffeehousesCategory.this, attraction.getPlaceAudio());
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
