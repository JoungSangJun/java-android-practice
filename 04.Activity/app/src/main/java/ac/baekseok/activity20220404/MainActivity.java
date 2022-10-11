package ac.baekseok.activity20220404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mainBtn1,mainBtn2,mainBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBtn1 = (Button) findViewById(R.id.mainBtn1);
        mainBtn2 = (Button) findViewById(R.id.mainBtn2);
        mainBtn3 = (Button) findViewById(R.id.mainBtn3);
        //버튼 클릭시 두번째 화면으로 전환,Intent클래스가 다른 화면에 정보를 넘김
        mainBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity에서 activity로 정보전달 intent 클래스가 함
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });//화면을 하나 만들면 어플리케이션 정보로 등록해야함.
            //Manifests폴더에 AndroidMainifestxml에 추가함.

        mainBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity에서 activity로 정보전달 intent 클래스가 함
                Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                startActivity(intent);
            }
        });

        mainBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //activity에서 activity로 정보전달 intent 클래스가 함
                Intent intent = new Intent(getApplicationContext(),FourthActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate
}//MainActivity