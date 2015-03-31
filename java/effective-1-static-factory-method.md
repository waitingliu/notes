#考虑使用静态工厂方法代替构造器

最常用的获取类的对象的方法是提供一个public的构造器

另一种就是使用`静态工厂方法`

```
public static Configuration getInstance(String filename){
	return new Configuration(filename);
}
```

JDK中使用:`Pattern.compile()`,`Calendar.getInstance()`等.

##优点1. 有名字,代码更明确.

构造器名字都相同,只能通过参数去判断应该使用哪个.经常用错.
静态工厂方法可以使用更易识别的方法名.

##优点2. 不必在每次调用时常见一个新的对象 -- 对象可以被缓存并复用

程序经常请求创建相同对象,是一种开销上的浪费.
创建对象的代价是很高的.因此静态工厂方法可以提升性能.
在`不可变类`中有应用

##优点3. 可以返回一个`返回值类型的子类型`的对象

更大的灵活性

在许多框架中都用到此特性:

使用`接口`作为静态工厂方法的返回类型.
这样可以返回一个实现了此接口的类的对象
以这种方式隐藏了实现类,使得API变得简洁.

##优点4. 在创建参数化类型对象时更简洁

```
Map<String,List<String>> m = new HashMap<String,List<String>>();
```

使用静态工厂方法:

```
public static <K,V> HashMap<K,V> newInstance(){
	return new HashMap<K,V>();
}
```
编译器可以替你找到类型参数 (`类型推导`)

调用时只需:
```
Map<String,List<String>> m = HashMap.newInstance();
```


