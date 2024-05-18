
package Models;


public class Allowance {
    private int empid;
    private String empname;
    private double basicsalary;
    private double totalot;
    private double rateperhour;
    private double increment;
    private double advance;
    private double deduction;

    private double totalamount;


    public Allowance( int empid, String empname, double basicsalary, double totalot, double rateperhour,double increment,double advance,double deduction, double totalamount){
        this.empid= empid;
        this.empname= empname;
        this.basicsalary= basicsalary;
        this.totalot=totalot;
        this.rateperhour=rateperhour;
        this.increment=increment;
        this.advance=advance;
        this.deduction=deduction;
        this.totalamount=totalamount;
    }
    public int getEmpid(){
        return empid;
    }
    public String getEmpname(){
        return empname;
    }
    public double getBasicsalary(){
        return basicsalary;
    }
    public  double getTotalot(){
        return totalot;
    }
    public double getRateperhour(){
        return rateperhour;
    }

    public double getAdvance() {
        return advance;
    }

    public double getDeduction() {
        return deduction;
    }

    public double getIncrement() {
        return increment;
    }

    public double getTotalamount(){
        return totalamount;
    }
}