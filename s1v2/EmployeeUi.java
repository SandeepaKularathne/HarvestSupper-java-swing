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

import java.util.Hashtable;


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
    
    EmployeeUi(){ 

        setTitle("Table Demo-EUC");
        setSize(550,600);
        setLocation(400,150); 

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
            con.setLayout(lay);  

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

        
        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        intitialize(); 

        con.add(jspTable);

    }

    public void intitialize(){ 

        loadView();
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

}