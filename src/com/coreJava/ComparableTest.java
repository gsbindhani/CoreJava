package com.coreJava;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest{
	public static void main(String[] args) {
		

		class Employee implements Comparable<Object>{
			
			private String empName;
			private int empId;

			@Override
			public int compareTo(Object obj) {
				
				int result = this.empName.compareToIgnoreCase(((Employee)obj).empName);
				if(result == 0)
					result = this.empId - (((Employee)obj).empId);
				return result;
			}

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
		
		Collections.sort(li);
		System.out.println(li);
	}
	
}


