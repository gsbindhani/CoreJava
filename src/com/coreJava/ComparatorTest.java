package com.coreJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	
	public static void main(String[] args) {

		class Employee{
			private String empName;
			private int empId;
			
			public void setEmpName(String empName) {
				this.empName = empName;
			}
			public void setEmpId(int empId) {
				this.empId = empId;
			}
			
			@Override
			public String toString() {
				return "Employee [empName=" + empName + ", empId=" + empId + "]";
			}
		}
		
		
		Employee emp = new Employee();
		emp.setEmpName("A");
		emp.setEmpId(1);
		Employee emp1 = new Employee();
		emp1.setEmpName("B");
		emp1.setEmpId(2);
		Employee emp2 = new Employee();
		emp2.setEmpName("C");
		emp2.setEmpId(3);
		Employee emp3 = new Employee();
		emp3.setEmpName("A");
		emp3.setEmpId(4);
		Employee emp4 = new Employee();
		emp4.setEmpName("B");
		emp4.setEmpId(5);
		
		
		List<Employee> li = new ArrayList<Employee>();
		li.add(emp1);
		li.add(emp2);
		li.add(emp3);
		li.add(emp4);
		li.add(emp);
		
		System.out.println(li);
		li.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				int result = o1.empName.compareToIgnoreCase(o2.empName);
				if(result == 0)
					result = o1.empId - (o2.empId);
				return result;
			}
		});
		
		System.out.println(li);
		
	}

}
