package org.rudra.modelClass38;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee_38")
public class Employee {

 @Id
 @GenericGenerator(name = "custom_id", strategy = "org.rudra.modelClass38.CustomIdGenerator")
 @GeneratedValue(generator = "custom_id")
 @Column(name = "emp_id")
 private String empId;

 @Column(name = "first_name")
 private String firstName;

 @Column(name = "last_name")
 private String lastName;


 public String getEmpId() {
  return empId;
 }

 public void setEmpId(String empId) {
  this.empId = empId;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

}