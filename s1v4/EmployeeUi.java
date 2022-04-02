import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Hashtable;
import java.time.LocalDate;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EmployeeUi extends JFrame{
//Goble Varible
        JTable tblEmployee;
        JComboBox<Object> cmbSearchGender;
        JTextField textSearchName;
        Vector titles;

        JTextField txtName;
        JTextField txtNic;
        JTextField txtMobile;
        JTextField txtEmail;

        JComboBox<Object> cmbGender;
        JComboBox<Object> cmblDesignation;
        JComboBox<Object> cmbStatusEmpolyee;
        
        JComboBox<Object> cmbDobYear;
        JComboBox<Object> cmbDobMonth;
        JComboBox<Object> cmbDobDay;


        JButton btnAdd;
        JButton btnClear;
        JButton btnUpdate;
        JButton btnDelet;

        Color valid;
        Color invalid;
        Color initial;

        List<Employee> emplist;
        List<Gender> genlist;
        List<Designation> deslist;
        List<StatusEmployee> selist;

       //Constracter
        EmployeeUi(){

        valid = new Color(200,255,200);
        invalid = Color.pink;
        initial = Color.white;

        setTitle("Employee Details(Harvest Super)");
        setLocation(300,200);
        setSize(660,700);

        Container con = getContentPane();
        FlowLayout lay1 = new FlowLayout();
        con.setLayout(lay1);

        //Leble
        JLabel lblNmae = new JLabel("Name  : ");
        JLabel lblDob = new JLabel("DOB  : ");
        JLabel lblGender = new JLabel("      Gender  : ");
        JLabel lblNic = new JLabel("NIC  : ");
        JLabel lblMobile= new JLabel("Mobile NO : ");
        JLabel lblEmail = new JLabel("Email  : ");
        JLabel lblDesignation = new JLabel("Designation  : ");
        JLabel lblStatus = new JLabel("     StatusEmployee  : ");
       
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
        JLabel lblFormEnd2 = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblFormEnd);
        con.add(lblFormEnd2);
        
        JLabel lblSearchNmae = new JLabel("Name  : ");
        textSearchName = new JTextField(20);
        JLabel lblSearchGender = new JLabel("Gender  : ");
        cmbSearchGender =new JComboBox();
        JButton btnSearchClear =new JButton("Clear Search");
        JButton btnSearch =new JButton("Search");
            
        con.add(lblSearchNmae);
        con.add(textSearchName);
        con.add(lblSearchGender);
        con.add(cmbSearchGender);
        
        JLabel lblfristEnd4 = new JLabel("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblfristEnd4);
        
        con.add(btnSearchClear);
        con.add(btnSearch);
        
       JLabel lblSeconEnd = new JLabel("\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
      con.add(lblSeconEnd);
      JLabel lblSeconEnd2 = new JLabel("\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
      con.add(lblSeconEnd2);

      //Table
        titles = new Vector();
        titles.add("Name");
        titles.add("Dob");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Desgination");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data,titles);
        tblEmployee = new JTable();

        tblEmployee.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize( new Dimension(550,200));
        jspTable.setViewportView(tblEmployee);

        con.add(jspTable);

     
        btnSearch.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnSearchAp(e);  }  } );
        btnSearchClear.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnSearchClearAp(e);  }  } );
        
        btnAdd.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnAddAp(e);  }  } );
        tblEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent e) {
              tblEmployeeVC(e);
          }
        });
   


        intitialize();


    }
  //Method
public void intitialize(){

    loadform();
    loadView();

}
public void loadform(){
//Gender
  genlist = GenderController.get();
  Vector<Object> genders = new Vector();
  genders.add("Select a Gender");

  for(Gender gen: genlist){
      genders.add(gen);         
      
   }
  
  DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel(genders);
  cmbGender.setModel(genModel); 

//Designation
  deslist = DesignationController.get();
  Vector<Object> designations = new Vector();
  designations.add("Select a Designation");

  for(Designation des: deslist){
    designations.add(des);         
      
   }
  
  DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
  cmblDesignation.setModel(desModel); 

   
//StatusEmployee
selist = StatusEmployeeController.get();
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

  //DobManth

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
    emplist = EmployeeController.get(null);
    fillTable(emplist);

    List<Gender> genlist = GenderController.get();
    Vector<Object> genders = new Vector();
    genders.add("Select a Gender");

    for(Gender gen: genlist){
        genders.add(gen);         
        
     }
    
    DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel(genders);
    cmbSearchGender.setModel(genModel); 



}


public void fillTable( List<Employee> employees){
  
    Vector data =new Vector();
    for(Employee emp: employees){
    Vector r = new Vector();
    r.add(emp.getName());
    r.add(emp.getDob().toString());
    r.add(emp.getNic());
    r.add(emp.getGender().getName());
    r.add(emp.getDesignation().getName());

    data.add(r);
    

}
DefaultTableModel dataModel = new DefaultTableModel(data, titles);
tblEmployee.setModel(dataModel);
 
}
public void btnSearchAp(ActionEvent e){

    String name  =textSearchName.getText();

    Object stitem = cmbSearchGender.getSelectedItem();
    Gender gender = null;

    if(!stitem.equals("Select a Gender"))
    gender = (Gender) stitem;   

  Hashtable<String,Object> ht = new Hashtable();
  ht.put("name",name);
  if(gender!=null) ht.put("gender",gender);

  emplist= EmployeeController.get(ht);
  fillTable(emplist);
}

