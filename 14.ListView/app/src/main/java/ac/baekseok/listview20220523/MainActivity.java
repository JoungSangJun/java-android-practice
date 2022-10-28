package ac.baekseok.listview20220523;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰테스트");

        ListView list = (ListView) findViewById(R.id.listView1);
        final String[] mid = {"스마트폰프로그래밍", "객체지향프로그래밍", "인공지능", "AR/VR", "빅데이터", "머신러닝", "메타버스개론",
                "IoT센서와 디바이스", "IoT프로젝트", "창의기초프로젝트", "창의응용프로젝트", "웹프로그래밍",
                "캡스톤디자인", "파이썬과 데이터과학", "데이터시각화", "안드로이드프로그래밍", "UI/UX프로그래밍",
                "HTML5", "웹서버프로그래밍"};
        //리스트의 형태화 나열되는 글자 지정을 위한 ArrayAdapter클래스
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mid);

        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_LONG).show();
            }
        });

    }//onCreate()
}//MainActivity