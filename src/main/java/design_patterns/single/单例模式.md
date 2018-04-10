# 单例模式
-----
> 单例对象的类必须保证只有一个实例存在
- 懒汉式：指全局的单例实例在第一次被使用时构建
- 饿汉式：指全局单例实例在类装载时构建
------
## 1. 懒汉式单例
### 1.1 最简单版本
```java
//version1
public class Single1{
    private static Single1 instance;
    public static Single1 getInstance(){
        if (instance == null)
            instance = new Single1();
        
        return instance;
    }
}
```
或者进一步，把构造器改为私有，这样能够防止被外部的类调用。
```java
// Version 1.1
public class Single1 {
    private static Single1 instance;
    private Single1() {}
    public static Single1 getInstance() {
        if (instance == null) {
            instance = new Single1();
        }
        return instance;
    }
}
```
这种写法在大多数的时候也是没问题的。
问题在于，当多线程工作的时候，如果有多个线程同时运行到if (instance == null)，都判断为null，那么两个线程就各自会创建一个实例——这样一来，就不是单例了

------

### 1.2 synchronized版本 ['sɪŋkrənaɪzd] 　
```java
// Version 2 
public class Single2 {
    private static Single2 instance;
    private Single2() {}
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}
```
但是，这种写法也有一个问题：给gitInstance方法加锁，虽然避免了可能会出现的多个实例问题，但是会被强制除T1之外的所有线程等待，实际上会对程序的执行效率造成负面影响。

----


### 1.3 双重检查的版本（Double-Check）版本
Version2代码相对于Version1d代码的效率问题，其实是为了解决1%几率的问题，而使用了一个100%出现的防护盾。那有一个优化的思路，就是把100%出现的防护盾，也改为1%的几率出现，使之只出现在可能会导致多个实例出现的地方。
——有没有这样的方法呢？当然是有的，改进后的代码Vsersion3如下：
```java
//version3
public class Single3{
    private static Single3 instance;
    private Single3(){}
    public static Single3 getInstance(){
        if (instance == null){
            synchronized (Single3.class){
                if (instance == null)
                    instance = new Single3();
            }
        }
        
        return instance;
    }
}

```

这个版本的代码看起来有点复杂，注意其中有两次if (instance == null)的判断，这个叫做『双重检查 Double-Check』
- 第一个if (instance == null)，其实是为了解决Version2中的效率问题，只有instance为null的时候，才进入synchronized的代码段——大大减少了几率。
- 第二个if (instance == null)，则是跟Version2一样，是为了防止可能出现多个实例的情况
—— 这段代码看起来已经完美无瑕了。
……
……
……
—— 当然，只是『看起来』，还是有小概率出现问题的。
这弄清楚为什么这里可能出现问题，首先，我们需要弄清楚几个概念：原子操作、指令重排。
知识点：什么是指令重排？
> 简单来说，就是计算机为了提高执行效率，会做的一些优化，在不影响最终结果的情况下，可能会对一些语句的执行顺序进行调整
——也就是说，对于非原子性的操作，在不影响最终结果的情况下，其拆分成的原子操作可能会被重新排列执行顺序。
下面这段话直接从陈皓的文章(深入浅出单实例SINGLETON设计模式)中复制而来：

主要在于singleton = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
>  1. 给 singleton 分配内存
>  2. 调用 Singleton 的构造函数来初始化成员变量，形成实例
> 3. 将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
> 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。

-----

### 1.4 终极版本：volatile
对于Version3中可能出现的问题（当然这种概率已经非常小了，但毕竟还是有的嘛~），解决方案是：只需要给instance的声明加上volatile关键字即可，Version4版本：
```java
//Version4
public class Single4{
    private static volatile Single4 instance;
    private Single4(){}
    
    public static Single4 getInstance(){
        if (instance == null){
            synchronized (Single4.class){
                if (instance == null){
                    instance = new Single4();
                }
            }
        }
        return instance;
    }
}
```
- `volatile`关键字的一个作用就是禁止`指令重排`，把instance声明为`volatile`之后，对它的写操作就会有一个`内存屏蔽`，这样在它赋值之前，就不用调用读操作。
> 注意：volatile阻止的不singleton = new Singleton()这句话内部[1-2-3]的指令重排，而是保证了在一个写操作（[1-2-3]）完成之前，不会调用读操作（if (instance == null)）。

