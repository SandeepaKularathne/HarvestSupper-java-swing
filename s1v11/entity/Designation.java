package entity;

public class Designation{  

    private int id;
    private String name;

    public Designation(){ }

        public void setId(int id){ this.id = id; }
        public int getId(){ return id; }

        public void setName(String name){ this.name = name; }
        public String getName(){ return name; } 

        public String toString(){ return name; }

        public boolean equals(Designation obj){ return obj.id==this.id; }

    
}