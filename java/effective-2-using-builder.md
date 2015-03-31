#遇到多个构造器参数时考虑使用Builder

当构造一个对象需要多个参数,并且其中有许多是可选参数:

##传统方法1. 编写大量构造器,涵盖所有参数组合的可能.

缺点:麻烦

##传统方法2. 使用JavaBeans模式

调用一个无参构造器创建对象,然后调用setter方法设置每个必要的参数.

```
Pizza pizza = new Pizza();
pizza.setCheese(3);
pizza.setOnion(1);
pizza.setBacon(4);
...
```
优点:可读性好
缺点:构造过程不是一次调用完成的,可能出现`不一致状态`.需要付出额外的代价保证线程安全.

##使用Builder:接合可读性和安全性

```
public class Pizza{
	private final int cheese;
	private final int tomato;
	private final int apple;
	private final int onion;
	private final int bacon;
	private final int oil;
	
	private Pizza(Builder builder){
		cheese = builder.cheese;
		tomato = builder.tomato;
		apple = builder.apple;
		onion = builder.onion;
		bacon = builder.bacon;
		oil = builder.oil;
	}
		
	public static class Builder{
		//必选参数
		private final int cheese;
		private final int oil;
		
		//可选参数初始化
		private int tomato = 0;
		private int onion = 0;
		private int bacon = 0;
		private int apple = 0;
		
		//在构造器中初始化必选参数		
		public Builder(int cheese, int oil){
			this.cheese = cheese;
			this.oil = oil;
		}
		
		//构建其他可选参数,返回Builder对象
		public Builder addTomato(int number){
			tomato = number;
			return this;
		}		
		public Builder addOnion(int number){
			onion = number;
			return this;
		}
		public Builder addApple(int number){
			apple = number;
			return this;
		}
		...
		
		//调用Pizza的构造器,并将builder作为参数传给他
		public Pizza build(){
			return new Pizza(this);
		}	
	}	
}
```
客户端代码:
```
Pizza normalPizza = new Pizza.Builder(3,2).addOnion(1).addTomato(1).addBacon(2).build();
```

##Builder暴露了构建对象所需的属性,隐藏了构建细节.

适用于构建复杂对象的场景(很多参数)

缺点:创建对象前,必须先创建它的构造器.多一项创建对象开销.

