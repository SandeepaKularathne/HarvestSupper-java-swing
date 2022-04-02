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
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter; 

import java.time.LocalDate;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.beans.PropertyChangeEvent;

import com.toedter.calendar.JDateChooser;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    JDateChooser dteDoIntroduced;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelete; 

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

    Item oldItem;
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
        
        //DoIntroduced
        dteDoIntroduced = new JDateChooser();

        //Button
        btnAdd = new JButton(" Add ",iconAddBlack);
        btnClear = new JButton(" Clear ",iconClearBlack); 
        btnUpdate  = new JButton(" Update ",iconUpdateBlack);
        btnDelete  = new JButton(" Delete ",iconDeleteBlack); 

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
            con.add(dteDoIntroduced);

        JLabel lblfristEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            con.add(lblfristEnd);
        
            con.add(btnDelete);
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
        btnSearch  = new JButton("Search",iconSerchBlack );
        btnSearchClear  = new JButton("SearchClear",iconClearBlack); 

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
        cmbBrand.addActionListener(e -> cmbBrandAp( e ));
        cmblSubCategory.addActionListener(e -> cmblSubCategoryAp( e ));
        cmbStatusItem.addActionListener(e -> cmbStatusItemAp( e ));
        dteDoIntroduced.addPropertyChangeListener(e -> dteDoIntroducedAp( e ));
       
        btnSearch.addActionListener(e -> btnSearchAp( e ));
        btnSearchClear.addActionListener(e -> btnSearchClearAp( e ));
        btnAdd.addActionListener(e -> btnAddAp( e ));
        btnClear.addActionListener(e -> btnClearAp( e ));
        btnUpdate.addActionListener(e -> btnUpdateAp( e ));
        btnDelete.addActionListener(e -> btnDeleteAp( e ));
         
        tblItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent e) {tblItemVC(e);}});
        
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
        dteDoIntroduced.setDate(null);
        
        txtName.setText("");
        txtCode.setText("I0000");
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
        btnDelete.setEnabled(delt);

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

        JTextField dtpDisplay=(JTextField)dteDoIntroduced.getDateEditor().getUiComponent();
        dtpDisplay.setBackground(clr);
    }

    public void fillForm(Item itm){

        oldItem = itm;

        item = new Item();
        item.setName(itm.getName());
        item.setCode(itm.getCode());
        item.setBrand(itm.getBrand());
        item.setSubCategory(itm.getSubCategory());
        item.setPricePurchase(itm.getPricePurchase());
        item.setPriceSale(itm.getPriceSale());
        item.setQOH(itm.getQOH());
        item.setROP(itm.getROP());
        item.setStatusItem(itm.getStatusItem());
        item.setDoIntroduced(itm.getDoIntroduced());

        txtName.setText(itm.getName());
        txtCode.setText(itm.getCode());
        txtPricePurchase.setText(String.valueOf(itm.getPricePurchase()));
        txtPriceSale.setText(String.valueOf(itm.getPriceSale()));
        txtQOH.setText(String.valueOf(itm.getQOH()));
        txtROP.setText(String.valueOf(itm.getROP()));

        for(Brand bra: bralist){
            if(bra.getId()==itm.getBrand().getId()){
                cmbBrand.setSelectedItem(bra);
                break;
            }
        }

        for(SubCategory sub: sublist){
            if(sub.getId()==itm.getSubCategory().getId()){
                cmblSubCategory.setSelectedItem(sub);
                break;
            }
        }

        for(StatusItem sta: stalist){
            if(sta.getId()==itm.getStatusItem().getId()){
                cmbStatusItem.setSelectedItem(sta);
                break;
            }
        }

        dteDoIntroduced.setDate( new java.util.Date(itm.getDoIntroduced().toEpochDay() * 1000*3600*24));


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
            if(oldItem!=null){
                if(!name.equals(oldItem.getName()))
                    txtName.setBackground(updated);
                else
                    txtName.setBackground(valid);
            }else
                txtName.setBackground(valid);
        }else{ 
            item.setName(null);
            txtName.setBackground(invalid);
        } 

    }

    public void txtCodeKR(KeyEvent e){

        String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$")){
            item.setCode(code);
            if(oldItem!=null){
                if(!code.equals(oldItem.getCode()))
                    txtCode.setBackground(updated);
                else
                    txtCode.setBackground(valid);
            }else
                txtCode.setBackground(valid);
        }else{
            txtCode.setBackground(invalid);
            item.setCode(null);
        } 

    }

    public void txtPricePurchaseKR(KeyEvent e){

        String pricepurchase = txtPricePurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{1})?$|^\\d{1,6}(.\\d{2})?$")){
            item.setPricePurchase(Double.parseDouble(pricepurchase));
            if(oldItem!=null){
                if(Double.parseDouble(pricepurchase)!= oldItem.getPricePurchase())
                    txtPricePurchase.setBackground(updated);
                else
                    txtPricePurchase.setBackground(valid);
            }else
                txtPricePurchase.setBackground(valid);
        }else{
            txtPricePurchase.setBackground(invalid);
            item.setPricePurchase(Double.parseDouble(null));
        } 

    }

    public void txtPriceSaleKR(KeyEvent e){

        String pricesale = txtPriceSale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{1})?$|^\\d{1,6}(.\\d{2})?$")){
            item.setPriceSale(Double.parseDouble(pricesale));
            if(oldItem!=null){
                if(Double.parseDouble(pricesale)!= oldItem.getPriceSale())
                    txtPriceSale.setBackground(updated);
                else
                    txtPriceSale.setBackground(valid);
            }else
                txtPriceSale.setBackground(valid);
        }else{
            txtPriceSale.setBackground(invalid);
            item.setPriceSale(Double.parseDouble(null));
        } 

    }

    public void txtQOHKR(KeyEvent e){

        String qoh = txtQOH.getText();
        if(qoh.matches("^\\d{1,5}$")){
            item.setQOH(Integer.parseInt(qoh));
            if(oldItem!=null){
                if(Integer.parseInt(qoh) != oldItem.getQOH())
                    txtQOH.setBackground(updated);
                else
                    txtQOH.setBackground(valid);
            }else
                txtQOH.setBackground(valid);
        }else{
            txtQOH.setBackground(invalid);
            item.setQOH(0);
        } 

    }

    public void txtROPKR(KeyEvent e){

        String rop = txtROP.getText();
        if(rop .matches("^\\d{1,5}$")){
            item.setROP(Integer.parseInt(rop));
            if(oldItem!=null){
                if(Integer.parseInt(rop) != oldItem.getROP())
                    txtROP.setBackground(updated);
                else
                    txtROP.setBackground(valid);
            }else
                txtROP.setBackground(valid);
        }else{
            txtROP.setBackground(invalid);
            item.setROP(0);
        } 

    }

    public void cmbBrandAp(ActionEvent e){

        int brandindex = cmbBrand.getSelectedIndex();
        Brand brands = (Brand) cmbBrand.getSelectedItem();
        if(brandindex != 0){
          item.setBrand((Brand)cmbBrand.getSelectedItem() );
          if(oldItem!=null){
              if(!brands.equals(oldItem.getBrand()))
                  cmbBrand.setBackground(updated);
              else
                  cmbBrand.setBackground(valid);
          }else
              cmbBrand.setBackground(valid);
        }else{
          cmbBrand.setBackground(invalid);
          item.setBrand(null);
        }  
    }

    public void cmblSubCategoryAp(ActionEvent e){

        int subindex = cmblSubCategory.getSelectedIndex();
        SubCategory subcategorys = (SubCategory) cmblSubCategory.getSelectedItem();
        if(subindex != 0){
          item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
          if(oldItem!=null){
              if(!subcategorys.equals(oldItem.getBrand()))
                  cmblSubCategory.setBackground(updated);
              else
                  cmblSubCategory.setBackground(valid);
          }else
              cmblSubCategory.setBackground(valid);
        }else{
          cmblSubCategory.setBackground(invalid);
          item.setSubCategory(null);
        } 
    }

    public void cmbStatusItemAp(ActionEvent e){

        int Siindex = cmbStatusItem.getSelectedIndex();
        StatusItem statusitems = (StatusItem) cmbStatusItem.getSelectedItem();
        if(Siindex != 0){
          cmbStatusItem.setBackground(valid);
          item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
          if(oldItem!=null){
              if(!statusitems.equals(oldItem.getBrand()))
                  cmbStatusItem.setBackground(updated);
              else
                  cmbStatusItem.setBackground(valid);
          }else
              cmbStatusItem.setBackground(valid);
        }else{
          cmbStatusItem.setBackground(invalid);
          item.setStatusItem(null);
        } 
    }

    public void dteDoIntroducedAp(PropertyChangeEvent e){

        java.util.Date dt = dteDoIntroduced.getDate();
        JTextField dtpDisplay=(JTextField)dteDoIntroduced.getDateEditor().getUiComponent();
        if( dt !=null){
            LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth()+1,dt.getDate());
            item.setDoIntroduced(dointroduced);
            if(oldItem!=null){
                if(!dointroduced.equals(oldItem.getDoIntroduced()))
                    dtpDisplay.setBackground(updated);
                else
                    dtpDisplay.setBackground(valid);
            }else
                dtpDisplay.setBackground(valid);
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
    
        String error = getErrors();
    
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

    public void btnClearAp(ActionEvent e){ 
        int conf = JOptionPane.showConfirmDialog(null,"Are you sure to clear the form?" );
        if(conf==0) loadform();
        oldItem = null;
    }

    public String getErrors(){

        String error = "";

        if (item.getName()==null) error = error + "\n Invalid Name";
        if (item.getCode()==null) error = error +"\n invalid Code";
        if (item.getPricePurchase()==0) error =error +"\n invalid Purchase Price";
        if (item.getPriceSale()==0)error =error +"\n invalid Sale Price";
        if (item.getQOH()==0)error =error +"\n invalid QOH";
        if (item.getROP()==0)error =error +"\n invalid ROP";
        if (item.getBrand()==null)error =error +"\n Brand Not selected";
        if (item.getSubCategory()==null)error =error +"\n Sub Category Not selected";
        if (item.getStatusItem()==null)error =error +"\n StatusItem Not selected";
        if (item.getDoIntroduced()==null)error = error + "\n Set Date ";

        return error;
    }

    public String getUpdates(){
        String updates="";

        Brand brand = (Brand) cmbBrand.getSelectedItem();
        SubCategory subcategory = (SubCategory) cmblSubCategory.getSelectedItem();
        StatusItem statusitem = (StatusItem)cmbStatusItem.getSelectedItem();
        java.util.Date dt = dteDoIntroduced.getDate();
        LocalDate dointroduced = LocalDate.of(dt.getYear()+1900,dt.getMonth()+1,dt.getDate());

        if(!txtName.getText().equals(oldItem.getName()))
            updates = updates + "\n Name Updated ";

        if(!txtCode.getText().equals(oldItem.getCode()))
            updates = updates + "\n Code Updated ";

        if(Double.parseDouble(txtPricePurchase.getText())!= oldItem.getPricePurchase())
            updates = updates + "\n Price Purchase Updated ";

        if(Double.parseDouble(txtPriceSale.getText())!=oldItem.getPriceSale())
            updates = updates + "\n Price Sale Updated ";

        if(Integer.parseInt(txtQOH.getText()) != oldItem.getQOH())
            updates = updates + "\nQOH Updated ";

        if(Integer.parseInt(txtROP.getText()) != oldItem.getROP())
            updates = updates + "\nROP Updated ";

        if(!brand.getName().equals(oldItem.getBrand().getName()))
            updates = updates + "\n Brand Updated ";

        if(!subcategory.getName().equals(oldItem.getSubCategory().getName()))
            updates = updates + "\n SubCategory Updated ";

        if(!statusitem.getName().equals(oldItem.getStatusItem().getName()))
            updates = updates + "\n Status Item Updated ";

        if(!dointroduced.equals(oldItem.getDoIntroduced()))
            updates = updates + "\n Date Updated ";

        return updates;
    }

    public void btnUpdateAp(ActionEvent e){ 

        item.setId(oldItem.getId());
        String error = getErrors();

       if(error.isEmpty() ){
           String updates = getUpdates();
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
        
        int resp = JOptionPane.showConfirmDialog(null,"Are you sure to Delete following Employee\n\n"+oldItem.getName());
        if(resp==0){ 
            String status = ItemController.delete(oldItem);
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