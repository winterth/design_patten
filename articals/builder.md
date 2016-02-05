# 结构

![](http://www.dofactory.com/images/diagrams/net/builder.gif)

> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

> ---   《设计模式：可复用面向对象软件的基础》3.2

- ↑↑↑ 图片盗自 http://www.dofactory.com/net/builder-design-pattern

# 逻辑

- 用户持有Director，Director中有抽象Builder作为成员
- 初始化Director时可以传入具体Builder的对象
- Builder中有创建Product的方法（这个“方法”就是普通口语中的“方法”，不是java中方法的概念），该方法包含多个步骤
- 每个不同的具体产品，具有相同或相似的创建步骤，并且具有相同的顺序，但每个步骤的实现不同
- Director的Construct()根据一定的顺序调用所有的BuildPart()
- 用户用Director对象调用其Construct()方法，Construct()方法根据Director中的具体builder创建具体的Product

# 实现

假设现在我们要装修厨房，每户人家的厨房都装修得不一样，但步骤不外乎如下几个（省略铺砖过程）：

- 装地柜
- 装水槽
- 装燃气灶
- 装吊柜
- 装油烟机
