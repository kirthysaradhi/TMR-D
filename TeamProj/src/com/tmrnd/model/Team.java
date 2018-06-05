package com.tmrnd.model;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    public String team_id;

    public Team(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
