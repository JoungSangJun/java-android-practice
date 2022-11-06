package ac.baekseok.webview20220604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUri;
    Button btnGo, btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUri = (EditText) findViewById(R.id.edtUri);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);
        web.setWebViewClient(new WebViewClient1());
        WebSettings webSet = web.getSettings(); //손가락으로 webSetting 클래스에 화면 확대 축소 기능
        webSet.setBuiltInZoomControls(true);
        web.loadUrl("http://www.naver.com"); //EditText에 있는 URL을 webView에 로딩하기

        //이동버튼동작
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(edtUri.getText().toString());
            }
        });//btnGo

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();//이전 상태로변경
            }
        });

    }//onCreate()

    //웹페이지로 로딩하는 클래스 추가
    class WebViewClient1 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return super.shouldOverrideUrlLoading(view, url);
        }
    }//webView.Client1


}//MainActivity