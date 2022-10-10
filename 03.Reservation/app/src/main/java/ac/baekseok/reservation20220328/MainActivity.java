package ac.baekseok.reservation20220328;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView tv1;
    Integer selectYear = 0;
    Integer selectMonth = 0;
    Integer selectDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20173337 정상준 시간예약하기");
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        chrono = (Chronometer)findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        calView = (CalendarView) findViewById(R.id.calendarView1);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        tv1 = (TextView) findViewById(R.id.tv1);

        //화면을 보자마자 위젯 숨긴 상태 시작
        calView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        //예약시작버튼 누르면 시간증가 글자색 검은 -> 빨간
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setTextColor(Color.RED);
                chrono.setBase(SystemClock.elapsedRealtime());//시간초기화
                chrono.start();//크로노미터 타이머 시작
            }
        });//btnStart

        //날짜설정, 시간설정 각각의 라디오버튼 누르면, 각각의 위젯 보임
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //클릭시 캘린더보임
                calView.setVisibility(View.VISIBLE); //캘린더보임
                timePicker.setVisibility(View.INVISIBLE); //타임피커 숨김
            }
        });//rdoCal

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //클릭시 타임피커 보임
                timePicker.setVisibility(View.VISIBLE); //타임피커 보임
                calView.setVisibility(View.INVISIBLE); //캘린더 숨김
            }
        });//timePicker

        //카렌뷰에서 날짜가 변경됐을때 날짜 저장
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                //선택한 년 월 일, i year, i1 month, i2 dayOfMonth
                selectYear = i;
                selectMonth = i1 + 1; //i1은 0~11월로 나타냄
                selectDay = i2;
            }
        });

        //예약완료버튼 누르면 타이머정지, 글자는 파란색지정, tv1에 년월일시 예약함 표시
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop(); //타이머정지
                chrono.setTextColor(Color.BLUE); //글자색 파란색
                tv1.setText(Integer.toString(selectYear)+ "년 " +
                            Integer.toString(selectMonth)+ "월 " +
                            Integer.toString(selectDay) + "일 " +
                            Integer.toString(timePicker.getCurrentHour())+"시 " +
                            Integer.toString(timePicker.getCurrentMinute())+"분에 예약됨");

                if(selectYear < 1 || selectMonth < 1 || selectDay < 1){ //날짜선택 하지 않으면 오늘 날짜 가져옴
                    java.util.Calendar curDate = java.util.Calendar.getInstance();
                    curDate.setTimeInMillis(calView.getDate());
                    tv1.setText(Integer.toString(curDate.get(Calendar.YEAR))+"년" +
                            Integer.toString(curDate.get(Calendar.MONTH)+1) + "월" +
                            Integer.toString(curDate.get(Calendar.DATE)) + "일" +
                            Integer.toString(timePicker.getCurrentHour())+"시 " +
                            Integer.toString(timePicker.getCurrentMinute())+"분에 예약됨"
                    );
                };//tv1글자 세팅
            }
        });//btnEnd
        //날짜선택 안 하면 오늘날짜
        //연,월,일이 0이 있으면 날짜선택 안 한걸로 봄


    }//onCreate
}//MainActivity