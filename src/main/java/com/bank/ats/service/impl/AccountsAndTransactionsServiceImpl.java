package com.bank.ats.service.impl;

import com.bank.ats.dao.AccountDao;
import com.bank.ats.dao.AccountTransactionsDao;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;
import com.bank.ats.service.AccountsAndTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsAndTransactionsServiceImpl implements AccountsAndTransactionsService {

    @Autowired
    protected AccountTransactionsDao accntTransDao;

    @Autowired
    protected AccountDao accntsDao;

    @Override
    public List<Accounts> getAllAccounts()throws ATSException {
        try {
            return accntsDao.getAccounts();
        }catch(ATSException e){
            throw new ATSException("Error in retrieving the data from Accounts: "+e.getMessage());
        }
    }

    @Override
    public List<AccountTransactions> getAllTransactions(int accntNum)throws ATSException{
        try {
            return accntTransDao.getAllTransactions(accntNum);
        }catch(ATSException e){
            throw new ATSException("Error in retrieving the data from Accounts Transaction: "+e.getMessage());
        }
    }
}
