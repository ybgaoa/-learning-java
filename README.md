# Java设计模式<br>
## 一、概况<br>
		总体来说设计模式分为三大类：<br>
（1）创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
（2）结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
（3）行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

## 二、设计模式的六大原则

### 1、开闭原则（Open Close Principle）

开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。
### 2、里氏代换原则（Liskov Substitution Principle）

（1）子类的能力必须大于等于父类，即父类可以使用的方法，子类都可以使用。

（2）返回值也是同样的道理。假设一个父类方法返回一个List，子类返回一个ArrayList，这当然可以。如果父类方法返回一个ArrayList，子类返回一个List，就说不通了。这里子类返回值的能力是比父类小的。（3）还有抛出异常的情况。任何子类方法可以声明抛出父类方法声明异常的子类。而不能声明抛出父类没有声明的异常。

### 3、依赖倒转原则（Dependence Inversion Principle）

这个是开闭原则的基础，具体内容：面向接口编程，依赖于抽象而不依赖于具体。

### 4、接口隔离原则（Interface Segregation Principle）

这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。

### 5、迪米特法则（最少知道原则）（Demeter Principle）

为什么叫最少知道原则，就是说：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。

### 6、合成复用原则（Composite Reuse Principle）

原则是尽量使用合成/聚合的方式，而不是使用继承。
