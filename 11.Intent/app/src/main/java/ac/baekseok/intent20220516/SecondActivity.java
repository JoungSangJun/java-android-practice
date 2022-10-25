package ac.baekseok.intent20220516;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second Activity");

        //인텐트에서 변수 받아야함
        Intent inIntent = getIntent();
        //sum을 돌려줄 예정, hapValue라고 부름
        final int hapValue = inIntent.getIntExtra("Num1", 0) +
                inIntent.getIntExtra("Num2", 0);//가져오지 못하면 0처리
        Button secondBtn = (Button) findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메인화면으로 넘어가는 outIntent생성
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent); //결과 가지고 메인화면 이동
                finish();
            }
        });

    }
}
