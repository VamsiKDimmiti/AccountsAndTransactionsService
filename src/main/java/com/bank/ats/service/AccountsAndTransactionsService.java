package com.bank.ats.service;

import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;

import java.util.List;

public interface AccountsAndTransactionsService {

    public List<Accounts> getAllAccounts() throws ATSException;

    public List<AccountTransactions> getAllTransactions(int accntNum) throws ATSException;
}
