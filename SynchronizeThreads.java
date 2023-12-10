/* 
* Name: Lucas Hasting
* Class: CS 315-I01
* Instructor: Paul Zhang
* Date: 6/29/2023
* Description: test the difference between unsyncronized and syncronized threads
* Source: Intro to Java Programming, Comprehensive Version (10th edition) by Daniel Liang
*/

public class SynchronizeThreads {
    public static void main(String[] args) {
        // create num objects
        Num num = new Num(0);
        Num num2 = new Num(0);

        // Create tasks
        Runnable add = new AddOne(num);
        Runnable addSync = new AddOneSync(num2);

        // Create and start threads without syncronization
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(add);
            threads[i].start();
        }

        // Create and start threads with syncronization
        threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(addSync);
            threads[i].start();

            // wait for the threads to finish
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        // display the results
        System.out.println("Synced: " + num2.getNum());
        System.out.println("Not Synced: " + num.getNum());
    }
}

class Num {
    // declare private member variable value
    private Integer value;

    // constructor
    public Num(Integer value) {
        this.value = value;
    }

    // add 1 to value, not syncronized
    public void add() {
        value++;
    }

    // add 1 to value, syncronized
    public synchronized void addSync() {
        value++;
    }

    // getter for the value variable
    public Integer getNum() {
        return value;
    }
}

// The task class for adding one to a number, not syncronized
class AddOne implements Runnable {
    private Num num;

    /** Construct the task */
    public AddOne(Num n) {
        num = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {
        num.add();
    }
}

// The task class for adding one to a number, syncronized
class AddOneSync implements Runnable {
    private Num num;

    /** Construct the task */
    public AddOneSync(Num n) {
        num = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {
        num.addSync();
    }
}