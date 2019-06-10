package com.bank.ats.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class AccountTransactions {
    @Id
    @NotNull
    private int transactionNumber;
    @NotNull
    private int accountNumber;
    private Date transactionDate;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    @NotNull
    private String debitCredit;
    private String transactionNarrative;

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(String debitCredit) {
        this.debitCredit = debitCredit;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactions that = (AccountTransactions) o;
        return transactionNumber == that.transactionNumber &&
                accountNumber == that.accountNumber &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(debitAmount, that.debitAmount) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(debitCredit, that.debitCredit) &&
                Objects.equals(transactionNarrative, that.transactionNarrative);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionNumber, accountNumber, transactionDate, debitAmount, creditAmount, debitCredit, transactionNarrative);
    }

    @Override
    public String toString() {
        return "AccountTransactions{" +
                "transactionNumber=" + transactionNumber +
                ", accountNumber=" + accountNumber +
                ", transactionDate=" + transactionDate +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", debitCredit='" + debitCredit + '\'' +
                ", transactionNarrative='" + transactionNarrative + '\'' +
                '}';
    }
}
