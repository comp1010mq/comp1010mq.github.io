import java.io.InputStream;
import java.net.URL;
import java.util.*;


public class ThreadState{

    static class SydneyTime{
        static SydneyTime instance = null;
        private SydneyTime(){}
        public static SydneyTime getInstance(){
            if (instance == null)
                instance = new SydneyTime();
            return instance;
        }
        public String getTime(){
            String ret;
            try{
                try{
                    Thread.sleep(new Random().nextInt(4000));
                }catch(Exception e){};
                InputStream is = (new URL("http://worldtimeapi.org/api/timezone/Australia/Sydney.txt")).openStream();
                Scanner scanner = new Scanner(is);
                for(int i = 0; i < 5; i++){scanner.next();}
                ret = scanner.next();
                scanner.close();
            } catch (Exception e){ // server gets annoyed and returns a 403 if you try too many at once.
                ret = "none";
            } 
            return ret;
        }
    }
    public static void main(String[] args){
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0; i < 10; i++){
            threads.add(new Thread(() -> SydneyTime.getInstance().getTime()));
        }
        System.out.println(showStates(threads));
        threads.forEach(t -> t.start());
        while(someAlive(threads)){
            try{Thread.sleep(200);}catch(Exception e){}
            System.out.println(showStates(threads));
        }
    }

    public static String ss(Thread one){
        switch (one.getState()){
            case NEW: return "*";
            case RUNNABLE: return "r";
            case TERMINATED: return "x";
            case WAITING: return "w";
            case BLOCKED: return "!";
            case TIMED_WAITING: return "t";
            default: return "?";
        }
    }

    public static String showStates(List<Thread> threads){
        StringBuilder sb = new StringBuilder();
        threads.forEach(t -> {
            sb.append(ss(t));
            sb.append('|');
        });
        return sb.toString();
    }

    public static boolean someAlive(List<Thread> threads){
        for(Thread t: threads){
            if(t.isAlive()){return true;}
        }
        return false;

    }
}