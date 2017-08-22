package com.beautifulsoup.dancego.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.beautifulsoup.dancego.bean.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/14.
 * 加载本地的手机音乐
 */

public class MediaUtils {


    public static List<Song> songList = new ArrayList<>();

    public static void getSongList(Context context) {
        songList.clear();//多次加载手机本地的音乐

        //表示数据库中的表
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        //歌曲信息的封装
        String[] projection = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DATA};

        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);


        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

            Song song=new Song(title,artist,data);
            songList.add(song);
        }

    }


}
