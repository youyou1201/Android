package com.example.media;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //    private static final File Path = Environment.getExternalStorageDirectory();// 获取SD卡总目录
    private static final int REQUEST_PERMISSION = 0;
    MediaPlayer mediaPlayer=new MediaPlayer();
    ListView listView ;
    ArrayList<String> songNameList = new ArrayList<String>();
    List<Song> listsong;
    String path ;
    String prepath;
    String nextpath ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            int hasWritePermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int hasReadPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            List<String> permissions = new ArrayList<String>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }else {
                //     preferencesUtility.setString("storage", "true");
            }
            if (hasReadPermission != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }else {
                // preferencesUtility.setString("storage", "true");
            }
            if (!permissions.isEmpty()){
                // requestPermissions(permissions.toArray(new String[permissions.size()]), REQUEST_CODE_SOME_FEATURES_PERMISSIONS);
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},REQUEST_PERMISSION);
            }

        }




//        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_READ_MEDIA);
//        }else{
//            readDataExternal();
//        }


/*
        String str[] = {MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE};
        //Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,
               //null,null,MediaStore.Audio.AudioColumns.IS_MUSIC);
        Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);
        while (cursor.moveToNext()){
            String songID = cursor.getString(0);
            String songName = cursor.getString(1);
            String songPath = cursor.getString(2);
            String songSize = cursor.getString(3);
            arrayList.add(songPath);
            */
//            songNameList=new ArrayList<>();
        listsong = new ArrayList<>();
        listsong=Utils.getmusic(this);
        for(int i=0;i<listsong.size();i++){
            songNameList.add(listsong.get(i).songName);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, songNameList);
        listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {//长按弹出菜单
//                Intent intent = new Intent(MainActivity.this,MusicActivity.class);
//                startActivity(intent);

//                        Bundle bundle = new Bundle();
//                        bundle.putParcelableArrayList("songlist",listsong);
//                        String path =  listView.getItemAtPosition(position).toString();
//                        SongInfo songInfo1 = new SongInfo();
//                        String path = songInfo1.getSongPath();
                int songid = (int) id;
                Intent intent = new Intent(MainActivity.this, Music.class);
                if(position>0 && position<listsong.size()-1) {
                    path = listsong.get(songid).songPath;
                    prepath = listsong.get(songid - 1).songPath;
                    nextpath = listsong.get(songid + 1).songPath;

                    intent.putExtra("path", path);
                    intent.putExtra("presongpath", prepath);
                    intent.putExtra("nextsongpath", nextpath);

                }
                else if(position==0)
                {
                    path = listsong.get(songid).songPath;
                    prepath = listsong.get(songid+listsong.size()-1).songPath;
                    nextpath = listsong.get(songid + 1).songPath;
                    intent.putExtra("path", path);
                    intent.putExtra("presongpath", prepath);
                    intent.putExtra("nextsongpath", nextpath);
                }
                else {
                    path = listsong.get(songid).songPath;
                    prepath = listsong.get(songid - 1).songPath;
                    nextpath = listsong.get(songid-listsong.size()+1).songPath;
                    intent.putExtra("path", path);
                    intent.putExtra("presongpath", prepath);
                    intent.putExtra("nextsongpath", nextpath);

                }
                startActivity(intent);


            }
        });
//        ItemOnLongClick1();
    }

//    private void ItemOnLongClick1() {
//
//        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
//            @Override
//            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
//
//                contextMenu.add(0,0,0,"播放");
//                contextMenu.add(0,1,0,"停止");
//                contextMenu.add(0,2,0,"循环");
//                contextMenu.add(0,3,0,"暂停");
//                contextMenu.add(0,4,0,"上一曲");
//                contextMenu.add(0,5,0,"下一曲");
//
//
//            }
//        });
//
//    }
//    public  boolean onContextItemSelected(MenuItem item){//点击菜单选项实现相应操作
//
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
//                .getMenuInfo();
//        int songid = (int) info.id;
//        String path = listsong.get(songid).songPath;
//        switch (item.getItemId()){
//            //播放
//            case 0:
//                play(path);
//                break;
//            //停止
//            case 1:
//                mediaPlayer.stop();
//                break;
//            //单曲循环
//            case 2:
//                boolean loop1 = mediaPlayer.isLooping();
//                if(loop1){
//                    mediaPlayer.setLooping(!loop1);
//                }else{
//                    mediaPlayer.setLooping(!loop1);
//                }
//                break;
//            //暂停
//            case 3:
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                }else{
//                    mediaPlayer.start();
//                }
//                break;
//            //播放上一曲
//            case 4:
//                String p1 = listsong.get(songid-1).songPath;
//                play(p1);
//                break;
//            //播放下一曲
//            case 5:
//                String p2 = listsong.get(songid+1).songPath;
//                play(p2);
//                break;
//
//            default:
//                break;
//
//        }
//        return super.onContextItemSelected(item);
//    }


    //权限请求许可
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case REQUEST_PERMISSION:{
                for (int i = 0; i < permissions.length; i++){
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        System.out.println("Permissions --> " + "Permission Granted: " + permissions[i]);
                    }else if (grantResults[i] == PackageManager.PERMISSION_DENIED){
                        System.out.println("Permissions --> " + "Permission Denied: " + permissions[i]);
                    }
                }
            }break;
            default:{
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
    //播放
//            public void play(String path){
//            try{
////                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
////                int songid = (int) info.id;
////                String path = arrayList.get(songid).toString();
//                mediaPlayer.reset();
////                String datapath = arrayList.get(songid);
//                mediaPlayer.setDataSource(path);
//                mediaPlayer.prepareAsync();
//                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mediaP) {
//                        mediaP.start();
//                    }
//                });
//
//
//            }catch (Exception e){
//                Log.v("MusicService", e.getMessage());
//                }
//
//            }
}





//    class songFile{
//        Context context ;
//        public List<SongInfo> songlist = new ArrayList<>();
//         Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,
//                 null,null,MediaStore.Audio.AudioColumns.IS_MUSIC);
//
//    }

class Utils {
    //定义一个集合，存放从本地读取到的内容
//    public static ArrayList<String> list=new ArrayList<>();
    public  static  List<Song> listsong;
    public  static Song songInfo;
    public static List<Song> getmusic(Context context) {

        listsong = new ArrayList<>();


        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                songInfo = new Song();
                songInfo.songName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                songInfo.singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                songInfo.songPath = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                if(songInfo.songName.contains("-") )
                {
                    String[] str = songInfo.songName.split("-");
                    songInfo.singer=str[0];
                    songInfo.songName=str[1];
                }
//                else if(songInfo.songName.contains("."))
//                {
//                    String[] str1 = songInfo.songName.split(".");
//                    songInfo.singer=str1[0];
//                    songInfo.songName=str1[1];
//                }
                listsong.add(songInfo);
            }
        }

        cursor.close();
        return listsong;

    }




}