package design_patterns.factory_method;
public class Client
{
    public static void main(String args[])
    {
        try
        {
            TV tv;
            TVFactory factory;
            factory= new HaierTVFactory(); //也可通过配置文件引入
            tv=factory.produceTV();
            tv.play();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}