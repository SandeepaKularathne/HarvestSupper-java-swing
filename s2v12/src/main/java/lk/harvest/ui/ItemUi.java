package lk.harvest.ui;

import lk.harvest.entity.Item;
import lk.harvest.entity.Brand;
import lk.harvest.entity.SubCategory;
import lk.harvest.entity.StatusItem;

import lk.harvest.controller.ItemController;
import lk.harvest.controller.SubCategoryController;
import lk.harvest.controller.StatusItemController;
import lk.harvest.controller.BrandController;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Vector;
import java.util.List;
import java.util.HashMap;

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
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter; 

import java.util.Hashtable;
import java.time.LocalDate;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.time.ZoneId;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.time.LocalDate;

public class  ItemUi extends JFrame {

    //Goble Varible

    JTable tblItem;
    JScrollPane jspTable; 

    Vector titles;
    Vector data;

    JTextField txtName;
    JTextField txtCode;
    JTextField txtPricePurchase;
    JTextField txtPriceSale;
    JTextField txtQOH;
    JTextField txtROP;

    JComboBox<Object> cmbBrand;
    JComboBox<Object> cmblSubCategory;
    JComboBox<Object> cmbStatusItem;

    JDateChooser dteDob;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelet;

    Color valid;
    Color invalid;
    Color initial;
    Color updated; 

    JLabel lblName;
    JLabel lblBrand;
    JLabel lblSubCategory;
    JLabel lblPricePurchase;
    JLabel lblPriceSale;
    JLabel lblQOH;
    JLabel lblROP;
    JLabel lblStatusItem;
    JLabel lblDoIntroduced;
    JLabel lblCode;

    JLabel lblSearchName;
    JComboBox<Object> cmbSearchBrand;
    JComboBox<Object> cmbSearchSubCategory;
    JTextField txtSearchName;
    JLabel lblSearchBrand;
    JLabel lblSearchSubCategory;
    JButton btnSearch;
    JButton btnSearchClear;

    List<Item> itelist;
    List<Brand> bralist;
    List<SubCategory> sublist;
    List<StatusItem> stalist;

    Item olditem;
    Item item;

