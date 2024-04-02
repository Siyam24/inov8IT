package org.example.goldmanagementsystem;

public class employeeData {
    private  int empId;
    private  String empName;
    private String empNIC;
    private String empContact;
    private String empEmail;
    private String empSalary;
    private String empAddress;

    public employeeData(Integer empId,String empName,String empNIC,String empContact,String empEmail,String empSalary,String empAddress){
        this.empId=empId;
        this.empName=empName;
        this.empNIC=empNIC;
        this.empContact=empContact;
        this.empEmail=empEmail;
        this.empSalary=empSalary;
        this.empAddress=empAddress;
    }

    public Integer getEmployeeID(){
        return empId;
    }
    public String getEmpName(){
        return empName;
    }
    public String getEmpNIC(){
        return empNIC;
    }
    public String getEmpContact(){
        return empContact;
    }
    public String getEmpEmail(){
        return empEmail;
    }
    public String getEmpSalary(){
        return empSalary;
    }
    public String getEmpAddress(){
        return empAddress;
    }
}
