import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException; 

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

public class EmployeeDao{ 

    public static List<Employee> get(String qry){ 

        List<Employee> employees = new ArrayList();

        try{ 
            
            ResultSet rslt = CommonDao.get(qry);

                while(rslt.next()){ 

                    Employee employee = new Employee();

                    employee.setId(rslt.getInt("id"));
                    employee.setName(rslt.getObject("name").toString() );
                    employee.setNic(rslt.getObject("nic").toString() );
                    employee.setDob(LocalDate.parse(rslt.getObject("dob").toString()) );
                    employee.setMobile(rslt.getObject("mobile").toString() );
                    employee.setEmail(rslt.getObject("email").toString() ); 

                    employee.setDesignation( DesignationDao.getById( rslt.getInt("designation_id")));
                    employee.setStatusEmployee( StatusEmployeeDao.getById( rslt.getInt("statusEmployee_id")));
                    employee.setGender( GenderDao.getById( rslt.getInt("gender_id"))); 

                    employees.add(employee);
                }
        }

        catch(SQLException e){ 
            System.out.println("Can't Connect as : "+ e.getMessage());
        }

        return employees;

    } 

    public static List<Employee> getAll(){ 

        String qry = "select * from employee";
        List<Employee> employees = get(qry);
        return employees;

    } 

    public static List<Employee> getAllByName(String name){ 

        String qry = "select * from employee where name like '"+name+"%'";
        List<Employee> employees = get(qry);
        return employees;

    } 

    public static List<Employee> getAllByGender(Gender gender){ 

        String qry = "select * from employee where gender_id = "+ gender.getId() +"";
        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByNameAndGender(String name , Gender gender){ 

        String qry = "select * from employee where name like '"+name+"%' and gender_id = "+ gender.getId() +"";
        List<Employee> employees = get(qry);
        return employees;

    }

    public  static Employee getByNic(String nic){
        Employee employee =null;
        
        String qry = "select * from employee where nic ='"+nic+"'";
        try{
            ResultSet rslt = CommonDao.get(qry); 
            if(rslt!=null && rslt.next()){
    
                employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getObject("name").toString());
                employee.setNic(rslt.getObject("nic").toString());
                employee.setDob(LocalDate.parse(rslt.getObject("dob").toString() ) );
                employee.setMobile(rslt.getObject("mobile").toString());
                employee.setEmail(rslt.getObject("email").toString());
    
                employee.setDesignation(DesignationDao.getById(rslt.getInt("designation_id") ) );
                employee.setGender(GenderDao.getById(rslt.getInt("gender_id") ) );
                employee.setStatusEmployee(StatusEmployeeDao.getById(rslt.getInt("statusEmployee_id") ) );
            }
    
        }catch(SQLException e1){
            System.out.println("Can't Connect as : " + e1.getMessage());
        }
    
        return employee;
    }
    
    public static String save(Employee employee){
        
        String msg="0";
    
        String sql ="insert into employee(name,dob,gender_id,nic,mobile,email,designation_id,statusemployee_id) Values('"+
            employee.getName()+"','"+
            employee.getDob().toString()+"',"+
            employee.getGender().getId()+",'"+
            employee.getNic()+"','"+
            employee.getMobile()+"','"+
            employee.getEmail()+"',"+
            employee.getDesignation().getId()+","+
            employee.getStatusEmployee().getId()+")";
    
        msg = CommonDao.insert(sql);
        
        return msg;
    }
}