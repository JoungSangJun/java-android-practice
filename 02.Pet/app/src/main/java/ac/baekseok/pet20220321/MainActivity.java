package ac.baekseok.pet20220321;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1; //좋아하는 애완동물은 텍스트뷰
    CheckBox chkAgree;//시작함 체크박스 위젯
    RadioGroup rGroup1;//전체 라디오그룹을 숨김/나타냄
    RadioButton rdoDog,rdoCat,rdoRabbit;
    Button btnOk;//선택함 버튼
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton)findViewById(R.id.RdoDog);
        rdoCat = (RadioButton)findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton)findViewById(R.id.RdoRabbit);
        btnOk = (Button) findViewById(R.id.btnOk);
        imgPet = (ImageView) findViewById(R.id.ImgPet);
        
        //체크가 변경될 때 수행되는 메소드 설정,체크상태 변경을 대기하는 메소드
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkAgree.isChecked()==true){
                    text1.setVisibility(View.VISIBLE);//클래스 보임
                    rGroup1.setVisibility(View.VISIBLE);//라디오그룹 보임
                    btnOk.setVisibility(View.VISIBLE);//선택완료버튼 보이기
                    imgPet.setVisibility(View.VISIBLE);//이미지뷰 보이기
                }
                else {//체크가 안되면 감추기
                    text1.setVisibility(View.INVISIBLE);//클래스 보임
                    rGroup1.setVisibility(View.INVISIBLE);//라디오그룹 보임
                    btnOk.setVisibility(View.INVISIBLE);//선택완료버튼 보이기
                    imgPet.setVisibility(View.INVISIBLE);//이미지뷰 보이기
                }
            }//onCheckedChanged
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //라디오버튼의 강아지고양이토끼 중의 하나를 선택하고[선택완료]누르면 처리(이미지뷰에 해당동물이 보임)
                switch (rGroup1.getCheckedRadioButtonId()){ //라디오그룹의 체크 된 버튼아이디 가져옴.
                    case R.id.RdoDog :
                        imgPet.setImageResource(R.drawable.dog);//이미지를 이미지뷰에 세팅(메개변수는 리소스 위치)
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_LONG).show();
                }//switch
            }
        });//btnOk버튼 클릭시 라디오그룹에서 선택한 동물 이미지 보여줌



    }//onCreate()
}//MainActivity