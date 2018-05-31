package Tencent;

public interface TestA {
    default void hello(){
        System.out.println("dafault");
    }
}


interface TestB extends TestA{
    @Override
    default void hello() {
        System.out.println("testB");
    }
}

interface TestC extends TestA{
    @Override
    default void hello() {
        System.out.println("testC");
    }
}

class TestD implements TestB,TestC,TestA{


    @Override
    public void hello() {
        TestC.super.hello();  //选择C 的实现
//        TestA.super.hello();
    }

    public static void main(String[] args) {
            new TestD().hello();
        }
}

