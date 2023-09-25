package workjava;

public class Cloneee implements Cloneable {
	private String name;
	
	public Cloneee() {
		
	}
	
	public Cloneee(String name) {
		this.name = name;
	}
	
	@Override
	protected Cloneee clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Cloneee)super.clone();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{"+name+"}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

