package ac.baekseok.Calculator20220314;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btnAdd,btnSub,btnDiv;
    TextView textResult;
    String num1,num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.Edit1);
        edt2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               num1 = edt1.getText().toString();
               num2 = edt2.getText().toString();
               result = Integer.parseInt(num1) + Integer.parseInt(num2);//형변환 메소드 사용,정수형으로 변환하는 메소드(String 변수)
               textResult.setText("계산결과 :"  + result.toString());
            }//onClick()
        });//btnAdd

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);//형변환 메소드 사용,정수형으로 변환하는 메소드(String 변수)
                textResult.setText("계산결과 :"  + result.toString());
            }//onClick()
        });//btnSub

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edt1.getText().toString();
                num2 = edt2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);//형변환 메소드 사용,정수형으로 변환하는 메소드(String 변수)
                textResult.setText("계산결과 :"  + result.toString());
            }//onClick()
        });//btnDiv

    }//onCreate()
}//MainActivity