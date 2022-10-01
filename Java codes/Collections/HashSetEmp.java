package Collections;

import java.util.*;

class HashSetEmp{
	private int empNumber;
	private String name;

HashSetEmp(int empNumber,String name){
	this.empNumber=empNumber;
	this.name=name;
}

void disp(){
	System.out.println("emp no = "+empNumber + " and name = "+name);
}

String getName(){
	return (this.empNumber + " and " + this.name);
}

void setEmp(){
	empNumber=50;
	name="Gaurav";
}

public static void main(String arg[]){
	Set<HashSetEmp> hashset=new HashSet<HashSetEmp>();

	HashSetEmp emp1=new HashSetEmp(10,"Mary");
	emp1.disp();

	HashSetEmp emp2=new HashSetEmp(20,"Jerry");
	emp2.disp();
	hashset.add(emp1);
	hashset.add(emp2);
	emp2=emp1;

	emp2.disp();
	hashset.add(emp2);
	emp1.setEmp();

	Iterator<HashSetEmp> iterator = hashset.iterator();
    while (iterator.hasNext()){
		HashSetEmp o= (HashSetEmp) iterator.next();
		 System.out.println("emp = "+o.getName());
        }
	}
}