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

public class  ItemUi extends JFrame {

    JTable tblItem;
    JScrollPane jspTable; 

    Vector titles;
    Vector data; 

    JLabel lblSearchName;
    JComboBox<Object> cmbSearchBrand;
    JComboBox<Object> cmbSearchSubcategory;
    JTextField txtSearchName;
    JLabel lblSearchBrand;
    JLabel lblSearchSubcategory;
    JButton btnSearch;
    JButton btnSearchClear;

    ItemUi() {

        setTitle("Table Demo-EUC");
        setLocation(200, 300);
        setSize(550, 400);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        lblSearchName  = new JLabel("Name :");
        txtSearchName  = new JTextField( 20 );
        lblSearchBrand  = new JLabel("Brand :");
        cmbSearchBrand = new JComboBox();
        lblSearchSubcategory  = new JLabel("Subcategory :");
        cmbSearchSubcategory = new JComboBox();
        btnSearch  = new JButton("Search");
        btnSearchClear  = new JButton("SearchClear"); 

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchBrand);
        con.add(cmbSearchBrand);
        con.add(lblSearchSubcategory);
        con.add(cmbSearchSubcategory);
        con.add(btnSearch);
        con.add(btnSearchClear);

        titles = new Vector();
        titles.add("Brand");
        titles.add("Name");
        titles.add("Subcategory");
        titles.add("PricePurchase");
        titles.add("PriceSale");
        titles.add("QOH");
        titles.add("ROP");
        titles.add("StatusItem");
        titles.add("DoIntroduced");

        data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblItem = new JTable();
        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblItem);

        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        intitialize(); 

        con.add(jspTable);

    }

    public void intitialize() {
        loadView();
    }
    

    public void loadView() {

        List<Item> emplist = ItemController.get(null);
        fillTable(emplist);

        List<Brand> bralist = BrandController.get(); 
            Vector<Object> brands = new Vector();
            brands.add("Select brand");

                for(Brand bra : bralist){ 

                    brands.add(bra);
                } 

        DefaultComboBoxModel<Object> braModel = new DefaultComboBoxModel(brands);
        cmbSearchBrand.setModel(braModel);

        List<SubCategory> sublist = SubCategoryController.get(); 
            Vector<Object> subcategorys = new Vector();
            subcategorys.add("Select SubCategory");

                for(SubCategory sub : sublist){ 

                    subcategorys.add(sub);
                } 

        DefaultComboBoxModel<Object> subModel = new DefaultComboBoxModel(subcategorys);
        cmbSearchSubcategory.setModel(subModel);

    }


    public void fillTable(List<Item> items) {

        Vector data = new Vector();

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

            data.add(r);
        }

        DefaultTableModel model =  new DefaultTableModel(data , titles); 
        tblItem.setModel(model);

    }

    public void btnSearchAp(ActionEvent e){ 

        String name = txtSearchName.getText();
        Object sitem = cmbSearchBrand.getSelectedItem();
        Object sitem1 = cmbSearchSubcategory.getSelectedItem();
        Brand brand = null; 
        SubCategory subcategory = null; 

        if(!sitem.equals("Select Brand"))
        brand = (Brand)sitem;

        if(!sitem1.equals("Select SubCategory"))
        subcategory  = (SubCategory) sitem1;

        Hashtable<String , Object> ht = new Hashtable();
        ht.put("name", name);
        if(brand!=null)ht.put("brand", brand);
        if(subcategory!=null)ht.put("subcategory", subcategory);

        List<Item> items = ItemController.get(ht);
        fillTable(items); 

    } 

    public void btnSearchClearAp(ActionEvent e){ 

        int opt = JOptionPane.showConfirmDialog(null,"Are you sure to Clear the Search");

        if(opt!=1){

            txtSearchName.setText(" ");
            cmbSearchBrand.setSelectedIndex(0);
            cmbSearchSubcategory.setSelectedIndex(0);

            List<Item> items = ItemController.get(null);
            fillTable(items);  
        
        }
    }

}