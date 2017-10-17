package edu.orangecoastcollege.cs273.sbadajoz.nothernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    ImageView lightsImageView;
    AnimationDrawable frameAnim;
    Button frameAnimButton;
    Button rotateAnimButton;
    Button shakeAnimButton;
    Button customAnimButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
        frameAnimButton = (Button) findViewById(R.id.frameAnimButton);
        rotateAnimButton = (Button) findViewById(R.id.rotateAnimButton);
        shakeAnimButton = (Button) findViewById(R.id.shakeAnimButton);
        customAnimButton = (Button) findViewById(R.id.customAnimButton);
    }

    public void toggleFrameAnim(View view) {
        if (frameAnim == null) {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        if(frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }
}
