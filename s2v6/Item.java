import java.time.LocalDate;

public class Item {

    private int id;
    private Brand brand;
    private SubCategory subcategory;
    private String name;
    private String code;
    private Double pricepurchase;
    private Double pricesale;
    private int qoh;
    private int rop;
    private StatusItem statusitem;
    private LocalDate dointroduced;

    Item() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setSubCategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }

    public SubCategory getSubCategory() {
        return subcategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setPricePurchase(Double pricepurchase) {
        this.pricepurchase = pricepurchase;
    }

    public Double getPricePurchase() {
        return pricepurchase;
    }

    public void setPriceSale(Double pricesale) {
        this.pricesale = pricesale;
    }

    public Double  getPriceSale() {
        return pricesale;
    }

    public void setQOH(int qoh) {
        this.qoh = qoh;
    }

    public int getQOH() {
        return qoh;
    }

    public void setROP(int rop) {
        this.rop = rop;
    }

    public int getROP() {
        return rop;
    }

    public void setStatusItem(StatusItem statusitem) {
        this.statusitem = statusitem;
    }

    public StatusItem getStatusItem() {
        return statusitem;
    }

    public void setDoIntroduced(LocalDate dointroduced) {
        this.dointroduced = dointroduced;
    }

    public LocalDate getDoIntroduced() {
        return dointroduced;
    }

}