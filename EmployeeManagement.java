import java.util.ArrayList;

public class EmployeeManagement {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    // ADD EMPLOYEE
    public void addEmployee(Employee e) {

        employees.add(e);
    }

    // VIEW EMPLOYEES
    public String viewEmployees() {

        if (employees.isEmpty()) {

            return "No Employees Available!";
        }

        String result = "";

        for (Employee e : employees) {

            result = result + e.display();
        }

        return result;
    }

    // UPDATE EMPLOYEE
    public boolean updateEmployee(int id, String name,
                                  String department, double salary) {

        for (Employee e : employees) {

            if (e.id == id) {

                e.name = name;
                e.department = department;
                e.salary = salary;

                return true;
            }
        }

        return false;
    }

    // DELETE EMPLOYEE
    public boolean deleteEmployee(int id) {

        for (Employee e : employees) {

            if (e.id == id) {

                employees.remove(e);

                return true;
            }
        }

        return false;
    }
}
