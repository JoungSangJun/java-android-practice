package ac.baekseok.dialog20220516;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.mainBtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자 보여야함. 대화상자 인스턴스 생성

                final String[] versionArray = new String[]{"천안시", "아산시", "평택시"};
                final boolean[] checkArray = new boolean[]{true, false, false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                //대화상자 인스턴스에 속성설정 필드설정
                dlg.setTitle("정상준제목입니다.");
                //dlg.setMessage("내용에 해당되는 글자를 기술하세요.");//대화상자 내용표기
                //나열되는 선택항목을 배열, 체크상태 배열, Item 클릭이벤트
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        button1.setText(versionArray[i]);
                    }
                });

                //라디오버튼의 대화상자목록을 작성
               /* dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button1.setText(versionArray[i]);
                    }
                });*/

                /*dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button1.setText(versionArray[i]);
                    }
                });//setItems()*/

                dlg.setIcon(R.drawable.btn_star_big_on);
                dlg.setNegativeButton("취소(Cancel)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소눌림"
                                , Toast.LENGTH_LONG).show();
                    }
                });
                dlg.setPositiveButton("OK(확인)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인이 눌렸어요."
                                , Toast.LENGTH_LONG).show();
                    }
                });

                dlg.show();
            }
        });
    }
}