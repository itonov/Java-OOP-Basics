package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employeesCount = Integer.parseInt(reader.readLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < employeesCount; i++) {
            String[] inputParams = reader.readLine().split(" ");
            String name = inputParams[0];
            double salary = Double.parseDouble(inputParams[1]);
            String position = inputParams[2];
            Department department = new Department(inputParams[3]);
            if (!departments.containsKey(department.getName())) {
                departments.put(department.getName(), department);
                departments.get(department.getName()).setEmployees(new ArrayList<>());
            }
            Employee employee = new Employee(name, salary, position, department);
            String email;
            int age;
            switch (inputParams.length) {
                case 5:
                    if (inputParams[4].matches("\\d+")) {
                        age = Integer.parseInt(inputParams[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        email = inputParams[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    if (inputParams[4].matches("\\d+")) {
                        age = Integer.parseInt(inputParams[4]);
                        email = inputParams[5];
                        employee = new Employee(name, salary, position, department, email, age);
                    } else {
                        email = inputParams[4];
                        age = Integer.parseInt(inputParams[5]);
                        employee = new Employee(name, salary, position, department, email, age);
                    }
                    break;
                default:
                    break;
            }

            departments.get(department.getName()).addEmployee(employee);
        }

        double highestSalary = 0.0;
        String neededDepartment = "";

        for (Map.Entry<String, Department> kvp : departments.entrySet()) {
            String departmentName = kvp.getKey();
            Department currentDepartment = kvp.getValue();
            if (highestSalary < currentDepartment.getAverageSalary()) {
                neededDepartment = departmentName;
                highestSalary = currentDepartment.getAverageSalary();
            }
        }

        List<Employee> neededEmployees = departments.get(neededDepartment).getEmployees();
        neededEmployees = neededEmployees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Highest Average Salary: " + neededDepartment);
        for (Employee employee : neededEmployees) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
