package ac.baekseok.listview2_20220523;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //리스트 항목 인스턴스 생성
        final ArrayList<String> midList = new ArrayList<String>();

        ListView list = (ListView) findViewById(R.id.listView1);
        //리스트 형태 글자 설정 위한 arrayAdapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        final EditText edtItem = (EditText) findViewById(R.id.edtItem);
        final Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged(); //변경된 항목 반영
                edtItem.setText(""); //edtItem 공란 만들기
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //몇 번째 항목 클릭했는지는 i
                midList.remove(i); //리스트뷰에서 해당항목 삭제
                adapter.notifyDataSetChanged(); //변경된 항목 반영ㅁㄴ

                return false; //누르지 않은 상태
            }
        });
    }
}