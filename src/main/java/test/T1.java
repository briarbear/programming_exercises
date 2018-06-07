package test;

public class T1 {

    public static void main(String[] args){

        Base  base = new Son();
        base.method();
        ((Son) base).methodB();
    }




}

class Base{
    public void method(){
        System.out.println("Base");
    }
}

class Son extends Base{
    @Override
    public void method() {
        System.out.println("Son");
    }

    public void methodB(){
        System.out.println("SonB");
    }
}

