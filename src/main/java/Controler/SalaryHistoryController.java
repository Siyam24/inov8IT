package Controler;

import Models.SalaryHistory;
import java.sql.Date;
public class SalaryHistoryController {

    public void addSalaryHistory(int empID, double increasedAmount, Date date) {
        // Create a SalaryHistory object with the provided data
        SalaryHistory salaryHistory = new SalaryHistory(empID, increasedAmount, date);

        // Insert the salary history into the database using the model class method
        salaryHistory.insertSalaryHistory();
    }
}