    //Constracter
    public ItemUi() {

        valid = new Color(200,255,200);
        invalid = Color.pink;
        initial = Color.white;
        updated = Color.YELLOW;


        setTitle("Item");
        setLocation(200, 300);
        setSize(1000, 700);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        //Lable
        lblName = new JLabel("Name  : ");
        lblBrand = new JLabel("Brand  : ");
        lblSubCategory = new JLabel("Sub Category  : ");
        lblPricePurchase = new JLabel("Price Purchase  : ");
        lblPriceSale= new JLabel("Price Sale : ");
        lblQOH = new JLabel("QOH  : ");
        lblROP = new JLabel("ROP  : ");
        lblStatusItem = new JLabel("Status Item  : ");
        lblDoIntroduced = new JLabel("Do Introduced Date : ");
        lblCode = new JLabel ("Item Code :");

        //Text Filed
        txtName = new JTextField(53);
        txtCode = new JTextField(51);
        txtPricePurchase = new JTextField(49);
        txtPriceSale = new JTextField(50);
        txtQOH = new JTextField(50);
        txtROP = new JTextField(50);

        //ComboBox
        cmbBrand =new JComboBox();
        cmblSubCategory =new JComboBox();
        cmbStatusItem =new JComboBox();
        
        //Dob
        dteDob = new JDateChooser();

        //Button
        btnAdd=new JButton("Add");
        btnClear =new JButton("Clear");
        btnUpdate =new JButton("Update");
        btnDelet =new JButton("Delet");

        JLabel lblEmpty= new JLabel("                                                                      ");
        JLabel lblEmpty1= new JLabel("                                                                                                                                                                                                  ");
        JLabel lblEmpty2= new JLabel("                                                                 ");
        JLabel lblEmpty3= new JLabel("                                                                                                                                                                           ");
        JLabel lblEmpty4= new JLabel("                                                                 ");
        JLabel lblEmpty5= new JLabel("                                                                        ");                                                                                                      
        JLabel lblEmpty6= new JLabel("                                                                               ");
        JLabel lblEmpty7= new JLabel("                                                                               ");

            con.add(lblName);
            con.add(txtName);
            con.add(lblEmpty);
            con.add(lblBrand);
            con.add(cmbBrand);
            con.add(lblEmpty1);
            con.add(lblCode);
            con.add(txtCode);
            con.add(lblEmpty2);
            con.add(lblSubCategory);
            con.add(cmblSubCategory);
            con.add(lblEmpty3);
            con.add(lblPricePurchase);
            con.add(txtPricePurchase);
            con.add(lblEmpty4);
            con.add(lblPriceSale);
            con.add(txtPriceSale);
            con.add(lblEmpty5);
            con.add(lblQOH);
            con.add(txtQOH);
            con.add(lblEmpty6);
            con.add(lblROP);
            con.add(txtROP);
            con.add(lblEmpty7);
            con.add(lblStatusItem);
            con.add(cmbStatusItem);
            con.add(lblDoIntroduced);
            con.add(dteDob);

        JLabel lblfristEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            con.add(lblfristEnd);
        
            con.add(btnDelet);
            con.add(btnUpdate);
            con.add(btnClear);
            con.add(btnAdd);

        JLabel lblFormEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            con.add(lblFormEnd);
        
         //Search
        lblSearchName  = new JLabel("Name :");
        txtSearchName  = new JTextField( 20 );
        lblSearchBrand  = new JLabel("Brand :");
        cmbSearchBrand = new JComboBox();
        lblSearchSubCategory  = new JLabel("Sub Category :");
        cmbSearchSubCategory = new JComboBox();
        btnSearch  = new JButton("Search");
        btnSearchClear  = new JButton("Search Clear"); 

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchBrand);
        con.add(cmbSearchBrand);
        con.add(lblSearchSubCategory);
        con.add(cmbSearchSubCategory);

