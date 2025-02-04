package JavaEight.Lambda;

interface Bike{
    int getSpeed();
    int getEngine();
}

public class lambdaObject {
    public static void main(String[] args) {
        Bike b = new Bike(){
            @Override
            public int getSpeed(){
                return 5;
            }
            public int getEngine(){
                return 6;
            }
        };
        System.out.println(b.getEngine());
        System.out.println(b.getSpeed());
    }
}
