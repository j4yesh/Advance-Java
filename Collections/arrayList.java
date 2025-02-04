package Collections;
import java.util.ArrayList;
import java.util.List;

public class arrayList {
    static public void printA(List<Integer> al) {
        System.out.println(al);
        // for (int i = 0; i < al.size(); i++) {
        // }System.out.print("/n");
    }
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(); 
        ArrayList alll = new List(); //not allo
        for(int i=0;i<7;i++){ 
            al.add(i);
        }
        printA(al);
        al.remove(4);
        printA(al);
        al.remove(Integer.valueOf(2));
        printA(al);
        al.set(0,99);
        printA(al);
        ArrayList al1 = (ArrayList)al; //down

        if(al.contains(Integer.valueOf(99))){
            System.out.println("available hai lala");
        }

        System.out.println("List: " + al);
    }
}
