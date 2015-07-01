package com.sport.betturtle;

import android.graphics.Interpolator;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class LogoActivity extends AppCompatActivity {

    ImageView mImgLogo;
    ImageView mImgLogo1;
    ImageView mImgLogoBack;
    ImageView mImgPremium1;
    ImageView mImgPremium2;
    ImageView mImgPremium3;

    float mPx100 = 0;
    float mBackHeight = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        getSupportActionBar().hide();


        mImgLogoBack = (ImageView)findViewById(R.id.img_logo_back);

        int height = getDisplayHeight();
        mPx100 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mImgLogoBack.getLayoutParams();
        mBackHeight = height - getStatusBarHeight();
        params.height = (int)mBackHeight;
        mImgLogoBack.setLayoutParams(params);

        startLogoAnimation1();
        startLogoBackAnimation();
    }

    private void startLogoAnimation1(){
        mImgLogo1 = (ImageView)findViewById(R.id.img_logo1);
        mImgLogo = (ImageView)findViewById(R.id.img_logo);
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_first_animation);
        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImgLogo1.setAnimation(null);
                mImgLogo1.setVisibility(View.INVISIBLE);
                startLogoAnimation2();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImgLogo1.setAnimation(logoAnimation);
        mImgLogo1.setVisibility(View.VISIBLE);
    }

    private void startLogoAnimation2(){
        mImgLogo = (ImageView)findViewById(R.id.img_logo);
        Animation logoAnimation = new TranslateAnimation(
                Animation.ABSOLUTE, mImgLogo1.getX() ,
                Animation.ABSOLUTE, mImgLogo.getX() ,
                Animation.ABSOLUTE, mImgLogo1.getY() ,
                Animation.ABSOLUTE, mImgLogo.getY() );
        logoAnimation.setInterpolator(new BounceInterpolator());
        logoAnimation.setDuration(700);


        Animation logoAnimation1 = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, mImgLogo.getWidth() / 2, mImgLogo1.getY() + mImgLogo1.getHeight()/2);
        logoAnimation1.setDuration(700);


        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(logoAnimation);
        animationSet.addAnimation(logoAnimation1);
        animationSet.setInterpolator(new BounceInterpolator());
        animationSet.setStartOffset(2500);
        animationSet.setFillAfter(true);
        mImgLogo.setVisibility(View.VISIBLE);
        mImgLogo.startAnimation(animationSet);

        startPremiumAnimation2();
    }


    private void startLogoBackAnimation(){
        mImgLogoBack = (ImageView)findViewById(R.id.img_logo_back);

        Animation logoAnimation = new TranslateAnimation(
                Animation.ABSOLUTE, 0 ,
                Animation.ABSOLUTE, 0 ,
                Animation.ABSOLUTE, mPx100 ,
                Animation.ABSOLUTE, mPx100 - mBackHeight );
        logoAnimation.setInterpolator(new AccelerateInterpolator());
        logoAnimation.setStartOffset(2700);
        logoAnimation.setDuration(1500);
        logoAnimation.setFillAfter(true);
        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mImgLogoBack.setBackgroundResource(R.drawable.banner);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                findViewById(R.id.img_temp_back).setVisibility(View.INVISIBLE);
                startPremiumAnimation1();
                startPremiumAnimation2();
                startPremiumAnimation3();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImgLogoBack.setAnimation(logoAnimation);
        mImgLogoBack.setVisibility(View.VISIBLE);
    }

    private void startPremiumAnimation1(){
        Animation premiumAnimation1 = AnimationUtils.loadAnimation(this, R.anim.premium_animation);
        premiumAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                startPremiumAnimation2();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImgPremium1 = (ImageView)findViewById(R.id.img_premium1);
        mImgPremium1.setAnimation(premiumAnimation1);
        mImgPremium1.setVisibility(View.VISIBLE);
    }
    private void startPremiumAnimation2(){
        Animation premiumAnimation2 = AnimationUtils.loadAnimation(this, R.anim.premium_animation);
        premiumAnimation2.setStartOffset(500);
        premiumAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                startPremiumAnimation3();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImgPremium2 = (ImageView)findViewById(R.id.img_premium2);
        mImgPremium2.setAnimation(premiumAnimation2);
        mImgPremium2.setVisibility(View.INVISIBLE);
    }

    private void startPremiumAnimation3(){
        Animation premiumAnimation3 = AnimationUtils.loadAnimation(this, R.anim.premium_animation);
        premiumAnimation3.setStartOffset(1000);
        premiumAnimation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImgPremium3 = (ImageView)findViewById(R.id.img_premium3);
        mImgPremium3.setAnimation(premiumAnimation3);
        mImgPremium3.setVisibility(View.INVISIBLE);
    }


    public int getDisplayHeight(){
        int SCREEN_HEIGHT = 0;
        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= 13){
            Point outSize = new Point();
            display.getSize(outSize);
            SCREEN_HEIGHT = outSize.y;

        }else{
            SCREEN_HEIGHT = display.getHeight();

        }
        return SCREEN_HEIGHT;
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
