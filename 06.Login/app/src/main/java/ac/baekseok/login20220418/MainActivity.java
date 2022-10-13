package ac.baekseok.login20220418;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Join {
    EditText edtMainId, edtMainPw;
    Button btnMainLogin, btnMainJoin;
    int IdFlag = 0; //아이디일치 1 불일치 0
    int PwFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMainId = (EditText) findViewById(R.id.mainId);
        edtMainPw = (EditText) findViewById(R.id.mainPw);
        btnMainLogin = (Button) findViewById(R.id.mainLogin);
        btnMainJoin = (Button) findViewById(R.id.mainJoin);

        //[회원가입화면]으로 이동
        btnMainJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });//btnMainJoin

        btnMainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM JoinInfo", null); //회원정보 가져옴
                String edt1 = null; //아이디입력 edt의 공간 마련
                String pass1 = null;
                String edt2 = null;//DB에서 가입한 ID 공간마련
                String pass2 = null;

                int IdFlag = 0; //아이디일치 1 불일치 0
                int PwFlag = 0;
                //cursor에 저장 돼 있는 값과 입력 값 비교
                while (cursor.moveToNext()) {
                    edt2 = cursor.getString(0);//0열 가르킴
                    pass2 = cursor.getString(1);//1열 가르킴
                    edt1 = edtMainId.getText().toString();
                    pass1 = edtMainPw.getText().toString();

                    if (edt1.equals(edt2)) { //아이디 일치시
                        IdFlag = 1; //아이디는 일치

                        if(pass1.equals(pass2)){ //패스워드 일치시
                            PwFlag = 1;
                            //id일치, 비밀번호 일치
                            Toast.makeText(getApplicationContext(),"정상회원입니다.",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                            startActivity(intent);
                        }else{ //id일치,비밀번호 불일치
                            Toast.makeText(getApplicationContext(),"회원님 비밀번호 오류입니다.",Toast.LENGTH_LONG).show();

                        }
                    }//if
                    else{ //아이디 불일치시
                        //할 일 X
                    }

                }//while

                cursor.close();
                sqlDB.close();
                //미회원이라서 회원가입 해주세요
                if(IdFlag == 0 && IdFlag ==0){
                    Toast.makeText(getApplicationContext(),"아이디가 틀립니다. 회원가입해 주세요",Toast.LENGTH_LONG).show();
                }
            }
        });

    }//onCreate
}//MainActivity