package db.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main( String[] args ) {
        DBWorker worker = new DBWorker();
        Connection connection = worker.getConnection();

        getAllEmployees(connection);
        getAllEmployeesDepartments(connection);
        getAverageSalary(connection);

    }

    // Get all employees (Task 3)
    private static void getAllEmployees(Connection connection){
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Query.GET_ALL_EMPLOYEES.value())){

            while (resultSet.next()){
                String lastName = resultSet.getString("last_name");
                int departmentId = resultSet.getInt("department_id");
                int salary = resultSet.getInt("salary");
                System.out.println(String.format("Employee last name: %s\tDepartment id: %d\tSalary: %d", lastName, departmentId, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all employees join with departments (Task 3)
    private static void getAllEmployeesDepartments(Connection connection){
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Query.GET_ALL_EMP_JOIN_WITH_DEPARTMENT.value())){

            while (resultSet.next()){
                String lastName = resultSet.getString("last_name");
                int departmentId = resultSet.getInt("department_id");
                int salary = resultSet.getInt("salary");
                String departmentName = resultSet.getString("department_name");
                System.out.println(String.format("Employee last name: %s\tDepartment id: %d\tSalary: %d\tDepartment name: %s", lastName, departmentId, salary, departmentName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get average salary (Task 3)
    private static void getAverageSalary(Connection connection){
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Query.GET_AVERAGE_SALARY.value())){

            while (resultSet.next()){
                String departmentId = resultSet.getString("department_id");
                String departmentName = resultSet.getString("department_name");
                double averageSalary = resultSet.getDouble("AVG(salary)");
                System.out.println(String.format("Department id: %s\tDepartment name: %s\tAverage salary: %.2f", departmentId, departmentName, averageSalary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
