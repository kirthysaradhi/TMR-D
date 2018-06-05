package com.tmrnd.com.tmrnd.daemon;

import com.tmrnd.process.*;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class DaemonProcessor {

    public static void main(String args[]) {

        DaemonProcessor object = new DaemonProcessor();
        object.waitMethod();

    }

    private synchronized void waitMethod() {

        while (true) {
            System.out.println("Executable Program which concurrently runs all the 3 threads ==> " + Calendar.getInstance().getTime());

            TeamSkillReader teamSkillReader = new TeamSkillReader();
            teamSkillReader.setDaemon(true);
            teamSkillReader.start();

            TeamReader teamReader = new TeamReader();
            teamReader.setDaemon(true);
            teamReader.start();

            TaskReader taskReader = new TaskReader();
            taskReader.setDaemon(true);
            taskReader.start();

            /*TeamReaderDB testReader = new TeamReaderDB();
            testReader.setDaemon(true);
            testReader.start();*/
            try {
                this.wait(10000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}
