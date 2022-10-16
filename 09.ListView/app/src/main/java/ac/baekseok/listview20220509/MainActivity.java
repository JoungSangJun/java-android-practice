package ac.baekseok.listview20220509;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트 정상준");
        final String[] mid = {"ICT개론", "IoT실습", "스마트폰프로그래밍","인공지능개론","해킹이론",
                              "VR실습","빅데이터","파이썬","C++","안드로이드프로그래밍","오픈소스플랫폼",
                              "스마트팜개론","웹서버시스템"};
        ListView list = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                mid); //나열되는 글자는 mid에 String타입 배열로 저장됨

        list.setAdapter(adapter); //list인스턴스에 설정
        //리스트의 나열된 항목 클릭시 다른 화면으로 이동하는 이벤트를 추가하자
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //리스트 몇번째 항목 클릭했는지는 i에 있음
                if(i==0){
                    Intent intent = new Intent(getApplicationContext(),Second.class);
                    startActivity(intent);
                }
                else if(i==1){
                    Intent intent = new Intent(getApplicationContext(),Third.class);
                    startActivity(intent);
                }
            }
        });

    }
}