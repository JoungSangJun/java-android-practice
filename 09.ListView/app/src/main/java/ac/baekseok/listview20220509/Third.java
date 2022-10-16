package ac.baekseok.listview20220509;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Third extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        Button thirdBtn = (Button) findViewById(R.id.thirdBtn);

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//현재화면을 닫으면 열려있는 화면이 나옴.
            }
        });

    }
}
