package hashAndEquals;

public class Employee {


	private int id;
	private String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	/*public int hashCode()
	{
		return id * 31;
	}*/
	
	public boolean equals( Object obj )
	{
		boolean flag = false;
		Employee emp = ( Employee )obj;
		if( emp.id == this.id )
			flag = true;
		return flag;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
