package task_live_coding_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

     Map<String,Integer>persons = new HashMap<>();
     persons.put("Bob", 25);
     persons.put("Rob", 55);
     persons.put("Ron", 78);

        for (Map.Entry<String,Integer>person: persons.entrySet()
             ) {
            System.out.println(person);
        }
        System.out.println("=========");

        Iterator<Map.Entry<String,Integer>>iterator = persons.entrySet().iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
