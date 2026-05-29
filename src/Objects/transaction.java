package Objects;



import java.math.BigDecimal;
import java.sql.Timestamp;

public class transaction {

    private long      transactId;
    private Timestamp dateTime;
    private BigDecimal amount;
    private BigDecimal balance;
    private String    sender;
    private String    receiver;

    public transaction() {}
    
    public transaction(BigDecimal amount, BigDecimal balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public transaction(long transactId, Timestamp dateTime,
                       BigDecimal amount, BigDecimal balance,
                       String sender, String receiver) {
        this.transactId = transactId;
        this.dateTime   = dateTime;
        this.amount     = amount;
        this.balance    = balance;
        this.sender     = sender;
        this.receiver   = receiver;
    }

    public long      getTransactId() { return transactId; }
    public Timestamp getDateTime()   { return dateTime; }
    public BigDecimal getAmount()    { return amount; }
    public BigDecimal getBalance()   { return balance; }
    public String    getSender()     { return sender; }
    public String    getReceiver()   { return receiver; }

    public void setTransactId(long transactId)       { this.transactId = transactId; }
    public void setDateTime(Timestamp dateTime)      { this.dateTime = dateTime; }
    public void setAmount(BigDecimal amount)         { this.amount = amount; }
    public void setBalance(BigDecimal balance)       { this.balance = balance; }
    public void setSender(String sender)             { this.sender = sender; }
    public void setReceiver(String receiver)         { this.receiver = receiver; }
}