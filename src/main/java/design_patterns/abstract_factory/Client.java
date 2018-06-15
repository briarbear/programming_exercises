package design_patterns.abstract_factory;

public class Client {
    public static void main(String[] args) {
        Factory factory;
        Television tv;
        AirConditioner ac;
        factory = (Factory) ResourceUtils.getBean();

        tv = factory.produceTelevision();
        tv.play();
        ac = factory.produceAirConditioner();
        ac.changeTemperature();
    }
}
