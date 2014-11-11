package com.mfolivas.lambdas;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void shouldReturnAllEmployees() {
    Employee [] employees = {
        new Employee("Marcelo", "Olivas", BigDecimal.valueOf(10), "architecture"),
        new Employee("Tyler", "Frederic", BigDecimal.valueOf(33), "architecture"),
        new Employee("Mauricio", "Alarcon", BigDecimal.valueOf(34), "architecture"),
        new Employee("Ricardo", "Rocha", BigDecimal.valueOf(43), "development")
    };

    List<Employee> employeeList = Arrays.asList(employees);
    assertThat(
        employeeList.stream().filter(employee -> employee.getDepartment().equals("architecture"))
            .count(), is(3L));

    Predicate<Employee> isSalaryBetweenThirty = employee ->
        (employee.getSalary().doubleValue() >= 30 && employee.getSalary().doubleValue() < 40);

    Stream<Employee> employeesWithThirtySalary = employeeList.stream().filter(isSalaryBetweenThirty).sorted(
        Comparator.comparing(Employee::getSalary));
    assertThat(employeesWithThirtySalary.count(), is(2L));
    Optional<Employee> firstEmployee =
        employeeList.stream().filter(isSalaryBetweenThirty).findFirst();
    assertThat(firstEmployee.get(), is(new Employee("Tyler", "Frederic", BigDecimal.valueOf(33), "architecture")));

  }

}