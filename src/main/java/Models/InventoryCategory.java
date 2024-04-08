package Models;

import javafx.beans.property.StringProperty;

public class InventoryCategory {
    private String id;
    private String name;

    public InventoryCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public InventoryCategory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String idProperty(){
        return id;
    }

    public String nameProperty(){
        return name;
    }

}