package zcController;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Emperor Brains
 */
@Data
@AllArgsConstructor
public class zcTransaction {

    private final int id;
    private final int zcACID;
    private final int zcACNumber;
    private final double Amount;
    private final double rate;
    private final double totalCredit;
    private final String zcACtype;
    private final String zcDay;
    private final String zcMonth;
    private final String zcYear;
    private final String timestamp;
    
    public zcTransaction(int id, int zcACID, int zcACNumber, double Amount, String zcACtype, String zcDay, String zcMonth, String zcYear, String timestamp,double rate, double totalCredit) {
        this.id = id;
        this.zcACID = zcACID;
        this.zcACNumber = zcACNumber;
        this.Amount = Amount;
        this.rate = rate;
        this.totalCredit = totalCredit;
        this.zcACtype = zcACtype;
        this.zcDay = zcDay;
        this.zcMonth = zcMonth;
        this.zcYear = zcYear;
        this.timestamp = timestamp;
    }
   
}
