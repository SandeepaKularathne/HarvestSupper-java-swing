package lk.harvest.ui;

import lk.harvest.entity.Designation;
import lk.harvest.entity.Gender;
import lk.harvest.entity.Employee;
import lk.harvest.entity.StatusEmployee;

import java.time.ZoneId;

import lk.harvest.controller.EmployeeController;
import lk.harvest.controller.DesignationController;
import lk.harvest.controller.StatusEmployeeController;
import lk.harvest.controller.GenderController;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.List;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane; 

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.time.LocalDate;
import java.util.Hashtable;
import java.awt.Color; 

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EmployeeUi extends JFrame{ 

    JTable employeeTable;
    JScrollPane jspTable; 

    Vector titles;
    Vector data; 

    JLabel lblSearchName;
    JComboBox<Object> cmbSearchGender;
    JTextField txtSearchName;
    JLabel lblSearchGender;
    JButton btnSearch;
    JButton btnSearchClear;

    JLabel lblName;
    JLabel lblDob;
    JLabel lblGender;
    JLabel lblNic;
    JLabel lblMobile;
    JLabel lblEmail;
    JLabel lblDesignation;
    JLabel lblStatus;
    JTextField txtName;
    JTextField txtNic;
    JTextField txtMobile;
    JTextField txtEmail;
    JComboBox<Object> cmbGender;
    JComboBox<Object> cmbDesignation;
    JComboBox<Object> cmbStatusEmployee;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelete; 

    Color valid;
    Color invalid;
    Color initial;
    Color updated;  

    List<Employee> emplist;
    List<Gender> genlist;
    List<Designation> deslist;
    List<StatusEmployee> stelist; 

    Employee oldEmployee;
    Employee employee;

    JDateChooser dteDob;

    public EmployeeUi(){ 

        valid = new Color(200,255,200);
        invalid = Color.PINK;
        initial = Color.WHITE;
        updated = Color.YELLOW;

        setTitle("EU");
        setSize(550,600);
        setLocation(400,100); 

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
            con.setLayout(lay);  

        lblName  = new JLabel("Name :");
        lblDob  = new JLabel("    DOB :");
        lblGender  = new JLabel("Gender :");
        lblNic  = new JLabel("   NIC :");
        lblMobile  = new JLabel(" Mobile :");
        lblEmail  = new JLabel(" Email :");
        lblDesignation  = new JLabel("  Designation :");
        lblStatus  = new JLabel("Status :");
        txtName  = new JTextField( 40 );
        txtNic  = new JTextField( 40);
        txtMobile  = new JTextField( 40 );
        txtEmail  = new JTextField( 40 );
        cmbGender  = new JComboBox();
        cmbDesignation  = new JComboBox();
        cmbStatusEmployee  = new JComboBox();

        dteDob = new JDateChooser();
        btnAdd = new JButton(" Add ",iconAddBlack);
        btnClear = new JButton(" Clear ",iconClearBlack); 
        btnUpdate  = new JButton(" Update ",iconUpdateBlack);
        btnDelete  = new JButton(" Delete ",iconDeleteBlack); 

        JLabel lblEndDob = new JLabel("         ");
        JLabel lblEndGender = new JLabel("                       ");
        JLabel lblEndDesignation = new JLabel( "                ");
        JLabel lblEndStatusEmployee = new JLabel( "          ");
        JLabel lblEndDelete = new JLabel( "........................................................................................................................................................................");

            con.add(lblName);
            con.add(txtName);
            con.add(lblDob);
            con.add(dteDob);
            con.add(lblGender);
            con.add(cmbGender);  con.add( lblEndGender);
            con.add(lblNic);
            con.add(txtNic);
            con.add(lblMobile);
            con.add(txtMobile);
            con.add(lblEmail);
            con.add(txtEmail);
            con.add(lblDesignation);
            con.add(cmbDesignation);  con.add( lblEndDesignation);
            con.add(lblStatus);
            con.add(cmbStatusEmployee);  con.add( lblEndStatusEmployee);
            con.add(btnAdd );
            con.add(btnClear);
            con.add(btnUpdate);
            con.add(btnDelete); con.add(lblEndDelete);

                   
        lblSearchName  = new JLabel("Name :");
        txtSearchName  = new JTextField( 20 );
        lblSearchGender  = new JLabel("Gender :");
        cmbSearchGender  = new JComboBox();
        btnSearch  = new JButton("Search",iconSerchBlack );
        btnSearchClear  = new JButton("SearchClear",iconClearBlack); 

        JLabel lblEndSearchGender = new JLabel( "          ");
        JLabel lblEndSearchClear = new JLabel( "........................................................................................................................................................................");
        JLabel lblSearch = new JLabel( "            ");

            con.add(lblSearchName); 
            con.add(txtSearchName); con.add(lblSearch );
            con.add(lblSearchGender);
            con.add(cmbSearchGender);  con.add(lblEndSearchGender );
            con.add(btnSearch);
            con.add(btnSearchClear); con.add( lblEndSearchClear );

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
            jspTable.setPreferredSize( new Dimension(500,225));
            jspTable.setViewportView( employeeTable );

        txtName.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtNameKR( e ); } } );   
        txtNic.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtNicKR( e ); } } );
        txtEmail.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtEmailKR( e ); } } );
        txtMobile.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtMobileKR( e ); } } ); 
        cmbGender.addActionListener(e -> cmbGenderAp( e ));
        cmbDesignation.addActionListener(e -> cmbDesignationAp( e ));
        cmbStatusEmployee.addActionListener(e -> cmbStatusEmployeeAp( e ));
        dteDob.addPropertyChangeListener(e -> dteDobPc( e ));
        
        btnSearch.addActionListener(e -> btnSearchAp( e ));
        btnSearchClear.addActionListener(e -> btnSearchClearAp( e ));
        btnAdd.addActionListener(e -> btnAddAp( e ));
        btnClear.addActionListener(e -> btnClearAp( e ));
        btnUpdate.addActionListener(e -> btnUpdateAp( e ));
        btnDelete.addActionListener(e -> btnDeleteAp( e ));
        
        employeeTable.getSelectionModel().addListSelectionListener( new ListSelectionListener(){ public void valueChanged( ListSelectionEvent e){ employeeTableVC(e); } } );

        //mods        
        btnSearch.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ SearchMouseEnter( e );  }  } );
        btnSearch.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ SearchMouseExit( e );  }  } );
        btnAdd.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ AddMouseEnter( e );  }  } );
        btnAdd.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ AddMouseExit( e );  }  } );
        btnClear.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ ClearMouseEnter( e );  }  } );
        btnClear.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ ClearMouseExit( e );  }  } );
        btnSearchClear.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ SearchClearMouseEnter( e );  }  } );
        btnSearchClear.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ SearchClearMouseExit( e );  }  } );
        btnDelete.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ DeleteMouseEnter( e );  }  } );
        btnDelete.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ DeleteMouseExit( e );  }  } );
        btnUpdate.addMouseListener(new MouseAdapter(){public void mouseEntered(MouseEvent e){ UpdateMouseEnter( e );  }  } );
        btnUpdate.addMouseListener(new MouseAdapter(){public void mouseExited(MouseEvent e){ UpdateMouseExit( e );  }  } );
        
        intitialize(); 

        con.add(jspTable);

    }

    //UI-Controller-Intitialize

    public void intitialize(){ 

        loadForm();
        loadView();
    }

    public void loadForm(){

        employee = new Employee();

        genlist = GenderController.get(); 
            Vector<Object> genders = new Vector();
            genders.add("Select Gender");

            for(Gender gen : genlist){ 
                genders.add(gen);
            } 

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmbGender.setModel(gndModel); 


        deslist = DesignationController.get(); 
            Vector<Object> designations = new Vector();
            designations.add("Select Designation");

            for(Designation des : deslist){ 
                designations.add(des);
            } 

        DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
        cmbDesignation.setModel(desModel);

        
        stelist = StatusEmployeeController.get(); 
            Vector<Object> statusEmployees = new Vector();
            statusEmployees.add("Select StatusEmployee");

            for(StatusEmployee ste : stelist){ 
                statusEmployees.add(ste);
            } 

        DefaultComboBoxModel<Object> steModel = new DefaultComboBoxModel(statusEmployees);
        cmbStatusEmployee.setModel(steModel);

        //dteDob.setCalendar(null);
        dteDob.setDate(null);

        txtName.setText("");
        txtNic.setText("");
        txtMobile.setText("077");
        txtEmail.setText("@gmail.com");

        enableButtons(true, false, false);
        setStyle( initial );

    }

    public void enableButtons(boolean add , boolean upd , boolean del){

        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelete.setEnabled(del);
    } 

    public void setStyle( Color clr){ 

        
        txtName.setBackground(clr);
        txtMobile.setBackground(clr);
        txtEmail.setBackground(clr);
        txtNic.setBackground(clr);

        cmbDesignation.setBackground(clr);
        cmbGender.setBackground(clr);
        cmbStatusEmployee.setBackground(clr);

        JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
        dtpDisplay.setBackground(clr);
    
    } 

    public void fillForm(Employee emp){ 

        oldEmployee = emp;

        employee = new Employee();
        employee.setName(emp.getName());
        employee.setNic(emp.getNic());
        employee.setMobile(emp.getMobile());
        employee.setEmail(emp.getEmail());
        employee.setGender(emp.getGender());
        employee.setDesignation(emp.getDesignation());
        employee.setStatusEmployee(emp.getStatusEmployee());
        employee.setDob(emp.getDob());

        txtName.setText(emp.getName());
        txtNic.setText(emp.getNic());
        txtMobile.setText(emp.getMobile());
        txtEmail.setText(emp.getEmail());

        for (Gender gen : genlist) {
            if (gen.equals(employee.getGender())) {
                cmbGender.setSelectedItem(gen);
                break;
            }
        }

        for (Designation des : deslist) {
            if (des.equals(employee.getDesignation())) {
                cmbDesignation.setSelectedItem(des);
                break;
            }
        }

        for (StatusEmployee sts : stelist) {
            if (sts.equals(employee.getStatusEmployee())) {
                cmbStatusEmployee.setSelectedItem(sts);
                break;
            }
        }

        int yea = employee.getDob().getYear();
        int month = employee.getDob().getMonthValue();
        int day = employee.getDob().getDayOfMonth();

        java.util.Date dob = new java.util.Date(yea - 1900, month - 1, day);
        dteDob.setDate(dob);


        enableButtons(false, true, true);
        setStyle(valid );
    }

    public void loadView(){ 

        emplist = EmployeeController.get(null);
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
        employeeTable.clearSelection();
        employeeTable.setModel(model);

        
    }

    //UI-Controller-Interactive

    //validating and Binding

    public void txtNameKR(KeyEvent e){

        String name = txtName.getText();
        if( name.matches("^[a-zA-Z]{4,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$")){
            employee.setName(name);
            if(oldEmployee!=null){
                if(!name.equals(oldEmployee.getName()))
                    txtName.setBackground(updated);
                else
                    txtName.setBackground(valid);
            }else
                txtName.setBackground(valid);
        }else{
            employee.setName(null);
            txtName.setBackground(invalid);
        } 

    }

    public void txtNicKR(KeyEvent e){

        String nic = txtNic.getText().toUpperCase();
        if( nic.matches("^[0-9+]{9}[V|X]$|^[0-9+]{12}$")){
            employee.setNic(nic);
            if(oldEmployee!=null){
                if (!nic.equals(oldEmployee.getNic()))
                    txtNic.setBackground(updated);
                else
                    txtNic.setBackground(valid);
            }else
                txtNic.setBackground(valid);
        }else{
            employee.setNic(null);
            txtNic.setBackground(invalid);
        } 

    }

    public void txtEmailKR(KeyEvent e){

        String email = txtEmail.getText();
        if( email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            System.out.println(email);
            if(oldEmployee!=null){
                if (!email.equals(oldEmployee.getEmail()))
                    txtEmail.setBackground(updated);
                else
                    txtEmail.setBackground(valid);
            }else
                txtEmail.setBackground(valid);
        }else{
            employee.setEmail(null);
            txtEmail.setBackground(invalid);
        }

    }

    public void txtMobileKR(KeyEvent e){

        String mobile = txtMobile.getText();
        if(  mobile.matches("^0[0-9]{9}$")){
            employee.setMobile(mobile);
            if(oldEmployee!=null){
                if (!mobile.equals(oldEmployee.getMobile()))
                    txtMobile.setBackground(updated);
                else
                    txtMobile.setBackground(valid);
            }else
                txtMobile.setBackground(valid);
        }else{
            employee.setMobile(null);
            txtMobile.setBackground(invalid);
        }

    }

    public void cmbGenderAp(ActionEvent e){

        int genindex = cmbGender.getSelectedIndex();
        Gender genders = (Gender) cmbGender.getSelectedItem();
        if( genindex !=0){
            employee.setGender( (Gender)cmbGender.getSelectedItem() );
            if(oldEmployee!=null){
                if(!genders.equals(oldEmployee.getGender()))
                    cmbGender.setBackground(updated);
                else
                    cmbGender.setBackground(valid);
            }else
                cmbGender.setBackground(valid);
        }else{
            employee.setGender(null);
            cmbGender.setBackground(invalid);
        }  
    }

    public void cmbDesignationAp(ActionEvent e){
        int desindex = cmbDesignation.getSelectedIndex();
        Designation designations = (Designation)cmbDesignation.getSelectedItem();
        if( desindex!=0){
            employee.setDesignation( (Designation)cmbDesignation.getSelectedItem() );
            if(oldEmployee!=null){
                if(!designations.equals(oldEmployee.getDesignation()))
                    cmbDesignation.setBackground(updated);
                else
                    cmbDesignation.setBackground(valid);
            }else
                cmbDesignation.setBackground(valid);
        }else{
            employee.setDesignation(null);
            cmbDesignation.setBackground(invalid);
        }
    }

    public void cmbStatusEmployeeAp(ActionEvent e){

        int steindex = cmbStatusEmployee.getSelectedIndex();
        StatusEmployee statusemployees = (StatusEmployee)cmbStatusEmployee.getSelectedItem();
        if( steindex!=0){
            employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
            if(oldEmployee!=null){
                if(!statusemployees.equals(oldEmployee.getStatusEmployee()))
                    cmbStatusEmployee.setBackground(updated);
                else
                    cmbStatusEmployee.setBackground(valid);
            }else
                cmbStatusEmployee.setBackground(valid);
        }else{
            employee.setStatusEmployee(null);
            cmbStatusEmployee.setBackground(invalid);
        } 
    }

    public void dteDobPc(PropertyChangeEvent e){

        java.util.Date dobDate = dteDob.getDate();
        if( dobDate !=null){

            LocalDate dobDate1 = dteDob.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate nowDate = LocalDate.now();
            LocalDate oldDate = nowDate.minusYears(18);
            int comDate = oldDate.compareTo(dobDate1);
            JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();

            if( comDate >= 0){
                employee.setDob(dobDate1);
                if(oldEmployee!=null){
                    if(!dobDate1.equals(oldEmployee.getDob()))
                        dtpDisplay.setBackground(updated);
                    else
                        dtpDisplay.setBackground(valid);
                }else
                    dtpDisplay.setBackground(valid);
            }else{
                employee.setDob(null);
                dtpDisplay.setBackground(invalid);
            }
        }
    }


    //Form Handling

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

    public String getErrors(){

        String error = "";

        if (employee.getName()==null) error = error + "\n Invalid Name";
        if (employee.getNic()==null) error = error + "\n Invalid NIC";
        if (employee.getEmail()==null) error = error + "\n Invalid Email";
        if (employee.getMobile()==null)error = error + "\n Invalid Mobile";
        if (employee.getGender()==null)error = error + "\n Gender not Selected";
        if (employee.getDesignation()==null)error = error + "\n Designation not Selected";
        if (employee.getStatusEmployee()==null)error = error + "\n StatusEmployee not Selected";
        if (employee.getDob()==null)error = error + "\n Age is not enough";

        return error;
    }

    public void btnAddAp(ActionEvent e){

        String errors = getErrors();

        if (errors.isEmpty()) {
            
            String cnfmsg = "Are you sure to save following Employee?\n\n";
            cnfmsg =  cnfmsg + "\nName : " + employee.getName();
            cnfmsg =  cnfmsg + "\nNic : " + employee.getNic();
            cnfmsg =  cnfmsg + "\nDOB : " + employee.getDob().toString();
            cnfmsg =  cnfmsg +  "\nGender : " + employee.getGender().getName();
            cnfmsg =  cnfmsg + "\nEmail : " + employee.getEmail();
            cnfmsg =  cnfmsg + "\nMobile: " + employee.getMobile();
            cnfmsg =  cnfmsg + "\nName : " + employee.getDesignation().getName();
            cnfmsg =  cnfmsg + "\nStatus : " + employee.getStatusEmployee().getName();

            int conf = JOptionPane.showConfirmDialog(null,cnfmsg);
            
            if(conf==0){ 
                String st = EmployeeController.post(employee);
                if(st.equals("1")){
                    loadView();
                    loadForm();
                    JOptionPane.showConfirmDialog(null,"Successfully Saved");
                }
                else
                    JOptionPane.showConfirmDialog(null,"Failed to Save as \n\n"+st);
            }
                                            
        }
        else{
            JOptionPane.showMessageDialog(null, "You have Following\n\n"+errors);
        }

    }

    public void employeeTableVC(ListSelectionEvent e){
        int row = employeeTable.getSelectedRow();
        if(row>-1){
            Employee employee = emplist.get(row);
            fillForm(employee);
        }
    }

    public void btnClearAp(ActionEvent e){ 
         int conf = JOptionPane.showConfirmDialog(null,"Are you sure to clear the form?" );
         if(conf==0) loadForm();
         oldEmployee = null;
    }

    public String getUpdates(){ 
        String updates="";
                
        if(!txtName.getText().equals(oldEmployee.getName())) 
            updates = updates + "\n Name Updated ";
            
        if(!txtNic.getText().equals(oldEmployee.getNic()))
            updates = updates + "\n NIC Updated "; 

        if(!txtEmail.getText().equals(oldEmployee.getEmail()))
            updates = updates + "\n Email Updated ";

        if(!txtMobile.getText().equals(oldEmployee.getMobile()))
            updates = updates + "\n Mobile Updated ";
            
        if(!employee.getGender().equals(oldEmployee.getGender()))
            updates = updates + "\n Gender Updated ";

        if(!employee.getDesignation().equals(oldEmployee.getDesignation()))
            updates = updates + "\n Designation Updated "; 
      
        if(!employee.getStatusEmployee().equals(oldEmployee.getStatusEmployee()))
            updates = updates + "\n StatusEmployee Updated "; 
        
        if(!employee.getDob().equals(oldEmployee.getDob()))
            updates = updates + "\n DOB Updated ";

        return updates;
    }

    public void btnUpdateAp(ActionEvent e){
        
        employee.setId( oldEmployee.getId());
        String error = getErrors();

        if(error.isEmpty() ){
            String updates = getUpdates();
            if(!updates.isEmpty()){
                int resp = JOptionPane.showConfirmDialog(null,"\nYou have following updates\n"+updates);
                if(resp==0){
                    String status = EmployeeController.put(employee);
                    if(status.equals("1")){
                        int lsrow = employeeTable.getSelectedRow(); 
                        loadView();
                        loadForm();
                        employeeTable.setRowSelectionInterval(lsrow, lsrow);
                        JOptionPane.showMessageDialog(null, "Succesfully Update ");
                    }else{
                        JOptionPane.showMessageDialog(null, "Failed to Update as \n\n"+status);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Nothing to be updated");
            }
        }else{
            JOptionPane.showMessageDialog(null, "You have following Data errors\n\n"+error);
        }
    }
   
    public void btnDeleteAp(ActionEvent e){
        
        int resp = JOptionPane.showConfirmDialog(null,"Are you sure to Delete following Employee\n\n"+oldEmployee.getName());
            if(resp==0){ 
                String status = EmployeeController.delete(oldEmployee);
                if(status.equals("1")){
                    int lsrow = employeeTable.getSelectedRow(); 
                    loadView();
                    employeeTable.setRowSelectionInterval(lsrow, lsrow);
                    loadForm();
                    JOptionPane.showMessageDialog(null, "Succesfully Delete");

                }

               else{
                    JOptionPane.showMessageDialog(null, "Failed to Delete as \n\n"+status);
                }

       }
    }

    //mode

    //Icon use
    Icon iconSerchBlack = new ImageIcon("src/resources/search.png");
    Icon iconSerchRed = new ImageIcon("src/resources/search1.png");
    Icon iconAddBlack = new ImageIcon("src/resources/Users-Add-User-icon.png");
    Icon iconAddRed= new ImageIcon("src/resources/add-user-icon.png");
    Icon iconClearRed= new ImageIcon("src/resources/clear-red.png");
    Icon iconClearBlack= new ImageIcon("src/resources/clear-black.png");
    Icon iconDeleteRed= new ImageIcon("src/resources/delete-red.png");
    Icon iconDeleteBlack= new ImageIcon("src/resources/delete-black.png");
    Icon iconUpdateRed= new ImageIcon("src/resources/update-red.png");
    Icon iconUpdateBlack= new ImageIcon("src/resources/update-black.png");

    public void SearchMouseEnter(MouseEvent e) {
        btnSearch.setIcon(iconSerchRed);
    }

    public void SearchMouseExit(MouseEvent e) {
        btnSearch.setIcon(iconSerchBlack);
    }
    
    public void AddMouseEnter(MouseEvent e) {
        btnAdd.setIcon(iconAddRed);
    }

    public void AddMouseExit(MouseEvent e) {
        btnAdd.setIcon(iconAddBlack);
    }

    public void ClearMouseEnter(MouseEvent e) {
        btnClear.setIcon(iconClearRed);
    }

    public void ClearMouseExit(MouseEvent e) {
        btnClear.setIcon(iconClearBlack);
    }

    public void SearchClearMouseEnter(MouseEvent e) {
        btnSearchClear.setIcon(iconClearRed);
    }

    public void SearchClearMouseExit(MouseEvent e) {
        btnSearchClear.setIcon(iconClearBlack);
    }

    public void DeleteMouseEnter(MouseEvent e) {
        btnDelete.setIcon(iconDeleteRed);
    }

    public void DeleteMouseExit(MouseEvent e) {
        btnDelete.setIcon(iconDeleteBlack);
    }

    public void UpdateMouseEnter(MouseEvent e) {
        btnUpdate.setIcon(iconUpdateRed);
    }

    public void UpdateMouseExit(MouseEvent e) {
        btnUpdate.setIcon(iconUpdateBlack);
    }
}