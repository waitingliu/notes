package objClone;

public class Pen implements Cloneable{
	String name;
	public String toString(){
		return "pen[name]="+name;
	}
	
	public Pen clone(){
		Pen pen = null;
		try {
			pen = (Pen)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return pen;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
