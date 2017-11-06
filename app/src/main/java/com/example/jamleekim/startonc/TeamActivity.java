package com.example.jamleekim.startonc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Team> datas= new ArrayList<Team>();

    private ListView mListView;
    private FirebaseDatabase database;

    private String teamname;
    private String teamregion;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        overridePendingTransition(0, 0);//화면띄울때애니메이션효과없애기
        datas.add(new Team("chaos","아주대"));
        datas.add(new Team("abc","아주대"));
        datas.add(new Team("ameba","아주대"));
        datas.add(new Team("LP SUPPORT","서울"));
        mListView = (ListView)findViewById(R.id.listView);
        Context context = getApplicationContext();
        MemberDataAdapter adapter= new MemberDataAdapter(context,getLayoutInflater() , datas);
        mListView.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        Button b1 = (Button) findViewById(R.id.homebutton);
        Button b2 = (Button) findViewById(R.id.teambutton);
        Button b3 = (Button) findViewById(R.id.leaguebutton);
        Button b4 = (Button) findViewById(R.id.lockerbutton);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

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
        }
    }
    private long lastTimeBackPressed; // 뒤로가기 버튼이 터치된 시간.
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-lastTimeBackPressed < 1000){
            finish();
            return;
        }
        Toast.makeText(this,"'뒤로'버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }
}
