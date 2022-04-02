import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Vector;
import java.util.List;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.util.Hashtable;
import java.time.LocalDate;


public class EmployeeUi extends JFrame{ 

    //Goble Varible

    JTable employeeTable;
    JScrollPane jspTable; 

    Vector titles;
    Vector data; 

    JTextField txtName;
    JTextField txtNic;
    JTextField txtMobile;
    JTextField txtEmail;

    JLabel lblSearchName;
    JTextField txtSearchName;
    JLabel lblSearchGender;

    JComboBox<Object> cmbGender;
    JComboBox<Object> cmblDesignation;
    JComboBox<Object> cmbStatusEmpolyee;

    JComboBox<Object> cmbSearchGender;

    JComboBox<Object> cmbDobYear;
    JComboBox<Object> cmbDobMonth;
    JComboBox<Object> cmbDobDay;

    JButton btnSearch;
    JButton btnSearchClear;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelet;

    Color valid;
    Color invalid;
    Color initial;
    
    //Constracter
    EmployeeUi(){ 
        
        valid = new Color(200,255,200);
        invalid = Color.pink;
        initial = Color.white;

        setTitle("Employee Details(Harvest Super) V3");
        setSize(550,600);
        setLocation(400,150); 

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
            con.setLayout(lay);
            
        //Lable
        JLabel lblNmae = new JLabel("Name  : ");
        JLabel lblDob = new JLabel("DOB  : ");
        JLabel lblGender = new JLabel("Gender  : ");
        JLabel lblNic = new JLabel("NIC  : ");
        JLabel lblMobile= new JLabel("Mobile NO : ");
        JLabel lblEmail = new JLabel("Email  : ");
        JLabel lblDesignation = new JLabel("Designation  : ");
        JLabel lblStatus = new JLabel("StatusEmployee  : ");

        //Text Filed
        txtName = new JTextField(52);
        txtNic = new JTextField(52);
        txtMobile = new JTextField(50);
        txtEmail = new JTextField(50);

        //ComboBox
        cmbGender =new JComboBox();
        cmblDesignation =new JComboBox();
        cmbStatusEmpolyee =new JComboBox();
        cmbDobYear =new JComboBox();
        cmbDobMonth =new JComboBox();
        cmbDobDay =new JComboBox();

        //Button
        btnAdd=new JButton("Add");
        btnClear =new JButton("Clear");
        btnUpdate =new JButton("Update");
        btnDelet =new JButton("Delet");

        JLabel lblEmpty= new JLabel("                                                                                                                                                                                                             ");

            con.add(lblNmae);
            con.add(txtName);
            con.add(lblDob);
            con.add(cmbDobYear); con.add(cmbDobMonth); con.add(cmbDobDay);
            con.add(lblGender);
            con.add(cmbGender);
            con.add(lblEmpty);
            con.add(lblNic);
            con.add(txtNic);
            con.add(lblMobile);
            con.add(txtMobile);
            con.add(lblEmail);
            con.add(txtEmail );
            con.add(lblDesignation);
            con.add(cmblDesignation);
            con.add(lblStatus);
            con.add(cmbStatusEmpolyee);

        JLabel lblfristEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            con.add(lblfristEnd);
        
            con.add(btnDelet);
            con.add(btnUpdate);
            con.add(btnClear);
            con.add(btnAdd);

        JLabel lblFormEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblFormEnd);
       

        lblSearchName  = new JLabel("Name :");
        txtSearchName  = new JTextField( 20 );
        lblSearchGender  = new JLabel("Gender :");
        cmbSearchGender  = new JComboBox();
        btnSearch  = new JButton("Search");
        btnSearchClear  = new JButton("SearchClear"); 

            con.add(lblSearchName);
            con.add(txtSearchName);
            con.add(lblSearchGender);
            con.add(cmbSearchGender);
            con.add(btnSearch);
            con.add(btnSearchClear);

        titles = new Vector();
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Designation"); 

