package ac.baekseok.diary20220425;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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
                fileName = Integer.toString(i)+"_"+Integer.toString(i1+1)+"_"+Integer.toString(i2)+".txt";
               //readDiary(fileName);
            }
        });
    }//onCreate
}//MainActivity