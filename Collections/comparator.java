package Collections;
import java.util.*;

class Bike implements Comparable<Bike>{
    public int engine;
    Bike(int engine){
        this.engine=engine;
    }

    @Override
    public int compareTo(Bike b){
        return b.engine-this.engine;
    }
}

public class comparator {
    public static void main(String [] jayesh){
        List<Bike> list=new ArrayList<>();
        list.add(new Bike(8));
        list.add(new Bike(7));
        list.add(new Bike(6));
        list.add(new Bike(5));
        
        Collections.sort(list,(a,b) ->Integer.compare(a.engine,b.engine));

        // Collections.sort(list, (a, b) -> Integer.compare(a.engine, b.engine));

        // Collections.sort(list,Comparator.comparing(a->a.engine).reversed());
        // Collections.sort(list, Comparator.comparingInt(car -> car.engine).reversed());

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).engine);
        }
    }
}
