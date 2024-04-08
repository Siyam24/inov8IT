package Models;

public class InventoryType {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private String status;

    public InventoryType(int id, String name, String category, int quantity, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
    }

    public InventoryType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String nameProperty(){
        return name;
    }

    public String categoryProperty(){
        return category;
    }

    public String statusProperty(){
        return status;
    }

    public int quantityProperty(){
        return quantity;
    }


    public int idProperty(){
        return id;
    }
}