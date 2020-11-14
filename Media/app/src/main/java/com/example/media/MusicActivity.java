package com.example.media;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {
    String path;
    String presongPath;
    String nextsongPath;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        presongPath = intent.getStringExtra("presongpath");
        nextsongPath = intent.getStringExtra("nextsongpath");
//        System.out.print(path);
//        Log.v("MusicActivite","ooo");

        Button startbutton = (Button) findViewById(R.id.start);
        Button stopbutton = (Button) findViewById(R.id.stop);
        Button pausebutton = (Button) findViewById(R.id.pause);
        Button prebutton = (Button) findViewById(R.id.pre);
        Button nextbutton = (Button) findViewById(R.id.next);
        //播放
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(path);

            }
        });

        //停止
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });

        //暂停
        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });

        //播放下一曲
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("MusicActivite", "nextSong");
                play(nextsongPath);

            }
        });

        //播放上一曲
        prebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(presongPath);
            }
        });


    }

    //单曲循环
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.loop:
                boolean loop1 = mediaPlayer.isLooping();
                if (loop1) {
                    mediaPlayer.setLooping(!loop1);
                } else {
                    mediaPlayer.setLooping(!loop1);
                }
                break;
        }
        return false;
    }
    //播放
    public void play(String path){
        try{
//                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//                int songid = (int) info.id;
//                String path = arrayList.get(songid).toString();
            mediaPlayer.reset();
//                String datapath = arrayList.get(songid);
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaP) {
                    mediaP.start();
                }
            });


        }catch (Exception e){
            Log.v("MusicService", e.getMessage());
        }

    }
    //进度条
    public class MySeekBar implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            boolean seekbarchange = false;
        }
//滚动时，应该暂停后台定时
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            boolean seekbarchange = true;
            mediaPlayer.seekTo((seekBar.getProgress()));
        }
//滑动结束时，重新设置值
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            boolean seekbarchange = false;
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }
}
