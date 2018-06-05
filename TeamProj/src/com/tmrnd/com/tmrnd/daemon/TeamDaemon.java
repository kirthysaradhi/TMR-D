package com.tmrnd.com.tmrnd.daemon;

/**
 * Created with IntelliJ IDEA.
 * User: saradhid
 * Date: 6/5/18
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class TeamDaemon {

        public static void main(String[] args) {
            /*new WorkThread().start();

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                // handle here exception
            }*/

            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                WorkThread worker = new WorkThread();
                // schedule task to execute at fixed rate
                //scheduledThreadPool.scheduleAtFixedRate(worker, 0, 10,
                        //TimeUnit.SECONDS);
            }

            System.out.println("Main Thread ending") ;
        }


}
