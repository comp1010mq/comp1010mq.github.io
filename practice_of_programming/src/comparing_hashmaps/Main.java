package comparing_hashmaps;

import java.util.*;

public class Main{
    public static void main(String[] args){
        //final Map<Integer, String> map = new HashMap<>();
        final Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());

        final int targetKey = 650000;
        final String targetValue = "v";
        map.put(targetKey, targetValue);
        
        new Thread(() -> {
            long time = System.currentTimeMillis();
            for(int i = 0; i < targetKey; i++) {
                map.put(i, "someValue");
            }
            System.out.println(map.size());
            System.out.println("done! in " + (System.currentTimeMillis() - time) + " millis");
            System.exit(0);
        }).start();
        
        int problems = 0;
        while (true) {
            if (!targetValue.equals(map.get(targetKey))) {
                System.out.println("HashMap is not thread safe : " + problems);
                problems++;
            }
        }
    }


}