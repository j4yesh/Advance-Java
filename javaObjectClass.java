class obj1{
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class avaObjectClass {
    public static void main(String [] args){
        obj1 obj = new obj1();
        obj1 obj2 = new obj1();
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(  obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode()));
        System.out.println(obj.equals(obj2));
        System.out.println(obj.equals(obj));
        System.out.println(obj.getClass().getName()); //getclass cannot be overrrided
        //finalize used by garbage collector
        try{
            Object objCopy = obj.clone();
            System.out.println(objCopy.getClass());
        }catch(Exception e){

        }


    }
}
