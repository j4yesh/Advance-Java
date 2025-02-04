import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class collections {
    public static void main(String[]args){
        
        // System.out.println("hi ");
        // ArrayList<Integer> al = new ArrayList<Integer>();
        // al.add(5);
        // al.add(5);
        // al.add(5);
        // al.add(55);
        // System.out.println(al.indexOf(55));
        // for(int i=0;i<al.size();i++){
        //     System.out.println(al.get(i));
        // }

        Comparator<String>com=new Comparator<String>()
        {
            public int compare(String i,String j){
                if(i.length()>j.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        List<String> seq= new ArrayList<>();
        seq.add("342432");
        seq.add("1232");
        seq.add("65");
        Collections.sort(seq,com);
        System.out.println(seq);
    }
    
}