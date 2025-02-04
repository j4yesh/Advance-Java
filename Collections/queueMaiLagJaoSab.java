package Collections;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;
public class queueMaiLagJaoSab {
    public static void main(String [] jayesh){
        Pair<Integer,Integer> pr = new Pair<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(55);
        q.add(56);
        q.add(57);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println("size"+q.size());
    }
}
