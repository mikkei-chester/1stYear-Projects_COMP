package Objects;



import java.math.BigDecimal;

public class userWallet {

    private long       id;
    private BigDecimal regularWallet;
    private BigDecimal savingsWallet;

    public userWallet() {}

    public userWallet(long id, BigDecimal regularWallet, BigDecimal savingsWallet) {
        this.id            = id;
        this.regularWallet = regularWallet;
        this.savingsWallet = savingsWallet;
    }

    public long       getId()            { return id; }
    public BigDecimal getRegularWallet() { return regularWallet; }
    public BigDecimal getSavingsWallet() { return savingsWallet; }

    public void setId(long id)                         { this.id = id; }
    public void setRegularWallet(BigDecimal regularWallet) { this.regularWallet = regularWallet; }
    public void setSavingsWallet(BigDecimal savingsWallet) { this.savingsWallet = savingsWallet; }
}