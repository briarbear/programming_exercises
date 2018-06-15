package test;

public class T2 {
    public static void main(String[] args) {
        int[] n = new int[]{1};
        System.out.println("");


        A a1 = new A();
        a1.a = 12;
        A a2 = new A();
        a2.a = 13;
        a1 = a2;
        p(a1);
        System.out.println(a1.a);
    }

    public static int p(A a){
        System.out.println("");
        A a3 = new A();
        a3.a = 14;
        a = a3;
        a3.a = 14;
        return 0;
    }


}



class A {
    int a;
}