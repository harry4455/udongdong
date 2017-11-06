package com.example.jamleekim.startonc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Member;
import java.util.ArrayList;

/**
 * Created by jamleekim on 2017-11-04.
 */

public class MemberDataAdapter extends BaseAdapter {
    ArrayList<Team> datas;
    LayoutInflater inflater;
    private Context context;
    public MemberDataAdapter(Context context, LayoutInflater inflater, ArrayList<Team> datas){

        this.context = context;
        this.datas = datas;
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        return datas.size(); //datas의 개수를 리턴
    }
    @Override
    public Object getItem(int position) {
        return datas.get(position);//datas의 특정 인덱스 위치 객체 리턴.
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if( convertView==null){
            convertView= inflater.inflate(R.layout.list_row, null);}
        TextView text_name= (TextView)convertView.findViewById(R.id.teamName);
        TextView text_nation= (TextView)convertView.findViewById(R.id.teamRegion);
        text_name.setText( datas.get(position).getTeamname() );
        text_nation.setText( datas.get(position).getTeamregion() );
        Button button = (Button)convertView.findViewById(R.id.jointeambutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,TeamJoinActivity.class);
                context.startActivity(intent);
            }
        });



        return convertView;
    }
}
