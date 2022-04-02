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

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.JScrollPane; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.time.LocalDate;
import java.util.Hashtable; 

import java.awt.Color; 

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.time.LocalDate;

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
        btnAdd = new JButton(" Add ");
        btnClear = new JButton(" Clear "); 
        btnUpdate  = new JButton(" Update ");
        btnDelete  = new JButton(" Delete "); 

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
        btnSearch  = new JButton("Search");
        btnSearchClear  = new JButton("SearchClear"); 

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
        cmbGender.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmbGenderAp( e );  }  } );
        cmbDesignation.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmbDesignationAp( e );  }  } );
        cmbStatusEmployee.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmbStatusEmployeeAp( e );  }  } );
        dteDob.addPropertyChangeListener( new PropertyChangeListener(){ public void propertyChange(PropertyChangeEvent e){ dteDobPc( e );  }  } );
        
        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        btnAdd.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnAddAp( e );  }  } );
        btnClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnClearAp( e );  }  } );
        btnUpdate.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnUpdateAp( e );  }  } );
        btnDelete.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnDeleteAp( e );  }  } );
        
        employeeTable.getSelectionModel().addListSelectionListener( new ListSelectionListener(){ public void valueChanged( ListSelectionEvent e){ employeeTableVC(e); } } );

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

    public void fillForm(){ 

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
        if( name.matches("^[A-Z][a-z]*$")){
            employee.setName(name);
            txtName.setBackground(valid);
        }else{
            employee.setName(null);
            txtName.setBackground(invalid);

        } 

    }

    public void txtNicKR(KeyEvent e){

        String nic = txtNic.getText();
        if( nic.matches("^[0-9]{9}V$")){
            employee.setNic(nic);
            txtNic.setBackground(valid);
        }else{
            employee.setNic(null);
            txtNic.setBackground(invalid);
        } 

    }

    public void txtEmailKR(KeyEvent e){

        String email = txtEmail.getText();
        if( email.matches("^(\\w+([\\.-]?\\w+))*(?:{2})*@(\\w{2,10})*(?:{2})*(\\.\\w{2,3})+$")){
            employee.setEmail(email);
            txtEmail.setBackground(valid);
        }
        else{
            employee.setEmail(null);
            txtEmail.setBackground(invalid);
        }

    }

    public void txtMobileKR(KeyEvent e){

        String mobile = txtMobile.getText();
        if(  mobile.matches("^0[0-9]{9}$")){
            employee.setMobile(mobile);
            txtMobile.setBackground(valid);
        }else{
            employee.setMobile(null);
            txtMobile.setBackground(invalid);
        }

    }

    public void cmbGenderAp(ActionEvent e){

        int genindex = cmbGender.getSelectedIndex();
        if( genindex!=0){
            cmbGender.setBackground(valid);
            employee.setGender( (Gender)cmbGender.getSelectedItem() );
        }else{
            employee.setGender(null);
            cmbGender.setBackground(invalid);
        }  
    }

    public void cmbDesignationAp(ActionEvent e){

        int desindex = cmbDesignation.getSelectedIndex();
        if( desindex!=0){
            cmbDesignation.setBackground(valid);
            employee.setDesignation( (Designation)cmbDesignation.getSelectedItem() );
        }else{
            employee.setDesignation(null);
            cmbDesignation.setBackground(invalid);
        } 
    }

    public void cmbStatusEmployeeAp(ActionEvent e){

        int steindex = cmbStatusEmployee.getSelectedIndex();
        if( steindex!=0){
            cmbStatusEmployee.setBackground(valid);
            employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
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

    public void fillForm(Employee employee){

        oldEmployee = employee;

        txtName.setText(employee.getName());
        txtNic.setText(employee.getNic());
        txtMobile.setText(employee.getMobile());
        txtEmail.setText(employee.getEmail());

        for(Gender gen : genlist){ 
            if(gen.equals (employee.getGender() ) ){ 
                cmbGender.setSelectedItem(gen); 
                break; } } 

        for(Designation des : deslist){ 
            if(des.equals (employee.getDesignation())){ 
                cmbDesignation.setSelectedItem(des); 
                break; } } 

        for(StatusEmployee ste : stelist){ 
            if(ste.equals (employee.getStatusEmployee())){ 
                cmbStatusEmployee.setSelectedItem(ste); 
                break; 
            } 
        } 

        dteDob.setDate( new java.util.Date(employee.getDob().toEpochDay() * 1000*3600*24));
        
        enableButtons(false, true, true);
        setStyle(valid);

    }

    public void btnClearAp(ActionEvent e){ 
         int conf = JOptionPane.showConfirmDialog(null,"Are you sure to clear the form?" );
         if(conf==0) loadForm();
    }

    public String getUpdates(){ String updates=""; return updates; }

    public void btnUpdateAp(ActionEvent e){ 

        Employee employee = new Employee();
        employee.setId( oldEmployee.getId());

        String error = "";
        String updates = "";

        String name = txtName.getText(); 

        
            if( name.matches("^[A-Z][a-z]*$")){
             
                if(  name.equals(oldEmployee.getName())){
                    txtName.setBackground(valid);
                }
                else{ 
                    txtName.setBackground(updated); 
                    updates = updates + "\n Name Updated "; 
                   }
                   
                   employee.setName(name);
            }
            else{
                txtName.setBackground(invalid);
                error = error + "\n Invalid Name";
            }

        String nic = txtNic.getText();
            if( nic.matches("^[0-9]{9}V$")){ 
                if(nic.equals(oldEmployee.getNic()))
                txtNic.setBackground(valid);
            else
                {txtNic.setBackground(updated); 
                updates = updates + "\n NIC Updated ";                    
                }
                employee.setNic(nic);
            }
            
            else{ 
                txtNic.setBackground(invalid);
                error = error + "\n Invalid NIC";
            }
            
        String email = txtEmail.getText();
            if( email.matches("^(\\w+([\\.-]?\\w+))*(?:{2})*@(\\w{2,10})*(?:{2})*(\\.\\w{2,3})+$")){
                if(email.equals(oldEmployee.getEmail()))
                txtEmail.setBackground(valid);
                
            else
                {txtEmail.setBackground(updated); 
                updates = updates + "\n Email Updated "; 
            }
            employee.setEmail(email);
        }
            else{ 
                txtEmail.setBackground(invalid);
                error = error + "\n Invalid Email";
            }
            
        String mobile = txtMobile.getText();
            if(  mobile.matches("^0[0-9]{9}$")){
                if(mobile.equals(oldEmployee.getMobile()))
                txtMobile.setBackground(valid);

            else
                {txtMobile.setBackground(updated); 
                updates = updates + "\n Mobile Updated ";
            }
            employee.setMobile(mobile);
        }
            else{ 
                txtMobile.setBackground(invalid);
                error = error + "\n Invalid Mobile";
            }

        int genindex = cmbGender.getSelectedIndex();
            if( genindex!=0){
                Gender gender = (Gender) cmbGender.getSelectedItem();

                if(gender.equals(oldEmployee.getGender())){
                cmbGender.setBackground(valid); }
                

                else{
                    cmbGender.setBackground(updated);
                    updates = updates + "\n Gender Updated "; 
                }
                employee.setGender( (Gender)cmbGender.getSelectedItem() );
            }
            else{ 
                cmbGender.setBackground(invalid);
                error = error + "\n Gender not Selected";
            } 

       int desindex = cmbDesignation.getSelectedIndex();
            if( desindex!=0){
                Designation designation = (Designation)cmbDesignation.getSelectedItem();

                if(designation.equals(oldEmployee.getDesignation())){
                cmbDesignation.setBackground(valid);
                
                }
                else{
                    cmbDesignation.setBackground(updated);
                    updates = updates + "\n Designation Updated "; 
                }

                employee.setDesignation( (Designation)cmbDesignation.getSelectedItem() );
            }
            else{ 
                cmbDesignation.setBackground(invalid);
                error = error + "\n Designation not Selected";
            } 
        
        int steindex = cmbStatusEmployee.getSelectedIndex();
            if( steindex!=0){
                StatusEmployee statusEmployee = (StatusEmployee)cmbStatusEmployee.getSelectedItem();

                if(statusEmployee.equals(oldEmployee.getStatusEmployee())){
                    cmbStatusEmployee.setBackground(valid);
                }else{
                    cmbStatusEmployee.setBackground(updated);
                    updates = updates + "\n StatusEmployee Updated "; 
                }

            employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
        }
            else{ 
                cmbStatusEmployee.setBackground(invalid);
                error = error + "\n StatusEmployee not Selected";
            } 

            java.util.Date dt = dteDob.getDate();
            if( dt !=null){
                
                LocalDate dobDate1 = dteDob.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate nowDate = LocalDate.now();
                LocalDate oldDate = nowDate.minusYears(20);
                int comDate = oldDate.compareTo(dobDate1);
    
                LocalDate dob = LocalDate.of(dt.getYear()+1900,dt.getMonth(),dt.getDate());
    
                if( comDate >= 0){
                    JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
                    dtpDisplay.setBackground(valid);
                    employee.setDob(dob);
                    updates = updates + "\n DOB Updated ";
                }else{ 
                    JTextField dtpDisplay1=(JTextField)dteDob.getDateEditor().getUiComponent();
                    dtpDisplay1.setBackground(invalid);
                    error = error + "\n Age is not enough ";
                }
            }

        if(error.isEmpty() ){
                
                if(!updates.isEmpty()){
                    int resp = JOptionPane.showConfirmDialog(null,"You have following Updates\n\n"+updates);
                    if(resp==0){ 
                        String status = EmployeeController.put(employee);
                        if(status.equals("1")){
                            int lsrow = employeeTable.getSelectedRow(); 
                            loadView();
                            employeeTable.setRowSelectionInterval(lsrow, lsrow);
                            loadForm();
                            JOptionPane.showMessageDialog(null, "Succesfully Update ");
                            
                        }

                        else{ 
                            JOptionPane.showMessageDialog(null, "Failed to Update as \n\n"+status);
                        }

                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "Nothing to be updated");
                }
            }
        else{
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

}
