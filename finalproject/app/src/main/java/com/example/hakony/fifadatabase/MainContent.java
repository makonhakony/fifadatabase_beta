package com.example.hakony.fifadatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Fade;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        //---------------------element------------
        final CardView bStart = (CardView) findViewById(R.id.startbutton);
        TextView etName= (TextView) findViewById(R.id.etName);
        ImageView useravata=(ImageView) findViewById(R.id.useravatar);
        CardView user=(CardView) findViewById(R.id.user) ;
        TextView welcome= (TextView) findViewById(R.id.welcome);
        //----------------------------------------
        etName.setText(name+"!");

        Animation FadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        bStart.startAnimation(FadeIn);
        useravata.startAnimation(FadeIn);
        user.startAnimation(FadeIn);
        welcome.startAnimation(FadeIn);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent= new Intent(MainContent.this,MainActivity.class);
                MainContent.this.startActivity(mainIntent);
            }
        });
    }
}
