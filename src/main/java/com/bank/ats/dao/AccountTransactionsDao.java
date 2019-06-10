package com.bank.ats.dao;

import com.bank.ats.entity.AccountTransactions;

import java.util.List;

public interface AccountTransactionsDao {
    public List<AccountTransactions> getAllTransactions(final int accntNum);
}
