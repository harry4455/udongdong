package com.example.jamleekim.startonc;

/**
 * Created by jamleekim on 2017-11-04.
 */

public class Team {
    private String teamid;
    private String teamname;
    private String teamregion;

    public Team(){

    }
    public Team(String teamname,String teamregion){
        this.teamname = teamname;
        this.teamregion = teamregion;
    }

    public Team(String teamid , String teamname,String teamregion){
        this.teamid = teamid;
        this.teamname = teamname;
        this.teamregion = teamregion;
    }
    public String getTeamname(){
        return teamname;
    }
    public String getTeamregion(){
        return teamregion;
    }
    public String getTeamid() {return teamid;}
    public void setTeamname(String teamname) { this.teamname = teamname;}
    public void setTeamregion(String teamregion) { this.teamregion = teamregion;}
    public void setTeamid(String teamid) { this.teamid = teamid;}
}
