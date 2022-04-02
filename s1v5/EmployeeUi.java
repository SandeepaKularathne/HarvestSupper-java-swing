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
import java.time.LocalDate;
import java.util.Hashtable; 

import java.awt.Color; 

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
    JComboBox<Object> cmbDobDay;
    JComboBox<Object> cmbDobMonth;
    JComboBox<Object> cmbDobYear;
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

    EmployeeUi(){ 

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
        cmbDobDay  = new JComboBox();                                                           
        cmbDobMonth  = new JComboBox();                                                    
        cmbDobYear  = new JComboBox(); 
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
            con.add(cmbDobDay);  con.add(cmbDobMonth);  con.add(cmbDobYear);  con.add( lblEndDob);
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

        
        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        btnAdd.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnAddAp( e );  }  } );
        btnClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnClearAp( e );  }  } );
        btnUpdate.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnUpdateAp( e );  }  } );
        
        employeeTable.getSelectionModel().addListSelectionListener( new ListSelectionListener(){ public void valueChanged( ListSelectionEvent e){ employeeTableVC(e); } } );

        intitialize(); 

        con.add(jspTable);

    }

    public void intitialize(){ 

        loadForm();
        loadView();
    }

    public void loadForm(){

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


        Vector<Object> dobDay = new Vector();
        dobDay.add("Select");

                for( int i=1; i<=31; i++)
                dobDay.add(i);

        DefaultComboBoxModel<Object> dobDayModel = new DefaultComboBoxModel(dobDay );
        cmbDobDay.setModel(dobDayModel);

        Vector<Object> dobMonth = new Vector();
        dobMonth.add("Select");

                for( int i=1; i<=12; i++)
                dobMonth.add(i);

        cmbDobMonth.setModel(new DefaultComboBoxModel(dobMonth )); 

        Vector<Object> dobYear = new Vector();
        dobYear.add("Select");

                for( int i=1980; i<=2005; i++)
                dobYear.add(i);

        cmbDobYear.setModel(new DefaultComboBoxModel(dobYear )); 

        txtName.setText("");
        txtNic.setText("");
        txtMobile.setText("");
        txtEmail.setText("");

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
        cmbDobDay.setBackground(clr);
        cmbDobMonth.setBackground(clr);
        cmbDobYear.setBackground(clr);
    
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
        String error = "";

        String name = txtName.getText();
            if( name.matches("^[A-Z][a-z]*$")){
                employee.setName(name);
                txtName.setBackground(valid);
            }
            else{ 
                txtName.setBackground(invalid);
                error = error + "\n Invalid Name";
            } 

        String nic = txtNic.getText();
            if( nic.matches("^[0-9]{9}V$")){
                employee.setNic(nic);
                txtNic.setBackground(valid);
            }
            else{ 
                txtNic.setBackground(invalid);
                error = error + "\n Invalid NIC";
            }
            
        String email = txtEmail.getText();
            if( email.matches("^[a-z]*@[a-z]*.[a-z]*$")){
                employee.setEmail(email);
                txtEmail.setBackground(valid);
            }
            else{ 
                txtEmail.setBackground(invalid);
                error = error + "\n Invalid Email";
            }
            
        String mobile = txtMobile.getText();
            if(  mobile.matches("^0[0-9]{9}$")){
                employee.setMobile( mobile);
                txtMobile.setBackground(valid);
            }
            else{ 
                txtMobile.setBackground(invalid);
                error = error + "\n Invalid Mobile";
            } 

        int genindex = cmbGender.getSelectedIndex();
            if( genindex!=0){
                cmbGender.setBackground(valid);
                employee.setGender( (Gender)cmbGender.getSelectedItem() );
            }
            else{ 
                cmbGender.setBackground(invalid);
                error = error + "\n Gender not Selected";
            } 

        int desindex = cmbDesignation.getSelectedIndex();
            if( desindex!=0){
                cmbDesignation.setBackground(valid);
                employee.setDesignation( (Designation)cmbDesignation.getSelectedItem() );
            }
            else{ 
                cmbDesignation.setBackground(invalid);
                error = error + "\n Designation not Selected";
            } 
        
        int steindex = cmbStatusEmployee.getSelectedIndex();
            if( steindex!=0){
                cmbStatusEmployee.setBackground(valid);
                employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
            }
            else{ 
                cmbStatusEmployee.setBackground(invalid);
                error = error + "\n StatusEmployee not Selected";
            } 


        int dayIndex = cmbDobDay.getSelectedIndex();
        int monIndex = cmbDobMonth.getSelectedIndex();
        int yerIndex = cmbDobYear.getSelectedIndex(); 

            String day = " ";
            String mon = " ";
            String yer = " ";

            if(dayIndex!=0){ 
                cmbDobDay.setBackground(valid);
                day = cmbDobDay.getSelectedItem().toString();
                if(day.length()==1) day = "0" + day;
            }
            else{
                cmbDobDay.setBackground(invalid);
            }

            if(monIndex!=0){ 
                cmbDobMonth.setBackground(valid);
                mon = cmbDobMonth.getSelectedItem().toString();
                if(mon.length()==1) mon = "0" + mon;
            }
            else{
                cmbDobMonth.setBackground(invalid);
            }

            if(yerIndex!=0){ 
                cmbDobYear.setBackground(valid);
                yer = cmbDobYear.getSelectedItem().toString();
            }
            else{
                cmbDobYear.setBackground(invalid); 
            } 

            if(dayIndex !=0 && monIndex !=0 && yerIndex !=0){
                String dobs = yer+"-"+mon+"-"+day;
                LocalDate dob = LocalDate.parse(dobs);
                employee.setDob(dob);
            }
            else{ 
                error = error + "\n Select Birth Date";
            } 

        if(error.isEmpty()){
            
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
            JOptionPane.showMessageDialog(null, error);
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
                break; } } 

        cmbDobDay.setSelectedItem( employee.getDob().getDayOfMonth() );
        cmbDobMonth.setSelectedItem( employee.getDob().getMonthValue() );
        cmbDobYear.setSelectedItem( employee.getDob().getYear() ); 

        enableButtons(false, true, true);
        setStyle(valid);

    }

    public void btnClearAp(ActionEvent e){ 
         int conf = JOptionPane.showConfirmDialog(null,"Are you sure to clear the form?" );
         if(conf==0) loadForm();
    }

    public String getErrors(){ String errors=""; return errors; }

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
            if( email.matches("^[a-z]*@[a-z]*.[a-z]*$")){
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
                
            }
                 else{
                    cmbStatusEmployee.setBackground(updated);
                    updates = updates + "\n StatusEmployee Updated "; 
                }

            employee.setStatusEmployee( (StatusEmployee)cmbStatusEmployee.getSelectedItem() );
        }
            else{ 
                cmbStatusEmployee.setBackground(invalid);
                error = error + "\n StatusEmployee not Selected";
            } 


        int dayIndex = cmbDobDay.getSelectedIndex();
        int monIndex = cmbDobMonth.getSelectedIndex();
        int yerIndex = cmbDobYear.getSelectedIndex(); 

            String day = " ";
            String mon = " ";
            String yer = " ";

            if(dayIndex!=0){ 
                cmbDobDay.setBackground(valid);
                day = cmbDobDay.getSelectedItem().toString();
                if(day.length()==1) day = "0" + day;
            }
            else{
                cmbDobDay.setBackground(invalid);
            }

            if(monIndex!=0){ 
                cmbDobMonth.setBackground(valid);
                mon = cmbDobMonth.getSelectedItem().toString();
                if(mon.length()==1) mon = "0" + mon;
            }
            else{
                cmbDobMonth.setBackground(invalid);
            }

            if(yerIndex!=0){ 
                cmbDobYear.setBackground(valid);
                yer = cmbDobYear.getSelectedItem().toString();
            }
            else{
                cmbDobYear.setBackground(invalid); 
            } 

            if(dayIndex !=0 && monIndex !=0 && yerIndex !=0){
                String dobs = yer+"-"+mon+"-"+day;
                LocalDate dob = LocalDate.parse(dobs);
                employee.setDob(dob);
                if(employee.getDob().getDayOfMonth()==oldEmployee.getDob().getDayOfMonth() ){
                    cmbDobDay.setBackground(valid);
                    cmbDobMonth.setBackground(valid);
                    cmbDobYear.setBackground(valid); 
                }
                else{
                    cmbDobDay.setBackground(updated);
                    cmbDobMonth.setBackground(updated);
                    cmbDobYear.setBackground(updated); 
                }
            }
            else{ 
                error = error + "\n Select Birth Date";
            } 

        if(error.isEmpty() ){ 
                
                if(!updates.isEmpty()){
                    int resp = JOptionPane.showConfirmDialog(null,"You have following Updates\n\n"+updates);
                    if(resp==0){ 
                        String status = EmployeeController.put(employee);
                        if(status.equals("1")){
                            int lsrow = employeeTable.getSelectedRow(); 
                            loadView();
                            //loadForm();
                            employeeTable.setRowSelectionInterval(lsrow, lsrow);
                            loadForm();
                            JOptionPane.showMessageDialog(null, "Succesfully Update ");
                            
                        }

                        else{ 
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
   
}
