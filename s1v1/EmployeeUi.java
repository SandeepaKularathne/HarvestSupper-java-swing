import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;

public class EmployeeUi extends JFrame {

    JTable tblEmployee;

    EmployeeUi() {

        setTitle("Table Demo-EUC");
        setLocation(200, 300);
        setSize(550, 400);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        Vector titles = new Vector();
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Designation");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee = new JTable();
        tblEmployee.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblEmployee);

        con.add(jspTable);

        intitialize();
    }


    public void intitialize() {
        loadView();
    }
    

    public void loadView() {

        List<Employee> emplist = EmployeeController.get();
        fillTable(emplist);

    }


    public void fillTable(List<Employee> employees) {

        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();

        for (Employee emp : employees) {

            Vector r = new Vector();
            r.add(emp.getName());
            r.add(emp.getDob().toString());
            r.add(emp.getNic());
            r.add(emp.getGender().getName());
            r.add(emp.getDesignation().getName());

            model.addRow(r);
        }

    }

}



