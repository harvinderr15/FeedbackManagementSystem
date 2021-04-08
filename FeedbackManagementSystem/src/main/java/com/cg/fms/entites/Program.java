package com.cg.fms.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


	@Entity
	public class Program {
		@Id
		private String programId;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate startDate;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate endDate;
		@OneToOne(targetEntity = Employee.class)
		private Employee employee;
		@OneToOne(targetEntity = Course.class)
		
		private Course course;
		public Program() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @return the programId
		 */
		public String getProgramId() {
			return programId;
		}

		/**
		 * @param programId the programId to set
		 */
		public void setProgramId(String programId) {
			this.programId = programId;
		}

		/**
		 * @return the startDate
		 */
		public LocalDate getStartDate() {
			return startDate;
		}

		/**
		 * @param startDate the startDate to set
		 */
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		/**
		 * @return the endDate
		 */
		public LocalDate getEndDate() {
			return endDate;
		}

		/**
		 * @param endDate the endDate to set
		 */
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		/**
		 * @return the employee
		 */
		public Employee getEmployee() {
			return employee;
		}

		/**
		 * @param employee the employee to set
		 */
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		/**
		 * @return the course
		 */
		public Course getCourse() {
			return course;
		}

		/**
		 * @param course the course to set
		 */
		public void setCourse(Course course) {
			this.course = course;
		}

		public Program(String programId, LocalDate startDate, LocalDate endDate, Employee employee, Course course) {
			super();
			this.programId = programId;
			this.startDate = startDate;
			this.endDate = endDate;
			this.employee = employee;
			this.course = course;
		}
		
		
		
}
