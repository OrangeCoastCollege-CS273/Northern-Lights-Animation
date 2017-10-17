package edu.orangecoastcollege.cs273.sbadajoz.nothernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    ImageView lightsImageView;
    Button frameAnimButton;
    Button rotateAnimButton;
    Button shakeAnimButton;
    Button customAnimButton;

    AnimationDrawable frameAnim;
    RotateAnimation rotateAnim;
    Animation shakeAnim;

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

    public void toggleRotateAnim(View view) {
        if (rotateAnim == null) {
            rotateAnim = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        } else if (rotateAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }else
            rotateAnim = null;
    }

    public void toggleShakeAnim(View view) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }
}
