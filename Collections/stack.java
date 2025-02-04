package Collections;
import java.util.Stack;
public class stackThickHai {
    public static void main(String [] jayesh){
        Stack<String> st=new Stack<>();
        st.push("z900");
        st.push("zx10r");
        st.push("trimph");
        st.push("david putra");
        System.out.println(st);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        
    }    
}
