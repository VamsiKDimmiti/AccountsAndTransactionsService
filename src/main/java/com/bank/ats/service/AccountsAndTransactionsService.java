package com.bank.ats.service;

import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;

import java.util.List;

public interface AccountsAndTransactionsService {

    public List<Accounts> getAllAccounts();

    public List<AccountTransactions> getAllTransactions(int accntNum);
}
