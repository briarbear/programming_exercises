package design_patterns.abstract_factory;

public class TCLFactory implements IFactory
{
    public Television produceTelevision()
    {
        return new TCLTelevision();
    }

    public AirConditioner produceAirConditioner()
    {
        return new TCLAirConditioner();
    }
}
