package com.mfolivas.lambdas;

import java.math.BigDecimal;

/**
 * Domain class for an employee.
 */
public class Employee {

  private String firstName;
  private String lastName;
  private BigDecimal salary;
  private String department;


  public Employee(String firstName, String lastName, BigDecimal salary, String department) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.department = department;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Employee employee = (Employee) o;

    if (department != null ? !department.equals(employee.department)
                           : employee.department != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) {
      return false;
    }
    if (salary != null ? !salary.equals(employee.salary) : employee.salary != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (salary != null ? salary.hashCode() : 0);
    result = 31 * result + (department != null ? department.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Employee{" +
           "firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", salary=" + salary +
           ", department='" + department + '\'' +
           '}';
  }
}
