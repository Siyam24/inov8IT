package Models;
import java.time.LocalDate;
import java.util.Date;



public class CashTransaction {

    private int CTID;
    private String CTName;
    private int CTAmount;
    private String CTType;
    private LocalDate CTDate;
    private String CTRole;

    public int getCTID() {
        return CTID;
    }

    public void setCTID(int CTID) {
        this.CTID = CTID;
    }

    public String getCTName() {
        return CTName;
    }

    public void setCTName(String CTName) {
        this.CTName = CTName;
    }


    public int getCTAmount() {
        return CTAmount;
    }

    public void setCTAmount(int CTAmount) {
        this.CTAmount = CTAmount;
    }

    public String getCTType() {
        return CTType;
    }

    public void setCTType(String CTType) {
        this.CTType = CTType;
    }

    public LocalDate getCTDate() {
        return CTDate;
    }

    public void setCTDate(LocalDate CTDate) {
        this.CTDate = CTDate;
    }

    public String getCTRole() {
        return CTRole;
    }

    public void setCTRole(String CTRole) {
        this.CTRole = CTRole;
    }
}
