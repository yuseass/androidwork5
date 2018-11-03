package com.example.sea.androidwork5;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.*;
import android.widget.ImageView;
import android.widget.Toast;

import static android.view.View.X;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    AnimationDrawable frameAnimation;

    float x0,y0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //播放动画的对象
        image=(ImageView)findViewById(R.id.img);

        x0=image.getX();
        y0=image.getY();

        //找到父View对象, 删除控件只能由父控件来完成
        final ViewGroup parent=(ViewGroup)findViewById(R.id.parent);



        //设置控件背景显示图片，frame.xml为前面写的帧动画xml文件
        image.setBackgroundResource(R.drawable.frame);
        frameAnimation=(AnimationDrawable) image.getBackground();



        image.setOnLongClickListener(listener2);




        parent.setOnTouchListener(listener1);



    }

    View.OnTouchListener listener1=new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

       //     Toast.makeText(MainActivity.this,"keyi",Toast.LENGTH_SHORT).show();





//位移动画 从左到右参数分别为
//x轴方向起始位置x差值 ,x轴方向结束位置x差值 , y轴方向起始位置y差值 ,y轴方向结束位置y差值

            float fromXDelta=x0;
            float toXDelta=event.getX();
            float fromYDelta=y0;
            float toYDelta=event.getY();

            x0=toXDelta;
            y0=toYDelta;


//通过控件的背景获取动画对象
            //image.setBackgroundResource(R.drawable.frame);





            frameAnimation.start(); //开始播放动画




            TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);


				//设置动画显示时间
            translateAnimation.setDuration(3000);
            translateAnimation.setFillAfter(true);
            translateAnimation.setStartOffset(0);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                //移动结束停止眨眼
                @Override
                public void onAnimationEnd(Animation animation) {
                    frameAnimation.stop();

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });



            image.startAnimation(translateAnimation);




            return false;


        }


    };

    View.OnLongClickListener listener2=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            AnimationSet animation=new AnimationSet(true);

            ScaleAnimation animation1=new ScaleAnimation( 1.0f,  0.5f,   1.0f,  0.5f,             Animation.RELATIVE_TO_SELF,   0.5f,
                    Animation.RELATIVE_TO_SELF,   0.5f);
            animation1.setDuration(3000);
            animation1.setFillAfter(true);



            final ScaleAnimation animation2=new ScaleAnimation( 1.0f,  1f,   1.0f,  1f,             Animation.RELATIVE_TO_SELF,   0.5f,
                    Animation.RELATIVE_TO_SELF,   0.5f);
            animation2.setDuration(3000);
            animation2.setFillAfter(true);


            final AlphaAnimation animation3=new AlphaAnimation(1, 0);
            animation3.setFillAfter(true);
            animation3.setDuration(1000);



            animation1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    image.startAnimation(animation2);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            animation2.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                        image.startAnimation(animation3);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });




            image.startAnimation(animation1);








            return false;
        }
    };





}
