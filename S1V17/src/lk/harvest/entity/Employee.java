package lk.harvest.entity;

import java.time.LocalDate;
import lk.harvest.util.regex.*;

public class Employee{  

    private int id;
    //@Pattern(regexp = "^[a-zA-Z]{4,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$")
    private String name;
    private LocalDate dob;
    private Gender gender;
    private String nic;
    private String mobile;
    private String email;
    private Designation designation;
    private StatusEmployee statusEmployee ;


    public Employee(){ }

        public void setId(int id){ this.id = id; }
        public int getId(){ return id; }

        @Pattern(regexp = "^[a-zA-Z]{4,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$")
        public void setName(String name){ this.name = name; }
        public String getName(){ return name; }

        public void setDob(LocalDate dob){ this.dob = dob; }
        public LocalDate getDob(){ return dob; } 

        public void setGender(Gender gender){ this.gender = gender; }
        public Gender getGender(){ return gender; }

        @Pattern(regexp = "^[0-9+]{9}[V|X]$|^[0-9+]{12}$")
        public void setNic(String nic){ this.nic = nic; }
        public String getNic(){ return nic; }

        @Pattern(regexp = "^0[0-9]{9}$")
        public void setMobile(String mobile){ this.mobile = mobile; }
        public String getMobile(){ return mobile; }

        @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
        public void setEmail(String email){ this.email = email; }
        public String getEmail(){ return email; } 

        public void setDesignation(Designation designation){ this.designation = designation; }
        public Designation getDesignation(){ return designation; }

        public void setStatusEmployee(StatusEmployee statusEmployee){ this.statusEmployee = statusEmployee; }
        public StatusEmployee getStatusEmployee(){ return statusEmployee; }

    
}