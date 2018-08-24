package com.example.hakony.fifadatabase;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

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
                case R.id.navigation_notifications:
                    mTextMessage.setText("Notifications");
                    fragmentManager.beginTransaction().replace(R.id.container, new NotificationFragment()).commit();
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
