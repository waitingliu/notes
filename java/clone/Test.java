package objClone;

public class Test{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(18,"john");
		System.out.println(p);
		p.getPen().setName("sunday");
		//System.out.println("pen:"+p.getPen());
		Person newp = (Person)p.clone();
		System.out.println("1:"+p.getPen());
		System.out.println("2:"+newp.getPen());
		newp.getPen().setName("monday");
		System.out.println("3:"+newp.getPen());
		System.out.println("4:"+p.getPen());
		
		System.out.println(newp);
		//clone常被用来复制数组
		//all arrays are considered to implement the interface Cloneable and that the return type of the clone method of an array type T[] is T[] where T is any reference or primitive type.
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();
		System.out.println(b[4]);
		
	}

}
