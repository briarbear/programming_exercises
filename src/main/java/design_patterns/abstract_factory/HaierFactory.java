package design_patterns.abstract_factory;

public class HaierFactory implements IFactory
{
    public Television produceTelevision()
    {
        return new HaierTelevision();
    }

    public AirConditioner produceAirConditioner()
    {
        return new HairAirConditioner();
    }
}