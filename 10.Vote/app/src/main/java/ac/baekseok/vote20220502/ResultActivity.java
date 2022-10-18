package ac.baekseok.vote20220502;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");

        Intent intent = getIntent();//인텐트 값을 가져옴
        int[] voteResult = intent.getIntArrayExtra("VoteCount"); //이전화면에 인텐트 배열을 가져옴
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tvTop = (TextView) findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView) findViewById(R.id.ivTop);
        Integer imageFieldID[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                R.drawable.pic9};

        //9개 중 가장 큰 값의 사진 가져옴
        int maxEntry = 0; //가장 큰 값 저장
        for (int i = 0; i < voteResult.length; i++) {
            if(voteResult[maxEntry]<voteResult[i])
                maxEntry = i;
        }

        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFieldID[maxEntry]);

        //텍스트뷰 레이팅바도 9개이므로 인스턴스 생성을9개 배열로 해보자.
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for (int i = 0; i < tv.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }
        for (int i = 0; i < tv.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
        //메인화면으로 돌아가기
        Button resultBtnReturn = (Button) findViewById(R.id.resultBtnReturn);
        resultBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