public void btnSearchClearAp(ActionEvent e){

   int opt = JOptionPane.showConfirmDialog(null,"Are you sure to clear the clear");

    if(opt!=1){

    textSearchName.setText("");
    cmbSearchGender.setSelectedIndex(0);

   emplist = EmployeeController.get(null);
  fillTable(emplist);
}
}
public void btnAddAp(ActionEvent e){

    Employee employee = new Employee();  

    String error ="";
    
    //Name
    String name = txtName.getText();
    if(name.matches("^[A-Z][a-z]*$"))
        {
          employee.setName(name);
          txtName.setBackground(valid);
        }
    else
      {
        txtName.setBackground(invalid);
        error =error +"\n invalid Name";
      }
    
    //NIC
    String nic = txtNic.getText();
    if(nic.matches("^[0-9]{9}V$"))
      {
        employee.setNic(nic);
        txtNic.setBackground(valid);
      }
    else
    {
      txtNic.setBackground(invalid);
      error =error +"\n invalid NIC";
    }

    //Email
    String email = txtEmail.getText();
    if(email.matches("^[a-z]*@[a-z]*.[a-z]*$"))
      {
        employee.setEmail(email);
        txtEmail.setBackground(valid);
      }
    else
    {
      txtEmail.setBackground(invalid);
      error =error +"\n invalid Email";
    }
     
    //Mobile
    String mobile = txtMobile.getText();
    if(mobile.matches("^[0-9]{10}$"))
      {
        employee.setMobile(mobile);
        txtMobile.setBackground(valid);
      }
    else
    {
      txtMobile.setBackground(invalid);
      error =error +"\n invalid Mobile";
    }
  
    //Gender
    int gendindex = cmbGender.getSelectedIndex();
    if(gendindex != 0){
      cmbGender.setBackground(valid);
      employee.setGender((Gender)cmbGender.getSelectedItem() );
    }
    else{
      cmbGender.setBackground(invalid);
      error =error +"\n Gender Not selected";
    }
    //Designation
    int desindex = cmblDesignation.getSelectedIndex();
    if(desindex != 0){
      cmblDesignation.setBackground(valid);
      employee.setDesignation((Designation)cmblDesignation.getSelectedItem() );
    }
    else{
      cmblDesignation.setBackground(invalid);
      error =error +"\n Designation Not selected";
    }
    // StatusEmployee
    int Seindex = cmbStatusEmpolyee.getSelectedIndex();
    if(Seindex != 0){
      cmbStatusEmpolyee.setBackground(valid);
      employee.setStatusEmployee((StatusEmployee)cmbStatusEmpolyee.getSelectedItem() );
    }
    else{
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
    }
    else{
      cmbDobDay.setBackground(invalid);
    
    }
    if(monindex != 0){
      cmbDobMonth.setBackground(valid);
      mon = cmbDobMonth.getSelectedItem().toString();
      if(mon.length()==1) mon= "0" + mon;
    }
    else{
      cmbDobMonth.setBackground(invalid);
    
    }
    if(yerindex != 0){
      cmbDobYear.setBackground(valid);
      yer = cmbDobYear.getSelectedItem().toString();
    }
    else{
      cmbDobYear.setBackground(invalid);
    
    }
  



    if(dayindex != 0 && monindex !=0 && yerindex !=0 ){
      String dobs = yer+"-"+mon+"-"+day;
      LocalDate dob = LocalDate.parse(dobs);
      employee.setDob(dob);
    }
    else{
   
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
      }
    else{ 
    JOptionPane.showMessageDialog(null,error);

    }
      
}


public void tblEmployeeVC(ListSelectionEvent e)
{
 int row = tblEmployee.getSelectedRow(); 
 if(row>-1){
 Employee employee = emplist.get(row);
  fillForm(employee);
 }
}
public void fillForm(Employee employee){
  txtName.setText(employee.getName());
  txtNic.setText(employee.getNic());
  txtMobile.setText(employee.getMobile());
  txtEmail.setText(employee.getEmail());
  
  
  for(Gender gen: genlist){
  if(gen.equals( employee.getGender()))
  {
    cmbGender.setSelectedItem( gen );
    break;
  }    
    
 }
 for(Designation en: deslist){
  if(en.getId()==employee.getDesignation().getId())
  {
    cmblDesignation.setSelectedItem(en);
    break;
  }    
    
 }

 for(StatusEmployee se: selist){
  if(se.getId()==employee.getStatusEmployee().getId())
  {
    cmbStatusEmpolyee.setSelectedItem(se);
    break;
  }    
    
 }
 
cmbDobDay.setSelectedItem(employee.getDob().getDayOfMonth());
cmbDobMonth.setSelectedItem(employee.getDob().getMonthValue());
cmbDobYear.setSelectedItem(employee.getDob().getYear());

enabledButtons(false,true,true);
setStyle(valid);
}

   }
  
  