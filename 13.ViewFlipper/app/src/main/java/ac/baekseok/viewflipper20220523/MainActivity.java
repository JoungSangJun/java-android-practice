package ac.baekseok.viewflipper20220523;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        //넘기는 시간 설정
        viewFlipper.setFlipInterval(1000);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //viewFlipper.showNext(); //뷰플리퍼에 속한 요소의 다음 화면 보여줌
                //다음버튼 누르면 자동으로 사진전환
                viewFlipper.startFlipping();
            }
        });//btnNext

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //viewFlipper.showPrevious(); //뷰플리퍼에 속한 요소의 이전 화면 보여줌
                //요소보여주기 멈춤
                viewFlipper.stopFlipping();
            }
        });//btnPrev

    }//onCreate
}//MainActivity