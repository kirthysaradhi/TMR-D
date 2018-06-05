package com.tmrnd.model;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class TeamSkill {

    public String teamId;
    public String skill;

    public TeamSkill(String teamId, String skill) {
        this.teamId = teamId;
        this.skill = skill;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
