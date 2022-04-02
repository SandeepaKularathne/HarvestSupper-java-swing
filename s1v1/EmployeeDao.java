import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class EmployeeDao {

    public static List<Employee> getAll() {

        List<Employee> employees = new ArrayList();

        try {
            String qry = "select * from employee";
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {

                Employee employee = new Employee();

                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getObject("name").toString());
                employee.setNic(rslt.getObject("nic").toString());
                employee.setDob(LocalDate.parse(rslt.getObject("dob").toString()));
                employee.setMobile(rslt.getObject("mobile").toString());
                employee.setEmail(rslt.getObject("email").toString());
                
                employee.setDesignation( DesignationDao.getById( rslt.getInt("designation_id") ) );
                employee.setGender( GenderDao.getById( rslt.getInt("gender_id") ) );
                employee.setStatusemployee( StatusemployeeDao.getById( rslt.getInt("statusemployee_id") ) ); 

                employees.add(employee);
            }

        } catch (SQLException e) {
            System.out.println("Can't Get Results as : " + e.getMessage());
        }

        return employees;
    }

}



