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

/**
 * Creates a view where a user can manipulate an image using four buttons
 */
public class AnimationActivity extends AppCompatActivity {

    ImageView lightsImageView;

    AnimationDrawable frameAnim;
    RotateAnimation rotateAnim;
    Animation shakeAnim;
    Animation customAnim;

    /**
     * Called on initial display of the layout
     *
     * Connects variable to {@link ImageView}
     *
     * @param savedInstanceState Bundle of data from previous run of activity if applicable
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * On click of the frame animation button
     * Checks to see if the animation has already been created, if not it associates  it with the resource
     * Then attaches the frame animation to the {@link ImageView} and runs it.
     * Toggleable
     *
     * @param view Frame animation button
     */
    public void toggleFrameAnim(View view) {
        if (frameAnim == null) {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    /**
     * On click of the rotate animation button
     * Checks to see if the animation has already been created, if not it associates  it with the resource
     * Then attaches the rotate animation to the {@link ImageView} and runs it.
     * Toggleable
     *
     * @param view Rotate animation button
     */
    public void toggleRotateAnim(View view) {
        if (rotateAnim == null)
            rotateAnim = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        if (!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim);
        else
            lightsImageView.clearAnimation();
    }

    /**
     * On click of the Shake animation button
     * Checks to see if the animation has already been created, if not it associates  it with the resource
     * Then attaches the shake animation to the {@link ImageView} and runs it.
     *  Not Toggleable
     *
     * @param view Shake animation button
     */
    public void toggleShakeAnim(View view) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }

    /**
     * On click of the Custom animation button
     * Checks to see if the animation has already been created, if not it associates  it with the resource
     * Then attaches the Custom animation to the {@link ImageView} and runs it.
     *
     * This animation quickly fades the alpha of the image in and out,creating a strobe effect
     *
     * Toggleable
     *
     * @param view Custom animation button
     */
    public void toggleCustomAnim(View view) {
        if (customAnim == null) {
            customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
            lightsImageView.startAnimation(customAnim);
        }
        if (!customAnim.hasStarted())
            lightsImageView.startAnimation(customAnim);
        else
            lightsImageView.clearAnimation();

    }
}