        JLabel lblfristEnd4 = new JLabel("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblfristEnd4);
        con.add(btnSearch);
        con.add(btnSearchClear);
        con.add(lblfristEnd4);

        titles = new Vector();
        titles.add("Name");
        titles.add("Brand");
        titles.add("Code");
        titles.add("SubCategory");
        titles.add("PricePurchase");
        titles.add("PriceSale");
        titles.add("Profit");
        titles.add("QOH");
        titles.add("ROP");
        titles.add("StatusItem");
        titles.add("DoIntroduced");

        data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblItem = new JTable();
        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
            jspTable.setPreferredSize(new Dimension(900, 200));
            jspTable.setViewportView(tblItem);
        con.add(jspTable);

        txtName.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtNameKR( e ); } } ); 
        txtCode.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtCodeKR( e ); } } ); 
        txtPricePurchase.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtPricePurchaseKR( e ); } } ); 
        txtPriceSale.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtPriceSaleKR( e ); } } ); 
        txtQOH.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtQOHKR( e ); } } ); 
        txtROP.addKeyListener( new KeyAdapter(){ public void keyReleased(KeyEvent e){ txtROPKR( e ); } } );   
        cmbBrand.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmbBrandAp( e );  }  } );
        cmblSubCategory.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmblSubCategoryAp( e );  }  } );
        cmbStatusItem.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ cmbStatusItemAp( e );  }  } );
        dteDob.addPropertyChangeListener( new PropertyChangeListener(){ public void propertyChange(PropertyChangeEvent e){ dteDobAp( e );  }  } );
       
        btnSearch.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchAp( e );  }  } );
        btnSearchClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnSearchClearAp( e );  }  } );
        btnAdd.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnAddAp(e);  }  } );
        btnClear.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnClearAp( e );  }  } );
        btnUpdate.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnUpdateAp( e );  }  } );
        btnDelet.addActionListener( new ActionListener(){ public void actionPerformed(ActionEvent e){ btnDeleteAp( e );  }  } );
        tblItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tblItemVC(e);
            }
        });
        intitialize();  

    }

    //UI-Controller-Intitialize

    public void intitialize() {
        loadView();
        loadform();
    }
    

    public void loadform() {

        item = new Item();  

        //Brand
        bralist = BrandController.get();
        Vector<Object> brands = new Vector();
        brands.add("Select a Brand");

        for(Brand bra: bralist){
            brands.add(bra);         
      
        }

        DefaultComboBoxModel<Object> braModel = new DefaultComboBoxModel(brands);
        cmbBrand.setModel(braModel); 

        //SubCategory
        sublist = SubCategoryController.get();
        Vector<Object> subcategorys = new Vector();
        subcategorys.add("Select a SubCategory");

        for(SubCategory sub: sublist){
            subcategorys.add(sub);         
        }
  
        DefaultComboBoxModel<Object> subModel = new DefaultComboBoxModel(subcategorys);
        cmblSubCategory.setModel(subModel);

        //StatusItem
        stalist = StatusItemController.get();
        Vector<Object> statusitems = new Vector();
        statusitems.add("Select StatusItem");

        for(StatusItem sta: stalist){
            statusitems.add(sta);         
        }

        DefaultComboBoxModel<Object> seModel = new DefaultComboBoxModel(statusitems);
        cmbStatusItem.setModel(seModel);

        //DobDay
        dteDob.setDate(null);
        
        txtName.setText("");
        txtCode.setText("");
        txtPricePurchase.setText("");
        txtPriceSale.setText("");
        txtQOH.setText("");
        txtROP.setText("");
        

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
        txtCode.setBackground(clr);
        txtPricePurchase.setBackground(clr);
        txtPriceSale.setBackground(clr);
        txtQOH.setBackground(clr);
        txtROP.setBackground(clr);
        

        cmbBrand.setBackground(clr);
        cmblSubCategory.setBackground(clr);
        cmbStatusItem.setBackground(clr);

        JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
        dtpDisplay.setBackground(clr);
    }

    public void fillForm(){

        enabledButtons(false,true,true);
        setStyle(valid);
    }

    public void loadView(){

        itelist = ItemController.get(null);
        fillTable(itelist);

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
        cmbSearchSubCategory.setModel(subModel);

    }


    public void fillTable(List<Item> items) {

        data = new Vector();

        for (Item emp : items) {

            Vector r = new Vector();
            
            r.add(emp.getName());
            r.add(emp.getBrand().getName());
            r.add(emp.getCode());
            r.add(emp.getSubCategory().getName());
            r.add(emp.getPricePurchase());
            r.add(emp.getPriceSale());
            r.add(emp.getPriceSale()-emp.getPricePurchase());
            r.add(emp.getQOH());
            r.add(emp.getROP());
            r.add(emp.getStatusItem().getName());
            r.add(emp.getDoIntroduced().toString());

            data.add(r);
        }

        DefaultTableModel model =  new DefaultTableModel(data , titles); 
        tblItem.clearSelection();
        tblItem.setModel(model);

    }

    //UI-Controller-Interactive

    //validating and Binding

    public void txtNameKR(KeyEvent e){

        String name = txtName.getText();
        if( name.matches("^[A-Z][a-z]*$")){
            item.setName(name);
            txtName.setBackground(valid);
        }else{ 
            txtName.setBackground(invalid);
            //error = error + "\n Invalid Name";
        } 

    }

    public void txtCodeKR(KeyEvent e){

        String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$")){
            item.setCode(code);
            txtCode.setBackground(valid);
        }else{
            txtCode.setBackground(invalid);
            //error =error +"\n invalid Code";
        } 

    }

    public void txtPricePurchaseKR(KeyEvent e){

        String pricepurchase = txtPricePurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{2})?$")){
            item.setPricePurchase(Double.parseDouble(pricepurchase));
            txtPricePurchase.setBackground(valid);
        }else{
            txtPricePurchase.setBackground(invalid);
            //error =error +"\n invalid PricePurchase";
        } 

    }

    public void txtPriceSaleKR(KeyEvent e){

        String pricesale = txtPriceSale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{2})?$")){
            item.setPriceSale(Double.parseDouble(pricesale));
            txtPriceSale.setBackground(valid);
        }else{
            txtPriceSale.setBackground(invalid);
            //error =error +"\n invalid PriceSale";
        } 

    }

    public void txtQOHKR(KeyEvent e){

        String qoh = txtQOH.getText();
        if(qoh.matches("^\\d{1,5}$")){
            item.setQOH(Integer.parseInt(qoh));
            txtQOH.setBackground(valid);
        }else{
            txtQOH.setBackground(invalid);
            //error =error +"\n invalid QOH";
        } 

    }

    public void txtROPKR(KeyEvent e){

        String rop = txtROP.getText();
        if(rop .matches("^\\d{1,5}$")){
            item.setROP(Integer.parseInt(rop));
            txtROP.setBackground(valid);
        }else{
            txtROP.setBackground(invalid);
            //error =error +"\n invalid ROP";
        } 

    }

    public void cmbBrandAp(ActionEvent e){

        int brandindex = cmbBrand.getSelectedIndex();
        if(brandindex != 0){
          cmbBrand.setBackground(valid);
          item.setBrand((Brand)cmbBrand.getSelectedItem() );
        }else{
          cmbBrand.setBackground(invalid);
          //error =error +"\n Brand Not selected";
        }  
    }

    public void cmblSubCategoryAp(ActionEvent e){

        int subindex = cmblSubCategory.getSelectedIndex();
        if(subindex != 0){
          cmblSubCategory.setBackground(valid);
          item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
        }else{
          cmblSubCategory.setBackground(invalid);
          //error =error +"\n Sub Category Not selected";
        } 
    }

    public void cmbStatusItemAp(ActionEvent e){

        int Siindex = cmbStatusItem.getSelectedIndex();
        if(Siindex != 0){
          cmbStatusItem.setBackground(valid);
          item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
        }else{
          cmbStatusItem.setBackground(invalid);
          //error =error +"\n StatusItem Not selected";
        } 
    }

    public void dteDobAp(PropertyChangeEvent e){

        java.util.Date dt = dteDob.getDate();
        if( dt !=null){ 
            JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
            dtpDisplay.setBackground(valid);
            LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth(),dt.getDate());
            item.setDoIntroduced(dointroduced);
        }else{ 
            JTextField dtpDisplay1=(JTextField)dteDob.getDateEditor().getUiComponent();
            dtpDisplay1.setBackground(invalid);
            //error = error + "\n Set Date ";
        }

    }
    //Form Handling

    public void btnSearchAp(ActionEvent e){ 

        String name = txtSearchName.getText().trim();
        name = (name.equals(""))? null : name;
        Object sitem = cmbSearchBrand.getSelectedItem();
        Object sitem1 = cmbSearchSubCategory.getSelectedItem();
        Brand brand = null; 
        SubCategory subcategory = null; 


        if(!sitem.equals("Select brand"))
        brand = (Brand)sitem;

        if(!sitem1.equals("Select SubCategory"))
        subcategory  = (SubCategory) sitem1;

        HashMap<String , Object> ht = new HashMap<>();
        ht.put("name", name);
        if(brand!=null)ht.put("brand", brand);
        if(subcategory!=null)ht.put("subcategory", subcategory);
        
        List<Item> items = ItemController.get(ht);
        fillTable(items); 

    } 

    public void btnSearchClearAp(ActionEvent e){ 

        int opt = JOptionPane.showConfirmDialog(null,"Are you sure to Clear the Search");

        if(opt!=1){

            txtSearchName.setText("");
            cmbSearchBrand.setSelectedIndex(0);
            cmbSearchSubCategory.setSelectedIndex(0);

            List<Item> items = ItemController.get(null);
            fillTable(items);  
        
        }
    }

    public void btnAddAp(ActionEvent e){
    
        String error ="";
        
        //Name
        String name = txtName.getText();
        if(name.matches("^[a-zA-Z\\s0-9]+?")){
              item.setName(name);
              txtName.setBackground(valid);
        }else{
            txtName.setBackground(invalid);
            error =error +"\n invalid Name";
        }
        
        //Code
        String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$")){
            item.setCode(code);
            txtCode.setBackground(valid);
        }else{
          txtCode.setBackground(invalid);
          error =error +"\n invalid Code";
        }

        //PricePurchase
        String pricepurchase = txtPricePurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{2})?$")){
            item.setPricePurchase(Double.parseDouble(pricepurchase));
            txtPricePurchase.setBackground(valid);
        }else{
           txtPricePurchase.setBackground(invalid);
           error =error +"\n invalid PricePurchase";
        }
    
        //PriceSale
        String pricesale = txtPriceSale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{2})?$")){
            item.setPriceSale(Double.parseDouble(pricesale));
            txtPriceSale.setBackground(valid);
        }else{
            txtPriceSale.setBackground(invalid);
            error =error +"\n invalid PriceSale";
        }

        //QOH
        String qoh = txtQOH.getText();
        if(qoh.matches("^\\d{1,5}$")){
            item.setQOH(Integer.parseInt(qoh));
            txtQOH.setBackground(valid);
        }else{
            txtQOH.setBackground(invalid);
            error =error +"\n invalid QOH";
        }

        //ROP
        String rop = txtROP.getText();
        if(rop .matches("^\\d{1,5}$")){
            item.setROP(Integer.parseInt(rop));
            txtROP.setBackground(valid);
        }else{
            txtROP.setBackground(invalid);
            error =error +"\n invalid ROP";
        }
      
        //Brand
        int brandindex = cmbBrand.getSelectedIndex();
        if(brandindex != 0){
          cmbBrand.setBackground(valid);
          item.setBrand((Brand)cmbBrand.getSelectedItem() );
        }else{
          cmbBrand.setBackground(invalid);
          error =error +"\n Brand Not selected";
        }

        //SubCategory
        int subindex = cmblSubCategory.getSelectedIndex();
        if(subindex != 0){
          cmblSubCategory.setBackground(valid);
          item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
        }else{
          cmblSubCategory.setBackground(invalid);
          error =error +"\n Sub Category Not selected";
        }

        //StatusItem
        int Siindex = cmbStatusItem.getSelectedIndex();
        if(Siindex != 0){
          cmbStatusItem.setBackground(valid);
          item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
        }else{
          cmbStatusItem.setBackground(invalid);
          error =error +"\n StatusItem Not selected";
        }
    
        //Day,manth,year
        java.util.Date dt = dteDob.getDate();
        if( dt !=null){ 
            JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
            dtpDisplay.setBackground(valid);
            LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth(),dt.getDate());
            item.setDoIntroduced(dointroduced);
        }else{ 
            JTextField dtpDisplay1=(JTextField)dteDob.getDateEditor().getUiComponent();
            dtpDisplay1.setBackground(invalid);
            error = error + "\n Set Date ";
        }

    
        if(error.isEmpty()){


            String cnfMsg = "Are you sure to save following item?\n\n";
            cnfMsg = cnfMsg+"\nName :" +item.getName();
            cnfMsg = cnfMsg+"\nBrand :" +item.getBrand().getName();
            cnfMsg = cnfMsg+"\nCode :" +item.getCode();
            cnfMsg = cnfMsg+"\nSubcategory :" +item.getSubCategory().getName();
            cnfMsg = cnfMsg+"\nPrice Purchase :" +item.getPricePurchase();
            cnfMsg = cnfMsg+"\nPrice Sale :" +item.getPriceSale();
            cnfMsg = cnfMsg+"\nQOH :" +item.getQOH();
            cnfMsg = cnfMsg+"\nROP :" +item.getROP();
            cnfMsg = cnfMsg+"\nStatus Item :" +item.getStatusItem().getName();
            cnfMsg = cnfMsg+"\nDo Introduced :" +item.getDoIntroduced().toString();

           int cof= JOptionPane.showConfirmDialog(null,cnfMsg);
      
      
            if(cof==0){
                String st= ItemController.post(item);
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

    public void tblItemVC(ListSelectionEvent e){
        int row = tblItem.getSelectedRow(); 
            if(row>-1){
                Item item = itelist.get(row);
                fillForm(item);
            }
    }

    public void fillForm(Item item){

        olditem = item;

        txtName.setText(item.getName());
        txtCode.setText(item.getCode());
        txtPricePurchase.setText(item.getPricePurchase().toString());
        txtPriceSale.setText(item.getPriceSale().toString());
        txtQOH.setText(String.valueOf(item.getQOH()));
        txtROP.setText(String.valueOf(item.getROP()));
  
        for(Brand bra: bralist){
            if(bra.getId()==item.getBrand().getId()){
                cmbBrand.setSelectedItem(bra);
                break;
            }    
        }
        
        for(SubCategory sub: sublist){
            if(sub.getId()==item.getSubCategory().getId()){
                cmblSubCategory.setSelectedItem(sub);
                break;
            }    
        }

        for(StatusItem sta: stalist){
            if(sta.getId()==item.getStatusItem().getId()){
                cmbStatusItem.setSelectedItem(sta);
                break;
            }    
        }
 
        dteDob.setDate( new java.util.Date(item.getDoIntroduced().toEpochDay() * 1000*3600*24));
        
        enabledButtons(false,true,true);
        setStyle(valid);
    }

    public void btnClearAp(ActionEvent e){ 
        int conf = JOptionPane.showConfirmDialog(null,"Are you sure to clear the form?" );
        if(conf==0) loadform();
    }

    public String getErrors(){ String errors=""; return errors; }

    public String getUpdates(){ String updates=""; return updates; }

    public void btnUpdateAp(ActionEvent e){ 

       Item item = new Item();
       item.setId(olditem.getId());

        String error = "";
        String updates = "";

        //Name
        String name = txtName.getText(); 
        if( name.matches("^[a-zA-Z\\s0-9]+?")){
            
            if( name.equals(olditem.getName())){
                txtName.setBackground(valid);
            }else{ 
                txtName.setBackground(updated); 
                updates = updates + "\n Name Updated "; 
            }
            item.setName(name);
        }else{ 
            txtName.setBackground(invalid);
            error = error + "\n Invalid Name";
        } 

        //Code
        String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$")){
            if(code.equals(olditem.getCode())){
                txtCode.setBackground(valid);
            }else{
                txtCode.setBackground(updated); 
                updates = updates + "\n Code Updated ";                    
            }
            item.setCode(code);
        }else{ 
            txtCode.setBackground(invalid);
            error = error + "\n Invalid Code";
        }
        
        //PricePurchase
        String pricepurchase = txtPricePurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{1})?$")){
            if(pricepurchase.equals(olditem.getPricePurchase())){
                txtPricePurchase.setBackground(valid);
            }else{
                txtPricePurchase.setBackground(updated); 
                updates = updates + "\n Price Purchase Updated ";                    
            }
            item.setPricePurchase(Double.parseDouble(pricepurchase));
        }else{ 
            txtPricePurchase.setBackground(invalid);
            error = error + "\n Invalid Price Purchase";
        }

        //PriceSale
        String pricesale = txtPriceSale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{1})?$")){
            if(pricesale.equals(olditem.getPriceSale())){
                txtPriceSale.setBackground(valid);
            }else{
                txtPriceSale.setBackground(updated); 
                updates = updates + "\n Price Sale Updated ";                    
            }
            item.setPriceSale(Double.parseDouble(pricesale));
        }else{ 
            txtPriceSale.setBackground(invalid);
            error = error + "\n Invalid Price Sale";
        }

        //QOH
        String qoh = txtQOH.getText();
        if(qoh.matches("^\\d{1,5}$")){
            if(qoh.equals(olditem.getQOH())){
                txtQOH.setBackground(valid);
            }else{
                txtQOH.setBackground(updated); 
                updates = updates + "\nQOH Updated ";                    
            }
            item.setQOH(Integer.parseInt(qoh));
        }else{ 
            txtQOH.setBackground(invalid);
            error = error + "\n Invalid QOH";
        }

        //ROP
        String rop = txtROP.getText();
        if(rop.matches("^\\d{1,5}$")){
            if(rop.equals(olditem.getROP())){
                txtROP.setBackground(valid);
            }else{
                txtROP.setBackground(updated); 
                updates = updates + "\nROP Updated ";                    
            }
            item.setROP(Integer.parseInt(rop));
        }else{ 
            txtROP.setBackground(invalid);
            error = error + "\n Invalid QOH";
        }

        //Brand
        int brandindex = cmbBrand.getSelectedIndex();
        if(brandindex != 0){
            Brand brand = (Brand) cmbBrand.getSelectedItem();
            if(brand.equals(olditem.getBrand())){
                cmbBrand.setBackground(valid); 
            }else{
                cmbBrand.setBackground(updated);
                updates = updates + "\n Brand Updated "; 
            }
            item.setBrand((Brand)cmbBrand.getSelectedItem() );
        }else{ 
            cmbBrand.setBackground(invalid);
            error = error + "\n Brand not Selected";
        } 
        
        //SubCategory
        int subindex = cmblSubCategory.getSelectedIndex();
        if(subindex != 0){
            SubCategory subcategory = (SubCategory) cmblSubCategory.getSelectedItem();
            if(subcategory.equals(olditem.getSubCategory())){
                cmblSubCategory.setBackground(valid); 
            }else{
                cmblSubCategory.setBackground(updated);
                updates = updates + "\n SubCategory Updated "; 
            }
            item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
        }else{ 
            cmblSubCategory.setBackground(invalid);
            error = error + "\n SubCategory not Selected";
        } 

        //StatusItem
        int Siindex = cmbStatusItem.getSelectedIndex();
        if(Siindex != 0){
            StatusItem statusitem = (StatusItem) cmbStatusItem.getSelectedItem();
            if(statusitem.equals(olditem.getStatusItem())){
                cmbStatusItem.setBackground(valid); 
            }else{
                cmbStatusItem.setBackground(updated);
                updates = updates + "\n Status Item Updated "; 
            }
            item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
        }else{ 
            cmbStatusItem.setBackground(invalid);
            error = error + "\n Status Item not Selected";
        }
 
        //Day,manth,year
        java.util.Date dt = dteDob.getDate();
        if( dt !=null){ 
            LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth(),dt.getDate());
            if(dointroduced.equals(olditem.getDoIntroduced())){
                JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
                dtpDisplay.setBackground(valid);
            }else{
                updates = updates + "\n Date Updated ";
                JTextField dtpDisplay=(JTextField)dteDob.getDateEditor().getUiComponent();
                dtpDisplay.setBackground(updated);
            }
            item.setDoIntroduced(dointroduced);   
        }else{ 
            JTextField dtpDisplay1=(JTextField)dteDob.getDateEditor().getUiComponent();
            dtpDisplay1.setBackground(invalid);
            error = error + "\n Set Date ";
        }

       if(error.isEmpty() ){ 
            if(!updates.isEmpty()){
                int resp = JOptionPane.showConfirmDialog(null,"You have following Updates\n\n"+updates);
                if(resp==0){ 
                    String status = ItemController.put(item);
                    if(status.equals("1")){
                        int lsrow = tblItem.getSelectedRow(); 
                        loadView();
                        tblItem.setRowSelectionInterval(lsrow, lsrow);
                        loadform();
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
        
        int resp = JOptionPane.showConfirmDialog(null,"Are you sure to Delete following Item\n\n"+olditem.getName());
        if(resp==0){ 
            String status = ItemController.delete(olditem);
            if(status.equals("1")){
                int lsrow = tblItem.getSelectedRow(); 
                loadView();
                tblItem.setRowSelectionInterval(lsrow, lsrow);
                loadform();
                JOptionPane.showMessageDialog(null, "Succesfully Delete");
                            
            }else{ 
                JOptionPane.showMessageDialog(null, "Failed to Delete as \n\n"+status);
            }
        }
    }

}