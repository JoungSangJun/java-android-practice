package ac.baekseok.login20220418;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Join extends Activity {
    EditText jId, jPw;
    Button btnJoinRegistration, btnJoinMain;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join); //join.xml세팅
        jId = (EditText) findViewById(R.id.jId);
        jPw = (EditText) findViewById(R.id.jPw);

        btnJoinRegistration = (Button) findViewById(R.id.j_Registration);
        btnJoinMain = (Button) findViewById(R.id.j_main);
        myHelper = new myDBHelper(this);

        btnJoinRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원등록
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO JoinInfo VALUES('"+jId.getText().toString()+"','"+
                        jPw.getText().toString()+"');");//DB에 회원 레코드 정보 추가
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"가입됨",Toast.LENGTH_LONG).show();
            }
        });//btnJoinRegistration

        btnJoinMain.setOnClickListener(new View.OnClickListener() {
            @Override //메인으로 화면이동
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "LoginDB", null, 1);
        } //생성자로 DB생성

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE JoinInfo(uId Text, uPassword TEXT);");
        }//onCreate

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            //테이블 있으면 지우고 다시 생성
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JoinInfo");
            onCreate(sqLiteDatabase);
        }//onUpgrade
    }//myDBHelper

}//Join
