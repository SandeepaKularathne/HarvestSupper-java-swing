import java.util.List;

public class EmployeeController {

    public static List<Employee> get() {

        List<Employee> employees = null; 

        employees = EmployeeDao.getAll();
        // If EmployeeDao.getAll() failed to give Employyee List 
        // Controller will try to get them from another source such as Calling Web Service....

        return employees;

    }

}

