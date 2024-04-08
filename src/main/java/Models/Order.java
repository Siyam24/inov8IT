package Models;

import java.time.LocalDate;


public class Order {

    private LocalDate date;
    private String CusName;
    private String EmpName;
    private String Item;
    private int QTY;
    private String Weight;
    private int orderId;

    public Order(LocalDate date,String CusName,String EmpName,String Item,int QTY,String Weight){
        this.date=date;
        this.CusName=CusName;
        this.EmpName=EmpName;
        this.Item=Item;
        this.QTY=QTY;
        this.Weight=Weight;
    }

    public Order(int orderId,LocalDate date,String CusNameOr,String EmpNameOr,String Item,int QTY,String Weight){
        this.orderId=orderId;
        this.date=date;
        this.CusName=CusNameOr;
        this.EmpName=EmpNameOr;
        this.Item=Item;
        this.QTY=QTY;
        this.Weight=Weight;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCusName() {
        return CusName;
    }

    public String getEmpName() {
        return EmpName;
    }




    public String getItem() {
        return Item;
    }

    public int getQTY() {
        return QTY;
    }

    public String getWeight() {
        return Weight;
    }
}
