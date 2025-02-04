
class Animal{
    public void bark(){
        System.out.println("barking");
    }
}

class Dog extends Animal{

    @Override
    public void bark(){
        System.out.println("overrided bark");
    }
    public void trytobark(){
        this.bark();
        super.bark();
    }
}

public class super1 {
    public static void main(String []jayesh){
        Dog dg = new Dog();
        dg.trytobark();
    }
}
