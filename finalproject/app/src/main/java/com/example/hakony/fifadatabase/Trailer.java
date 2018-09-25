package com.example.hakony.fifadatabase;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Trailer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width= dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        WindowManager.LayoutParams params =getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);

        VideoView trailer = (VideoView) findViewById(R.id.trailer);
        String videopath = "android.resource://" + getPackageName() + "/" +R.raw.video;
        Uri uri =Uri.parse(videopath);
        trailer.setVideoURI(uri);

        MediaController mediaController= new MediaController(this);
        trailer.setMediaController(mediaController);
        mediaController.setAnchorView(trailer);
    }
}
