package JavaEight.StreamAPI;
import java.util.*;
import java.util.stream.*;
public class streamAPI {
    public static void main(String [] jayesh){
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(6);
        list1.add(7);
        list1.add(9);
        list1.add(10);
        list1.add(12);
        list1.add(13);

        List<String> stream1 = list1.stream()
                                 .sorted((x,y)->{
                                    return x-99+y;
                                 })
                                 .filter(i->(i!=6))
                                 .map(i-> (i%2==0)?"even":"odd")
                                 .collect(Collectors.toList());
        stream1.stream()
                .forEach(System.out::println);

        Integer num = Stream.iterate(0,i->i+1)
                        .limit(3)
                        // .forEach(System.out::println)
                        .peek(System.out::println)
                        .map(i->i-10)
                        .peek(System.out::println)
                        .sorted((a,b)->(a-b))
                        .peek(System.out::println)
                        .max((a,b)->(a-b)).get();

        System.out.println("nums"+ num);

        List<String> arl= Stream.iterate(0, i->i+1)
                                .limit(8)
                                .filter(i->(i+1!=66))
                                .map(i->i-9)
                                .sorted(Comparator.reverseOrder())
                                .map(i->" "+i.toString())
                                .collect(Collectors.toList());

        System.out.println(arl);
        
        List<Integer> aa= Arrays.asList(23,12,34,43,54).stream()
         .sorted((a,b)->Integer.compare(b,a))
         .peek(System.out::println)
        //  .forEach(System.out::println)
         .collect(Collectors.toList());
                                 

         Integer num1 = 
         Arrays.asList(23,12,34,43,54).parallelStream()
         //  .forEach(System.out::println)
         .sorted((a,b)->Integer.compare(b,a))
        //  .peek(System.out::println)
         .max((a,b)->(a-b)).get();

         System.out.println("num1: "+num1);


         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        numbers.stream()
               .filter(ee -> ee % 2 == 0)
               .forEach(ee -> System.out.println(ee));
    }
}
