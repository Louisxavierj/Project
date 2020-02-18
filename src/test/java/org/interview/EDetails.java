package org.interview;

import java.util.ArrayList;
import java.util.List;

public class EDetails extends Employee {
public static void main(String[] args) {
	
	List<Employee> emp = new ArrayList<Employee>();
	Employee e = new Employee();
	e.setId(12);
	e.setName("xavier");
	
	Employee e1 = new Employee();
	e1.setId(127);
	e1.setName("louis");
	
	emp.add(e1);
	emp.add(e);
	for (Employee x : emp) {
		System.out.println(x.getId());
		System.out.println(x.getName());
		
	}
	
	
	
	
	
}
}
