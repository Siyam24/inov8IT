package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {

    private int cusID;
    private String cusName;
    private String NICno;
    private String telNo;
    private String Email;
    private String Address;



    public Customer(String cusName,String NICno,String telNo,String Email,String Address){

        this.cusName=cusName;
        this.NICno=NICno;
        this.telNo=telNo;
        this.Email=Email;
        this.Address=Address;
    }
    public Customer(int cusID,String cusName,String NICno,String telNo,String Email,String Address){

        this.cusID=cusID;
        this.cusName=cusName;
        this.NICno=NICno;
        this.telNo=telNo;
        this.Email=Email;
        this.Address=Address;
    }

    public int getCusID(){
        return cusID;
    }
    public String getCusName(){
        return cusName;
    }
    public String getNICno(){
        return NICno;
    }
    public String getTelNo(){
        return telNo;
    }
    public String getEmail(){
        return Email;
    }
    public String getAddress(){
        return Address;
    }




}
