package com.example.android.seattletourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rean on 9/21/2017.
 */

public class ActivitiesCategory extends AppCompatActivity {

    private Context context;

//    private MediaPlayer mediaPlayer;
//    private AudioManager audioManager;
//
//    //On the change of AudioFocus state
//    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
//            //In case of loss transient
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                mediaPlayer.pause();
//                mediaPlayer.seekTo(0);
//            //In case of AudioFocus gain
//            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                mediaPlayer.start();
//            //In case of AudioFocus loss
//            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                mediaPlayer.stop();
//                releaseMediaPlayer();
//            }
//        }
//    };
//
//    //Release media player once it's completed, or finished
//    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        context = this;

//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //ArrayList that holds the places' information
        final ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity A", "1122 Nameone Street", "Saturday - Wednesday", "10:30 AM - 11:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity B", "2233 Nametwo Street", "Monday - Friday", "9 AM - 8:30 PM", 0, R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Activity C", "3344 Namethree Street", "Monday - Saturday", "11 AM - 6:30 PM", 0, R.drawable.activity_list));

        //Custom adapter that accepts the context, ArrayList and the color of the list item
        AttractionAdapter attractionAdapter = new AttractionAdapter(this, cityAttractions, R.color.primary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0: //For the first list item
                        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6205, -122.3493);
                        Intent placeAddressIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        context.startActivity(placeAddressIntent);
                        break;
                    default:
                        break;
                }
            }
        });

//        //On the click of single item, it play the audio
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//
//                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6205, 122.3493);
//                Intent placeAddress = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                context.startActivity(placeAddress);
//                CityAttraction attraction = cityAttractions.get(position);
//
//                releaseMediaPlayer();
//
//                //Request audio focus for playback
//                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
//                        //Use the music stream
//                        AudioManager.STREAM_MUSIC,
//                        //Request permanent audio focus
//                        AudioManager.AUDIOFOCUS_GAIN);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    //Audio Focus is granted
//
//                    mediaPlayer = MediaPlayer.create(ActivitiesCategory.this, attraction.getPlaceAudio());
//                    mediaPlayer.start();
//
//                    mediaPlayer.setOnCompletionListener(onCompletionListener);
//                }
//            }
//        });
//    }
//
//    public void releaseMediaPlayer() {
//        if (mediaPlayer != null) {
//
//            mediaPlayer.release();
//            mediaPlayer = null;
//            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        releaseMediaPlayer();
//    }
    }
}