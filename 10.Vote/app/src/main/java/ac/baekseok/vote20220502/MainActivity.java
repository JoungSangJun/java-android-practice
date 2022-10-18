package ac.baekseok.vote20220502;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정상준의 명화선호도 투표");
        final int voteCount[] = new int[9];
        for (int i = 0; i < voteCount[i]; i++) voteCount[i] = 0; //9개의 득표수를 0으로 초기화
        ImageView image[] = new ImageView[9];

        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양"
                , "잠자는 소녀", "테라스의 두자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
        //이미지를 누르면 득표수가 1씩 증가하는 처리
        for (int i = 0; i < imageId.length; i++) {
            final int index;
            index = i; //0~8차례로 들어감
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + ":총" + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                //인텐트에 값을 추가하는 것 putExtra()메소드
                intent.putExtra("VoteCount", voteCount);
                //이미지 이름도 intent 변수에 실음
                intent.putExtra("ImageName", imgName);
                startActivity(intent); //득표수 intent인스턴스에 실어서 전달
            }
        });
    }
}