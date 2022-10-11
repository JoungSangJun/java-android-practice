package ac.baekseok.activity20220404;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    Button thirdBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        thirdBtn = (Button) findViewById(R.id.thirdBtn);

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //이화면을 종료하면 백그라운드 MainActivity 나옴
            }
        });
    }//onCreate()
}//ThirdActivity
