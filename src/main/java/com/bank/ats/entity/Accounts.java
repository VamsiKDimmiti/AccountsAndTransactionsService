package com.bank.ats.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Accounts {
    @Id
    @NotNull
    private int accountNumber;
    @NotNull
    private String accountName;
    @NotNull
    private String accountType;
    private Date balanceDate;
    @NotNull
    private String currency;
    private BigDecimal availableBalance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return accountNumber == accounts.accountNumber &&
                Objects.equals(accountName, accounts.accountName) &&
                Objects.equals(accountType, accounts.accountType) &&
                Objects.equals(balanceDate, accounts.balanceDate) &&
                Objects.equals(currency, accounts.currency) &&
                Objects.equals(availableBalance, accounts.availableBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountName, accountType, balanceDate, currency, availableBalance);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency='" + currency + '\'' +
                ", availableBalance=" + availableBalance +
                '}';
    }
}
