package Models;

public class GoldTransaction {
    private int GTID;
    private int Refno;
    private String Description;
    private int Amount;
    public GoldTransaction() {
    }

    public int getGTID() {
        return GTID;
    }

    public void setGTID(int GTID) {
        this.GTID = GTID;
    }

    public int getRefno() {
        return Refno;
    }

    public void setRefno(int refno) {
        Refno = refno;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
