package com.example.hakony.fifadatabase;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper ads;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    mTextMessage.setText("News");
                    fragmentManager.beginTransaction().replace(R.id.container, new NewsFragment()).commit();
                    return true;
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    fragmentManager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText("Search");
                    fragmentManager.beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ads= (ViewFlipper) findViewById(R.id.ads) ;
        int images[]= {R.drawable.main1,R.drawable.main2,R.drawable.main3};
        mTextMessage= (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        for (int image: images){
            FlipImage(image);
        }

        final CardView trailerBtn= (CardView) findViewById(R.id.trailerbutton);

        trailerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent traileractivity= new Intent(MainActivity.this,Trailer.class);
                MainActivity.this.startActivity(traileractivity);
            }
        });
    }

    public void FlipImage(int image){
        ImageView imageview = new ImageView(  this);
        imageview.setBackgroundResource(image);

        ads.addView(imageview);
        ads.setFlipInterval(2000);
        ads.setAutoStart(true);

        ads.setInAnimation(this,android.R.anim.slide_in_left);
        ads.setOutAnimation(this, android.R.anim.slide_out_right);

    }



}
