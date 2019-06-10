package com.bank.ats.service;


import com.bank.ats.dao.AccountDao;
import com.bank.ats.dao.AccountTransactionsDao;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;
import com.bank.ats.service.impl.AccountsAndTransactionsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountsAndTransactionServiceImplTest {

    @InjectMocks
    private AccountsAndTransactionsServiceImpl mockServiceImpl;

    @Mock
    AccountDao accntDao;

    @Mock
    AccountTransactionsDao accntTranDao;

    @Mock
    ATSException mockExcpetion;

    private static Accounts acct;
    private static AccountTransactions acctTran;

    @Before
    public void setup(){
        acct = new Accounts();
        acct.setAccountNumber(1);
        acct.setAccountName("John");
        acct.setAccountType("Current");
        acct.setAvailableBalance(BigDecimal.valueOf(2000.56));
        acct.setCurrency("AUD");
        acctTran = new AccountTransactions();
        acctTran.setAccountNumber(1);
        acctTran.setTransactionNarrative("Salary1");
    }

    @Test()
    public void testPositivegetAllAccounts() throws Exception{
        List<Accounts> accnts = new ArrayList<Accounts>();
        accnts.add(acct);
        Mockito.when(accntDao.getAccounts()).thenReturn(accnts);
        Assert.assertEquals("Current", mockServiceImpl.getAllAccounts().get(0).getAccountType());
    }

    @Test(expected = ATSException.class)
    public void testNegativegetAllAccounts() throws Exception{
        List<Accounts> accnts = new ArrayList<Accounts>();
        accnts.add(acct);
        Mockito.when(accntDao.getAccounts()).thenThrow(mockExcpetion);
        mockServiceImpl.getAllAccounts();
    }

    @Test()
    public void testPositivegetAccountTransaactions() throws Exception{
        List<AccountTransactions> accnts = new ArrayList<AccountTransactions>();
        accnts.add(acctTran);
        Mockito.when(accntTranDao.getAllTransactions(1)).thenReturn(accnts);
        Assert.assertEquals("Salary1", mockServiceImpl.getAllTransactions(1).get(0).getTransactionNarrative());
    }

    @Test(expected = ATSException.class)
    public void testNegativegetAccountTransaactions() throws Exception{
        List<AccountTransactions> accnts = new ArrayList<AccountTransactions>();
        accnts.add(acctTran);
        Mockito.when(accntTranDao.getAllTransactions(1)).thenThrow(mockExcpetion);
        mockServiceImpl.getAllTransactions(1);
    }
}
