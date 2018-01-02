package cn.edu.gdmec.android.myapplication;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AminationActivity extends AppCompatActivity implements View.OnClickListener{
    private int[] res = {R.id.imageView_a,R.id.imageView_b,
            R.id.imageView_c,R.id.imageView_d,
            R.id.imageView_e,R.id.imageView_f,
            R.id.imageView_g,R.id.imageView_h};
    //存储图片
    private List<ImageView> imageViewList = new ArrayList<ImageView>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amination);
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
                startAmin();
                break;
            default:
                break;
        }

    }

    private void startAmin() {
        //
        for (int i = 1; i < res.length; i++) {
            //ObjectAnimator animator=ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",);


        }

    }
}
