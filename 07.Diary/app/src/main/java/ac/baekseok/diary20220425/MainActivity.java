package ac.baekseok.diary20220425;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정상준의 간단 일기장"); //액티비티 상단에 써지는 타이틀

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH); //월값 0~11월
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                //i년도, i1월, i2 일 값
                fileName = Integer.toString(i) + "_" + Integer.toString(i1 + 1) + "_" + Integer.toString(i2) + ".txt";
                //선택날 이미 화일이 있는지 보고 있으면 보여줌
                String str = readDiary(fileName);
                edtDiary.setText(str); //읽어온 선택날짜의 일기내용으로 내용 설정
                btnWrite.setEnabled(true);//버튼 활성화 처리
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override //쓰기버튼
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+"저장됨",Toast.LENGTH_LONG).show();
                } catch (IOException e) {


                }
            }
        });
    }//onCreate

    String readDiary(String fName) {
        String diaryStr = null;

        FileInputStream inFs;
        try { //화일 정상적으로 열렸을 때
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);//fName의 이름으로 화일 읽기 txt에 저장
            inFs.close();
            diaryStr = (new String(txt)).trim(); //앞 뒤 여백제거 trim()
            btnWrite.setText("수정하기");
        } catch (IOException e) { //안 열렸을 때
            edtDiary.setText("일기가 없습니다.");
            btnWrite.setText("새로저장");
        }


        return diaryStr;
    }

}//MainActivity