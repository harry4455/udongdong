package com.example.jamleekim.startonc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userInfo;
    private TextView useremail;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        overridePendingTransition(0, 0);//화면띄울때애니메이션효과없애기
        Button b1 = (Button) findViewById(R.id.homebutton);
        Button b2 = (Button) findViewById(R.id.teambutton);
        Button b3 = (Button) findViewById(R.id.leaguebutton);
        Button b4 = (Button) findViewById(R.id.lockerbutton);
        Button b5 = (Button) findViewById(R.id.logoutbutton);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
       // userInfo = (TextView)findViewById(R.id.userInfo) ;
        useremail = (TextView)findViewById(R.id.useremail);
        auth = FirebaseAuth.getInstance();
        //userInfo.setText(auth.getCurrentUser().getDisplayName());
        useremail.setText(auth.getCurrentUser().getEmail());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homebutton:
                Intent i1 = new Intent(this, HomeActivity.class);
                startActivity(i1);
                finish();
                break;
            case R.id.teambutton:
                Intent i2 = new Intent(this, TeamActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.leaguebutton:
                Intent i3 = new Intent(this, LeagueActivity.class);
                startActivity(i3);
                finish();
                break;
            case R.id.lockerbutton:
                Intent i4 = new Intent(this, LockerActivity.class);
                startActivity(i4);
                finish();
                break;
            case R.id.logoutbutton:
                Intent i5 = new Intent(this,LoginActivity.class);
                startActivity(i5);
                Toast.makeText(this, "로그아웃이 완료 되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
    private long lastTimeBackPressed; // 뒤로가기 버튼이 터치된 시간.
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-lastTimeBackPressed < 3000){
            finish();
            return;
        }
        Toast.makeText(this,"'뒤로'버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

}
