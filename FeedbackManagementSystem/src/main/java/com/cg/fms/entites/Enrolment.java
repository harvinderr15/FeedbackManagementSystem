package com.cg.fms.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Enrolment {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int id;
		@OneToOne(targetEntity = Employee.class)
		Employee employee;
		@OneToOne(targetEntity = Program.class)
		Program program;
		public Enrolment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Enrolment(int id, Employee employee, Program program) {
			super();
			this.id = id;
			this.employee = employee;
			this.program = program;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public Program getProgram() {
			return program;
		}
		public void setProgram(Program program) {
			this.program = program;
		}

	}


