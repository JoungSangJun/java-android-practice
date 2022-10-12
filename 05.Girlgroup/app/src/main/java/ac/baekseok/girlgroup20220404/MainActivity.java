package ac.baekseok.girlgroup20220404;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInsert, btnSelect, btnDelete, btnUpdate,btnInit;
    SQLiteDatabase sqlDB; //getWritableDatabase() 메소드사용
    //데베 사용할면 테이블에 레코드에 접근하려면, 데베 열어야함(읽기전용, 쓰기전용,쓰고나면 닫기)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtName = (EditText) findViewById(R.id.edtName);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnInit = (Button) findViewById(R.id.btnInit);
        myHelper = new myDBHelper(this);//본 화면에 생성

        //클릭시 1건에 내용 저장
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭시 1건의 정보 테이블에 저장, 데베 생성
                sqlDB = myHelper.getWritableDatabase();//쓰기전용으로 DB열기
                //1건의 정보를 테이블에 레코드로 저장
                sqlDB.execSQL("INSERT INTO groupTBL VALUES('" +
                        edtName.getText().toString() + "', " +
                        edtNumber.getText().toString() + ");");

                sqlDB.close(); //데베 닫기

                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_LONG).show();
            }
        });

        //조회 버튼 내가 입력한 정보를 연두색, 파랑색 EditText에 출력
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //groupDB읽어오기
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;//배열구조의 정보를 저장하는 클래스
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);//모든 레코드 불러와라,select조회는 rawQuery(),Qurey()
                String strNames = "그룹이름 \r\n ----------\r\n";//걸그룹이름만 모아보자
                String strNumbers = "그룹인원 \r\n ----------\r\n";

                while (cursor.moveToNext()) { //다음 레코드가 있냐?
                    strNames += cursor.getString(0) + "\r\n";//cursor 0열 데이터 가져와라
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }//onClick
        });//btnSelect

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //내용수정, primary key는 수정되지 않는다.
                sqlDB = myHelper.getWritableDatabase(); //쓰기로 열기
                //edtNmae 공백 아니면 실행
                if(edtName.getText().toString() != ""){
                    sqlDB.execSQL("UPDATE groupTBL SET gNumber ="
                            + edtNumber.getText()+" WHERE gName ='"
                            + edtName.getText().toString()+"';");//수정하는 쿼리문 동작

                }//if
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_LONG).show();
                btnSelect.callOnClick();//클릭메소드 호줄해라.
            }
        });//btnUpdate

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                if(edtName.getText().toString() != ""){
                    sqlDB.execSQL("DELETE FROM gruopTBL WHERE gName ='"+edtName.getText().toString()+"';");
                }//if
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"삭제됨",Toast.LENGTH_LONG).show();
                btnSelect.callOnClick();//조회버튼 클릭이벤트
            }
        });//btnDelete

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
                btnSelect.callOnClick();
            }
        });//btnInit

    }//onCreate()


    //데이터베이스를 만들기 위한 클래스 추가(SQLiteOpenHelper)추가
    public class myDBHelper extends SQLiteOpenHelper {
        //DB생성,테이블 생성 클래스
        public myDBHelper(Context context) { //데이터베이스 생성
            super(context, "groupDB", null, 1);//groupDB라는 데베 생성
        }//myDBHelper()
        //SQLiteOpenHelper 필수 메소드 2개
        //onCreate()메소드에서 테이블 생성, onUpgrade(테이블 삭제, 다시생성)

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) { //테이블 생성
            sqLiteDatabase.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY,gNumber INTEGER);");//데베 명령어(쿼리Query)를 처리함,테이블 생성 커리
            //항목(필드)간의 구분은 ,(쉼표)하고,PRIMARY KEY 걸그룹은 식별 키, 테이블명이 groupTBL이고 항목명 gName
        }//onCreate

        //테이블 있으면 테이블 내용 삭제하고 다시 생성
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//int i는 old 테이블명, i1 새로 생성 테이블명
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS groupTBL");//테이블 삭제해라,동일한 이름이 있으면, 테이블명 있냐 묻는 쿼리
            onCreate(sqLiteDatabase);
        }
    }//myDBHelper

}//MainActivity