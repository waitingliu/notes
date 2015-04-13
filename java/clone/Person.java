package objClone;

public class Person implements Cloneable{
	//注意:覆盖Object.clone()方法必须实现Cloneable接口,否则会在运行时抛出CloneNotSupportedException异常
	int age;
	String name;
	Pen pen = new Pen();
	public Person(int age,String name){
		this.age = age;
		this.name = name;
	}
	public String toString(){
		return "age:"+age+",name:"+name;
	}
	
	//覆盖Object的Clone方法
	//Object中的clone()返回值类型是Object,这里的返回值类型是Person,原因是从java1.5开始引入了协变返回类型
	//即:目前方法的返回类型可以是被覆盖的方法返回类型的子类
	public Person clone(){
		Person o = null;
		try {
			o = (Person)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		o.setPen(pen.clone());//修正需要修正的域:object.clone()是浅复制,需要用新对象引用替代原来的对象引用,变为深复制.
		return o;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
}
