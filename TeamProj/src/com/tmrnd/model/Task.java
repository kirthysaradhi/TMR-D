package com.tmrnd.model;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    public String taskId;
    public String skill;

    public Task(String taskId, String skill) {
        this.taskId = taskId;
        this.skill = skill;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
