// https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html

package deadlock;

public class Main {
    
    public static void main(String[] args) {
        Friend alphonse =
            new Friend("Alphonse");
        Friend gaston =
            new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}