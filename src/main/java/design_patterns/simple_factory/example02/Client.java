package design_patterns.simple_factory.example02;

//在客户端代码中，我们通过调用工厂类的工厂方法即可得到产品对象，典型代码如下所示：
public class Client {
    public static void main(String args[]) {
        Product product;
        product = Factory.getProduct("A"); //通过工厂类创建产品对象
        product.methodSame();
        product.methodDiff();
    }
}
