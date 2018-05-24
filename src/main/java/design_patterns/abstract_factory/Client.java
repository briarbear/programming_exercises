package design_patterns.abstract_factory;

public class Client {
    public static void main(String[] args) {
        IFactory factory;
        Television tv;
        AirConditioner ac;
        factory = (IFactory) ResourceUtils.getBean();

        tv = factory.produceTelevision();
        tv.play();
        ac = factory.produceAirConditioner();
        ac.changeTemperature();
    }
}
