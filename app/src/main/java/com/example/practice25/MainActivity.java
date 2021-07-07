package com.example.practice25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

// Intent : Activity에서 다른 Activity를 호출
// Intent를 통해 데이터를 다른 액티비티에 전달&반환
// Intent Messaging : 앱 실행시간 중 binding 하는 기법.
// 안드로이드의 binding : UI의 경우 프로그램 방식으로 설계하는 것이 아니라 프로그램과 연결하여

// 명시적 인텐트 : target을 명확하게 지정
// 암시적 인텐트 : target의 이름을 명확하게 지정하지 않음.
// 인텐트를 처리하는데 있어 가장 최적의 컴포넌트(앱)을 탐색해서 연결
// 다른 애플리케이션의 컴포넌트를 구동시키는데 활용

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sample1(View view) {
        // Action : 작업에 수행되는 행동(String type)
        // ACTION_VIEW : uri(문자열로 만든 정보)에 따라 해당 앱을 보여줌.
        // ACTION_DIAL : 전화거는 화면을 나타냄
        // ACTION_CALL : 바로 전화를 검

        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        startActivity(callIntent);
    }

    public void sample2(View view) {
        // URI(Uniform Resource Identifier)
        // 인터넷상에 있는 자원을 나타내는 유일한 주소
        // android에서 uri 정보를 저장하기 위해서 Uri 객체를 정의
        // ACTION_CALL 기능은 안드로이드 6.0부터 구글 정책에 따라
        // 실시간으로 권한을 허가 받도록 변경됨
        // 따라서 권한 획득을 위한 프로그램 과정이 필요함

        // 참고로 실제 폰에서 기능을 사용하기 위해서는
        // 아래와 같이 Manifests 파일내에
        // <application>태그 상단에 권한허가를 위한 코드를 기술
        // <uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>
        Uri number = Uri.parse("tel:1-555-521-5556");
        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(number);
        startActivity(callIntent);
    }

    public void sample3(View view) {
        // Telephone directory
        Uri phoneBook = Uri.parse("content://contacts/people");
        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(phoneBook);
        startActivity(callIntent);
    }

    public void sample4(View view) {
        // SMS
        Uri sms = Uri.parse("smsto:1-555-521-5556");
        Intent callIntent = new Intent(Intent.ACTION_SENDTO);
        // 실제 문자내용은 Intent를 통해서 전달
        callIntent.putExtra("sms body", "Hello guys");
        callIntent.setData(sms);
        startActivity(callIntent);
    }

    public void sample5(View view) {
        // GSP (지도좌표 : 위도, 경도)
        Uri map = Uri.parse("geo:35.70193832812302, 139.70278483068148");
        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(map);
        startActivity(callIntent);
    }

    public void sample6(View view) {
        // 웹 실행
        Uri web = Uri.parse("https://www.google.com/");
        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(web);
        startActivity(callIntent);
    }
}