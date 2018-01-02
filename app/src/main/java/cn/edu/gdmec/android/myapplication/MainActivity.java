package cn.edu.gdmec.android.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void move(View view){
     //   Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        //传统动画
      // TranslateAnimation animation = new TranslateAnimation(0,200,0,0);
       // animation.setDuration(1000);
       // animation.setFillAfter(true);
        Button btn= (Button) findViewById(R.id.button);
       // btn.startAnimation(animation);
        //单独属性的动画效果，显示两个动画
//        ObjectAnimator.ofFloat(btn,"rotation",0,360F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(btn,"translationX",0,180F).setDuration(1000).start();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(btn, "rotation", 0, 180F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(btn, "translationX", 0, 180F);
        AnimatorSet set = new AnimatorSet();
      //  set.playTogether(animator1,animator2);
        //playSequentially（）先平移后旋转
        set.playSequentially(animator2,animator1);
        set.setDuration(1000);
        set.start();



    }
}