        data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data,titles);
            employeeTable = new JTable();
            employeeTable.setModel(dataModel); 


        jspTable = new JScrollPane();
            jspTable.setPreferredSize( new Dimension(500,300) );
            jspTable.setViewportView( employeeTable );

        con.add(jspTable);
        
        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        btnAdd.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnAddAp(e);  }  } );
        intitialize(); 

        

    }

    //Method
    public void intitialize(){ 

        loadform();
        loadView();
    }

    public void loadform(){ 

        //Gender
        List<Gender> genlist = GenderController.get();
        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for(Gender gen: genlist){
            genders.add(gen);         
      
        }
  
        DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel(genders);
        cmbGender.setModel(genModel); 

        //Designation
        List<Designation> deslist = DesignationController.get();
        Vector<Object> designations = new Vector();
        designations.add("Select a Designation");

        for(Designation des: deslist){
            designations.add(des);         
        }
  
        DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
        cmblDesignation.setModel(desModel); 

   
        //StatusEmployee
        List<StatusEmployee> selist = StatusEmployeeController.get();
        Vector<Object> statusEmployees = new Vector();
        statusEmployees.add("Select StatusEmployee");

        for(StatusEmployee se: selist){
            statusEmployees.add(se);         
        }

        DefaultComboBoxModel<Object> seModel = new DefaultComboBoxModel(statusEmployees);
        cmbStatusEmpolyee.setModel(seModel); 

        //DobDay
        Vector<Object> DobDay = new Vector();
        DobDay.add("Selec Day");

        for(int i=1; i<=31;i++){
            DobDay.add(i);         
        }

        DefaultComboBoxModel<Object> dayModel = new DefaultComboBoxModel(DobDay);
        cmbDobDay.setModel(dayModel);

        //DobMounth
        Vector<Object> DobManth = new Vector();
        DobManth.add("Select Manth");
  
        for(int i=1; i<=12; i++){
            DobManth.add(i);         
        }

        DefaultComboBoxModel<Object> ManModel= new DefaultComboBoxModel(DobManth);
        cmbDobMonth.setModel(ManModel);

        //DobYear
        Vector<Object> DobYear = new Vector();
        DobYear.add("Select Year");
    
        for(int i=1980; i<=2005;i++){
            DobYear.add(i);         
        }
        cmbDobYear.setModel( new DefaultComboBoxModel(DobYear));

        txtName.setText("");
        txtNic.setText("");
        txtEmail.setText("");
        txtMobile.setText("");

        enabledButtons(true,false,false);
        setStyle(initial);

    }

    public void enabledButtons(boolean add, boolean upd,boolean delt){
        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelet.setEnabled(delt);

    }

    public void setStyle(Color clr){
  
        txtName.setBackground(clr);
        txtMobile.setBackground(clr);
        txtNic.setBackground(clr);
        txtEmail.setBackground(clr);


        cmblDesignation.setBackground(clr);
        cmbStatusEmpolyee.setBackground(clr);
        cmbGender.setBackground(clr);

        cmbDobDay.setBackground(clr);
        cmbDobMonth.setBackground(clr);
        cmbDobYear.setBackground(clr);
    }

    public void fillForm(){

        enabledButtons(false,true,true);
        setStyle(valid);
    }

    public void loadView(){
        
        List<Employee> emplist = EmployeeController.get(null);
        fillTable(emplist); 

        List<Gender> genlist = GenderController.get(); 
            Vector<Object> genders = new Vector();
            genders.add("Select Gender");

                for(Gender gen : genlist){ 

                    genders.add(gen);
                } 

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmbSearchGender.setModel(gndModel);
    }

    public void fillTable(List<Employee> employees){ 

        Vector data = new Vector();
        
        for(Employee emp : employees){ 

            Vector r1 = new Vector();
                r1.add( emp.getName());
                r1.add( emp.getDob().toString() );
                r1.add( emp.getNic() );
                r1.add( emp.getGender().getName() );
                r1.add( emp.getDesignation().getName() );
                data.add(r1);
        }
        
        DefaultTableModel model =  new DefaultTableModel(data , titles); 
        employeeTable.setModel(model);

        
    }

    
    public void btnSearchAp(ActionEvent e){ 

        String name = txtSearchName.getText();
        Object sitem = cmbSearchGender.getSelectedItem();
        Gender gender = null; 

        if(!sitem.equals("Select Gender"))
        gender = (Gender) sitem;

        Hashtable<String , Object> ht = new Hashtable();
        ht.put("name", name);
        if(gender!=null)ht.put("gender", gender);

        List<Employee> employees = EmployeeController.get(ht);
        fillTable(employees); 

    } 

    public void btnSearchClearAp(ActionEvent e){ 

        int opt = JOptionPane.showConfirmDialog(null,"Are you sure to Clear the Search");

        if(opt!=1){

        txtSearchName.setText(" ");
        cmbSearchGender.setSelectedIndex(0);

        List<Employee> employees = EmployeeController.get(null);
        fillTable(employees);  

        }
    }

    public void btnAddAp(ActionEvent e){

        Employee employee = new Employee();  
    
        String error ="";
        
        //Name
        String name = txtName.getText();
        if(name.matches("^[A-Z][a-z]*$")){
              employee.setName(name);
              txtName.setBackground(valid);
        }else{
            txtName.setBackground(invalid);
            error =error +"\n invalid Name";
        }
        
        //NIC
        String nic = txtNic.getText();
        if(nic.matches("^[0-9]{9}V$")){
            employee.setNic(nic);
            txtNic.setBackground(valid);
        }else{
          txtNic.setBackground(invalid);
          error =error +"\n invalid NIC";
        }
    
        //Email
        String email = txtEmail.getText();
        if(email.matches("^[a-z]*@[a-z]*.[a-z]*$")){
            employee.setEmail(email);
            txtEmail.setBackground(valid);
        }else{
          txtEmail.setBackground(invalid);
          error =error +"\n invalid Email";
        }
         
        //Mobile
        String mobile = txtMobile.getText();
        if(mobile.matches("^[0-9]{10}$")){
            employee.setMobile(mobile);
            txtMobile.setBackground(valid);
        }else{
          txtMobile.setBackground(invalid);
          error =error +"\n invalid Mobile";
        }
      
        //Gender
        int gendindex = cmbGender.getSelectedIndex();
        if(gendindex != 0){
          cmbGender.setBackground(valid);
          employee.setGender((Gender)cmbGender.getSelectedItem() );
        }else{
          cmbGender.setBackground(invalid);
          error =error +"\n Gender Not selected";
        }

        //Designation
        int desindex = cmblDesignation.getSelectedIndex();
        if(desindex != 0){
          cmblDesignation.setBackground(valid);
          employee.setDesignation((Designation)cmblDesignation.getSelectedItem() );
        }else{
          cmblDesignation.setBackground(invalid);
          error =error +"\n Designation Not selected";
        }

        // StatusEmployee
        int Seindex = cmbStatusEmpolyee.getSelectedIndex();
        if(Seindex != 0){
          cmbStatusEmpolyee.setBackground(valid);
          employee.setStatusEmployee((StatusEmployee)cmbStatusEmpolyee.getSelectedItem() );
        }else{
          cmbStatusEmpolyee.setBackground(invalid);
          error =error +"\n StatusEmployee Not selected";
        }
    
        //Day,manth,year
    
        int dayindex = cmbDobDay.getSelectedIndex();
        int monindex = cmbDobMonth.getSelectedIndex();
        int yerindex = cmbDobYear.getSelectedIndex();
    
        String day = "";
        String mon = "";
        String yer = "";
    
        if(dayindex != 0){
          cmbDobDay.setBackground(valid);
          day = cmbDobDay.getSelectedItem().toString();
          if(day.length()==1) day = "0" + day;
        }else{
          cmbDobDay.setBackground(invalid);
        }
        
        if(monindex != 0){
          cmbDobMonth.setBackground(valid);
          mon = cmbDobMonth.getSelectedItem().toString();
          if(mon.length()==1) mon= "0" + mon;
        }else{
          cmbDobMonth.setBackground(invalid);
        }

        if(yerindex != 0){
          cmbDobYear.setBackground(valid);
          yer = cmbDobYear.getSelectedItem().toString();
        }else{
          cmbDobYear.setBackground(invalid);
        }
      
        if(dayindex != 0 && monindex !=0 && yerindex !=0 ){
          String dobs = yer+"-"+mon+"-"+day;
          LocalDate dob = LocalDate.parse(dobs);
          employee.setDob(dob);
        }else{
       
          error =error +"\n selecte Birth Date";
        }
    
        if(error.isEmpty()){


            String cnfMsg = "Are you sure to save following Employee?\n\n";
            cnfMsg = cnfMsg+"\nName :" +employee.getName();
            cnfMsg = cnfMsg+"\nNic :" +employee.getNic();
            cnfMsg = cnfMsg+"\nDOB :" +employee.getDob().toString();
            cnfMsg = cnfMsg+"\nGender :" +employee.getGender().getName();
            cnfMsg = cnfMsg+"\nMobile :" +employee.getMobile();
            cnfMsg = cnfMsg+"\nEmail :" +employee.getEmail();
            cnfMsg = cnfMsg+"\nDesignation :" +employee.getDesignation().getName();
            cnfMsg = cnfMsg+"\nStatusEmployee :" +employee.getStatusEmployee().getName();
      
           int cof= JOptionPane.showConfirmDialog(null,cnfMsg);
      
      
            if(cof==0){
                String st= EmployeeController.post(employee);
                if(st.equals("1")){
                    loadView();
                    loadform();
                    JOptionPane.showMessageDialog(null,"Successfully saved");
                }else{
                  JOptionPane.showMessageDialog(null,"Faild to save as \n\n" +st);
                }
              
            }
        }else{ 
          JOptionPane.showMessageDialog(null,error);
      
        }
            
    }

}