import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;


    public class EmployeeController{ 

        public static List<Employee> get(Hashtable<String , Object> ht){ 

            List<Employee> employees = new ArrayList<>(); 

            if(ht==null){ employees = EmployeeDao.getAll(); } 
            else{ 

                String name = (String) ht.get("name");
                Gender gender = (Gender) ht.get("gender");

                if(name==null)
                    employees = EmployeeDao.getAllByName(name);
                else if (gender==null)
                    employees = EmployeeDao.getAllByGender(gender);
                else
                    employees = EmployeeDao.getAllByNameAndGender(name, gender);

            }
            return employees;


    } 

    

}