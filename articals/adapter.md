# 结构

![](http://www.dofactory.com/images/diagrams/net/adapter.gif)

> 将一个类的接口转换成客户希望的另外一个接口。 Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。  

> ---   《设计模式：可复用面向对象软件的基础》4.1

- ↑↑↑ 图片盗自 http://www.dofactory.com/net/adapter-design-pattern

# 逻辑

- Adapter持有Adaptee的对象
- 用户持有由Target具体化为Adapter
- Adapter的Request()调用Adaptee的SpecificRequest()
- 用户调用Adapter的Request()，实现调用SpecificRequest()

# 实现

假设我们公司现在2种软件工程的模型：瀑布模型和原型模型。项目A使用瀑布模型，项目B使用原型模型。

先看软件工程的实现：

```java
// 软件工程的接口
public interface ISoftwareProcess {
    void run();
}

// 瀑布模型
public class SoftwareProcessWaterfall implements ISoftwareProcess {
    @Override
    public void run() {
        System.out.println("Run the project under Waterfall");
    }
}

// 原型模型
public class SoftwareProcessPrototyping implements ISoftwareProcess {
    @Override
    public void run() {
        System.out.println("Run the project under Prototyping");
    }
}
```

下面是不同项目实践各自的软件工程：

```java
// 项目的抽象类
public class ProjectAbstract {
    // 所有项目都关联一个软件工程的实现
    // 以便执行不同模型的特有流程
    protected ISoftwareProcess process;
    public void develop() {}
}

// 项目A
public class ProjectA extends ProjectAbstract {
    public ProjectA(ISoftwareProcess process) {
        super.process = process;
    }
    @Override
    public void develop() {
        System.out.println("Developing ProjectA");
        process.run();
    }
}

// 项目B
public class ProjectB extends ProjectAbstract {
    public ProjectB(ISoftwareProcess process) {
        super.process = process;
    }
    @Override
    public void develop() {
        System.out.println("Developing ProjectB");
        process.run();
    }
}
```

最后是客户端的实现：

```java
public class Main {
    public static void main(String[] args) {
        ISoftwareProcess waterFall = new SoftwareProcessWaterfall();
        ISoftwareProcess prototyping = new SoftwareProcessPrototyping();

        ProjectA pa = new ProjectA(waterFall);
        pa.develop();
        
        ProjectB pb = new ProjectB(prototyping);
        pb.develop();
    }
}
```

现在，由于行业的发展，前面2种模型有点跟不上版本发布的节奏了。公司决定将项目B改用业界流行的敏捷开发试点，如果效果好，推广到所有项目。可是公司内部并没有这样一套流程。所以，决定从外部引进。

```java
public class SoftwareProcessAgileFromOtherCompany {
    public void scrum() {
        System.out.println("Run the project under Scrum");
    }
}
```

问题来了，原来的项目B中有一个`ISoftwareProcess`，而现在不需要了，转而需要引进`SoftwareProcessAgileFromOtherCompany`的对象。为了不改动`ProjectB`的代码，我们引入了一个适配器。

```java
public class SoftwareProcessAgileAdapter implements ISoftwareProcess {
    private SoftwareProcessAgileFromOtherCompany agile;
    public void run() {
        agile = new SoftwareProcessAgileFromOtherCompany();
        agile.scrum();
    }
}
```

适配器实现了`ISoftwareProcess`的`run()`方法，而这个`run()`方法实际上执行的就是敏捷开发的流程。这样一来，就不需要修改`ProjectB`的代码了，只需要在客户端中稍加改动：

```java
public class Main {
    public static void main(String[] args) {
        ISoftwareProcess waterFall = new SoftwareProcessWaterfall();
        
        // 这里不再用原型模型了
        // ISoftwareProcess prototyping = new SoftwareProcessPrototyping();
        
        // 改用敏捷
        SoftwareProcessAgileAdapter agile 
            = new SoftwareProcessAgileAdapter();

        ProjectA pa = new ProjectA(waterFall);
        pa.develop();
        
        // 将敏捷开发的对象传入ProjectB
        ProjectB pb = new ProjectB(agile);
        pb.develop();
    }
}
```

以上便是适配器模型的框架。当存在现有2套代码的接口无法兼容时，为了让`Target`能在不改动代码的情况下使用`Adaptee`，用适配器包装一下。
