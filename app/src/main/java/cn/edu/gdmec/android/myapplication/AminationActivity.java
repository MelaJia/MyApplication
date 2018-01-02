package cn.edu.gdmec.android.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AminationActivity extends AppCompatActivity implements View.OnClickListener{
    //存储图片ID
    private int[] res = {R.id.imageView_a,R.id.imageView_b,
            R.id.imageView_c,R.id.imageView_d,
            R.id.imageView_e,R.id.imageView_f,
            R.id.imageView_g,R.id.imageView_h};
    //存储图片
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amination);
        //给所有图片添加点击事件
        final ValueAnimator animator = ValueAnimator.ofInt(0,100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer animatedValue = (Integer) animator.getAnimatedValue();
            }
        });
        for (int i = 0; i < res.length; i++) {
            ImageView imageView= (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView_a:
                if (flag){
                    startAnim();
                }else {
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(this, "click"+ view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void closeAnim() {

        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator=ObjectAnimator.ofFloat(
                    imageViewList.get(i),"translationY",i * 220,0F);
            animator.setDuration(500);
            //设置插值器
            animator.setInterpolator(new BounceInterpolator());
            //一次弹出饿效果
            animator.setStartDelay(i * 300);
            animator.start();
            flag=true;



        }
    }

    private void startAnim() {
        //给每一个图片添加动画
        for (int i = 1; i < res.length; i++) {
           ObjectAnimator animator=ObjectAnimator.ofFloat(
                   imageViewList.get(i),"translationY",0F,i * 220);
            animator.setDuration(500);
            //设置插值器
            animator.setInterpolator(new BounceInterpolator());
            //一次弹出饿效果
            animator.setStartDelay(i * 300);
            animator.start();
            flag=false;



        }

    }
}
