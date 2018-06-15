package design_patterns.simple_factory.example04;

public class Client {
    public static void main(String[] args) throws Exception {
        TV tv = TVFactory.produceTV("Haier");
        tv.play();
    }
}
