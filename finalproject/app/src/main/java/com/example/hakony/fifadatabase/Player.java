package com.example.hakony.fifadatabase;

public class Player {

    private String uid;
    private String pos1;
    private String team_id;
    private String team_name;
    private String nation_squad_id;
    private String nation_squad_name;
    private String liveperfamount;
    private String name;
    private String pos;
    private String year;
    private String skill_level;
    private String attrA;
    private String year_short;
    private String avatar;
    private String club;
    private String national;
    private String pos1val;
    private String attrB;
    private String attrC;



    public Player() {

    }

    public Player (String uid, String pos, String team_id, String nation_squad_id, String name, String pos1, String pos1val, String year_short, String skill_level){
        this.uid = uid;
        this.pos = pos;
        this.pos1 = pos1;
        this.team_id = team_id;
        this.nation_squad_id = nation_squad_id;
        this.name = name;
        this.pos1val = pos1val;
        this.year_short = year_short;
        this.skill_level = skill_level;
        this.avatar = "https://s1.fifaaddict.com/fo4/players/"+uid+".png";
        this.club = "https://s1.fifaaddict.com/fo4/crests/small/l"+team_id+".png";
        this.national = "https://s1.fifaaddict.com/fo4/crests/small/l"+nation_squad_id+".png";
    };

    public Player(String uid, String pos1, String team_id, String team_name, String nation_squad_id, String nation_squad_name,
                  String liveperfamount, String name, String pos, String year, String skill_level, String attrA, String year_short,
                  String pos1val, String attrB, String attrC) {
        this.uid = uid;
        this.pos1 = pos1;
        this.team_id = team_id;
        this.team_name = team_name;
        this.nation_squad_id = nation_squad_id;
        this.nation_squad_name = nation_squad_name;
        this.liveperfamount = liveperfamount;
        this.name = name;
        this.pos = pos;
        this.year = year;
        this.skill_level = skill_level;
        this.attrA = attrA;
        this.year_short = year_short;
        this.pos1val = pos1val;
        this.attrB = attrB;
        this.attrC = attrC;
        this.avatar = "https://s1.fifaaddict.com/fo4/players/"+uid+".png";
        this.club = "https://s1.fifaaddict.com/fo4/crests/small/l"+team_id+".png";
        this.national = "https://s1.fifaaddict.com/fo4/crests/small/l"+nation_squad_id+".png";
    }

    public String getUid() {
        return uid;
    }

    public void setuid(String uid) {
        this.uid = uid;
    }

    public String getPos1() {
        return pos1;
    }

    public void setpos1(String pos1) {
        this.pos1 = pos1;
    }

    public String getPos1val() {
        return pos1val;
    }

    public void setpos1val(String pos1val) {
        this.pos1val = pos1val;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setteam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setteam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getNation_squad_id() {
        return nation_squad_id;
    }

    public void setnation_squad_id(String nation_squad_id) {
        this.nation_squad_id = nation_squad_id;
    }

    public String getNation_squad_name() {
        return nation_squad_name;
    }

    public void setnation_squad_name(String nation_squad_name) {
        this.nation_squad_name = nation_squad_name;
    }

    public String getLiveperfamount() {
        return liveperfamount;
    }

    public void setliveperfamount(String liveperfamount) {
        this.liveperfamount = liveperfamount;
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setpos(String pos) {
        this.pos = pos;
    }

    public String getYear() {
        return year;
    }

    public void setyear(String year) {
        this.year = year;
    }

    public String getSkill_level() {
        return skill_level;
    }

    public void setskill_level(String skill_level) {
        this.skill_level = skill_level;
    }

    public String getAttrA() {
        return attrA;
    }

    public void setattrA(String attrA) {
        this.attrA = attrA;
    }

    public String getAtrrB() {
        return attrB;
    }

    public void setattrB(String attrB) {
        this.attrB = attrB;
    }

    public String getAttrC() {
        return attrC;
    }

    public void setattrC(String attrC) {
        this.attrC = attrC;
    }

    public String getYear_short() {
        return year_short;
    }

    public void setyear_short(String year_short) {
        this.year_short = year_short;
    }

    public String getAvatar() {return avatar; };

    public void setAvatar() {this.avatar = "https://s1.fifaaddict.com/fo4/players/"+getUid()+".png"; };

    public String getClub() {return club; };

    public void setClub() {this.club = "https://s1.fifaaddict.com/fo4/crests/small/l"+getTeam_id()+".png"; };

    public String getNational() {return national; };

    public void setNational() {this.national = "https://s1.fifaaddict.com/fo4/crests/small/l"+getNation_squad_id()+".png"; };
}
