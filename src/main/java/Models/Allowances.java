package Models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Allowances {
    private int SalaryID;
    private int EmpID;
    private String EmpName;
    private double Bsalary;
    private int TotalOT;
    private double RatePerHr;

    private double TotalAmount;

    public Allowances(int EmpID,String EmpName,double Bsalary, int TotalOT,double RatePerHr,double TotalAmount){
        this.EmpID= EmpID;
        this.EmpName= EmpName;
        this.Bsalary= Bsalary;
        this.TotalOT=TotalOT;
        this.RatePerHr=RatePerHr;
        this.TotalAmount=TotalAmount;
    }

    public Allowances(int SalaryID,int EmpID,String EmpName,double Bsalary, int TotalOT,double RatePerHr,double TotalAmount){
        this.SalaryID=SalaryID;
        this.EmpID= EmpID;
        this.EmpName= EmpName;
        this.Bsalary= Bsalary;
        this.TotalOT=TotalOT;
        this.RatePerHr=RatePerHr;
        this.TotalAmount=TotalAmount;
    }
    public int getSalaryID(){
        return SalaryID;
    }
    public int getEmpID(){
        return EmpID;
    }
    public String getEmpName(){
        return EmpName;
    }
    public double getBsalary(){
        return Bsalary;
    }
    public  int getTotalOT(){
        return TotalOT;
    }
    public double getRatePerHr(){
        return RatePerHr;
    }
    public double getTotalAmount(){
        return TotalAmount;
    }
}
