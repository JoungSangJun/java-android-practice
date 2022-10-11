package ac.baekseok.activity20220404;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    Button secondBtn;//메인으로 넘어가는 버튼
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //second.xml을 SecondActivity.java에 설정
        setContentView(R.layout.second);
        secondBtn = (Button) findViewById(R.id.secondBtn);

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity는 돌고 있으니 SecondActivity 종료하면 MainActivity가 나타남
                finish();//화면종료
            }
        });
    }
}//SecondActivity