------

# 2. 饿汉式单例
> 如上所说，饿汉式单例是指：指全局的单例实例在类装载时构建的实现方式。

## 2.1 饿汉式单例的实现方式
```java
//饿汉式实现
public class SingleB {
    private static final SingleB INSTANCE = new SingleB();
    private SingleB() {}
    public static SingleB getInstance() {
        return INSTANCE;
    }
}
```

对于一个饿汉式单例的写法来说，它基本上是完美的了。
所以它的缺点也就只是饿汉式单例本身的缺点所在了——由于INSTANCE的初始化是在类加载时进行的，而类的加载是由ClassLoader来做的，所以开发者本来对于它初始化的时机就很难去准确把握：

- 可能由于初始化的太早，造成资源的浪费
- 如果初始化本身依赖于一些其他数据，那么也就很难保证其他数据会在它初始化之前准备好。
当然，如果所需的单例占用的资源很少，并且也不依赖于其他数据，那么这种实现方式也是很好的

## 2.2 其他的实现方式
### 2.2.1 Effective Java 1 —— 静态内部类
```java
// Effective Java 第一版推荐写法
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
这种写法非常巧妙：

 - 对于内部类SingletonHolder，它是一个饿汉式的单例实现，在SingletonHolder初始化的时候会由ClassLoader来保证同步，使INSTANCE是一个真·单例。
 - 同时，由于SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用，所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
——它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现。

-----


### 2.2.2 Effective Java 2 —— 枚举
```java
// Effective Java 第二版推荐写法
public enum SingleInstance {
    INSTANCE;
    public void fun1() { 
        // do something
    }
}

// 使用
SingleInstance.INSTANCE.fun1();

```

看到了么？这是一个枚举类型……连class都不用了，极简。
由于创建枚举实例的过程是线程安全的，所以这种写法也没有同步的问题。

作者对这方方法的评价：
> 这种写法在功能上与共有域方法相近，但是它更简洁，无偿地提供了序列化机制，绝对防止对此实例化，即使是在面对复杂的序列化或者反射攻击的时候。虽然这中方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。

-----


# 3. 总结
OK，看到这里，你还会觉得单例模式是最简单的设计模式了么？再回头看一下你之前代码中的单例实现，觉得是无懈可击的么？
可能我们在实际的开发中，对单例的实现并没有那么严格的要求。比如，我如果能保证所有的getInstance都是在一个线程的话，那其实第一种最简单的教科书方式就够用了。再比如，有时候，我的单例变成了多例也可能对程序没什么太大影响……
但是，如果我们能了解更多其中的细节，那么如果哪天程序出了些问题，我们起码能多一个排查问题的点。早点解决问题，就能早点回家吃饭……:-D

—— 还有，完美的方案是不存在，任何方式都会有一个『度』的问题。比如，你的觉得代码已经无懈可击了，但是因为你用的是JAVA语言，可能ClassLoader有些BUG啊……你的代码谁运行在JVM上的，可能JVM本身有BUG啊……你的代码运行在手机上，可能手机系统有问题啊……你生活在这个宇宙里，可能宇宙本身有些BUG啊……o(╯□╰)o
所以，尽力做到能做到的最好就行了。

—— 感谢你花费了不少时间看到这里，但愿你没有觉得虚度。

----

# 4. 一些有用的链接
- 深入浅出单实例SINGLETON设计模式：http://coolshell.cn/articles/265.html
- Java并发编程：volatile关键字解析：http://www.cnblogs.com/dolphin0520/p/3920373.html
- 为什么volatile不能保证原子性而Atomic可以？： http://www.cnblogs.com/Mainz/p/3556430.html
- 类在什么时候加载和初始化？http://www.importnew.com/6579.html

