import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;

public class  ItemUi extends JFrame {

    JTable tblItem;

    ItemUi() {

        setTitle("Table Demo-EUC");
        setLocation(200, 300);
        setSize(550, 400);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        Vector titles = new Vector();
        titles.add("Brand");
        titles.add("Name");
        titles.add("Subcategory");
        titles.add("PricePurchase");
        titles.add("PriceSale");
        titles.add("QOH");
        titles.add("ROP");
        titles.add("StatusItem");
        titles.add("DoIntroduced");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblItem = new JTable();
        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblItem);

        con.add(jspTable);

        intitialize();
    }


    public void intitialize() {
        loadView();
    }
    

    public void loadView() {

        List<Item> emplist = ItemController.get();
        fillTable(emplist);

    }


    public void fillTable(List<Item> items) {

        DefaultTableModel model = (DefaultTableModel) tblItem.getModel();

        for (Item emp : items) {

            Vector r = new Vector();
            r.add(emp.getBrand().getName());
            r.add(emp.getName());
            r.add(emp.getSubCategory().getName());
            r.add(emp.getPricePurchase());
            r.add(emp.getPriceSale());
            r.add(emp.getQoh());
            r.add(emp.getRop());
            r.add(emp.getStatusItem().getName());
            r.add(emp.getDoIntroduced().toString());

            model.addRow(r);
        }

    }

}



