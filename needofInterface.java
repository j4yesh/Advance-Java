interface computer{
    public void code();
}
class laptop implements computer{
    public void code(){
        System.out.println("compile the code");
    }
}

class desktop implements computer{
    public void code(){
        System.out.println("code compile run fast");
    }
}

class developer{
    public void devApp(computer l){
        l.code();
    }
}

class needofInterface{
    public static void main(String[]args){
        computer lp=new laptop();
        computer ds=new desktop();
        developer d=new developer();
        d.devApp(ds);
    }
}