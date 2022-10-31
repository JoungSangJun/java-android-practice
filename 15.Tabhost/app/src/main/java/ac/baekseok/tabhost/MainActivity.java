package ac.baekseok.tabhost;


import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = getTabHost();

        //TabHost에 들어가는 구성요소는 TabSpec클래스 사용
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("TAG1").setIndicator("강아지");
        tabSpecSong.setContent(R.id.imageView1);//구성요소를 탭호스트에 추가
        tabHost.addTab(tabSpecSong);//추가해야함
        //1개의 탭 구성요소가 추가

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("TAG2").setIndicator("고양이");
        tabSpecArtist.setContent(R.id.imageView2);//구성요소를 탭호스트에 추가
        tabHost.addTab(tabSpecArtist);//추가해야함

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("TAG3").setIndicator("토끼");
        tabSpecAlbum.setContent(R.id.imageView3);//구성요소를 탭호스트에 추가
        tabHost.addTab(tabSpecAlbum);//추가해야함

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("말");
        tabSpec4.setContent(R.id.imageView4);//구성요소를 탭호스트에 추가
        tabHost.addTab(tabSpec4);//추가해야함
        //첫번째 보여지는 탭설정
        tabHost.setCurrentTab(0);
    }//onCreate()
}//MainActivity