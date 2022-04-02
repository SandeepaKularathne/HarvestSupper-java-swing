package lk.harvest.entity;
public class SubCategory {

    private int id;
    private String name;

    public SubCategory() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){ 
        return name;
    }

}