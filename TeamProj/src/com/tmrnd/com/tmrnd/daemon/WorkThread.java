package com.tmrnd.com.tmrnd.daemon;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
class WorkThread extends Thread {

    public WorkThread() {
        // When false, (i.e. when it's a user thread),
        // the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the Worker thread terminates when the main
        // thread terminates.
        setDaemon(true);
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Worker "+count++);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                // handle exception here
            }
        }
    }
}
