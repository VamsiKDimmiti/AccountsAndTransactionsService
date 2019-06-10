package com.bank.ats.controller;


import com.bank.ats.controller.impl.AccountsAndTransactionsControllerImpl;
import com.bank.ats.dao.AccountDao;
import com.bank.ats.dao.AccountTransactionsDao;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;
import com.bank.ats.service.AccountsAndTransactionsService;
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
public class AccountsAndTransactionCntrollerTest {

    @InjectMocks
    private AccountsAndTransactionsControllerImpl mockcontroller;

    @Mock
    private AccountsAndTransactionsService mockService;

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
        Mockito.when(mockService.getAllAccounts()).thenReturn(accnts);
        Assert.assertEquals("Current", mockcontroller.getAccountsList().get(0).getAccountType());
    }

    @Test(expected = ATSException.class)
    public void testNegativegetAllAccounts() throws Exception{
        List<Accounts> accnts = new ArrayList<Accounts>();
        accnts.add(acct);
        Mockito.when(mockService.getAllAccounts()).thenThrow(mockExcpetion);
        mockcontroller.getAccountsList();
    }

    @Test()
    public void testPositivegetAccountTransaactions() throws Exception{
        List<AccountTransactions> accnts = new ArrayList<AccountTransactions>();
        accnts.add(acctTran);
        Mockito.when(mockService.getAllTransactions(1)).thenReturn(accnts);
        Assert.assertEquals("Salary1", mockcontroller.getAccountTransactionList(1).get(0).getTransactionNarrative());
    }

    @Test(expected = ATSException.class)
    public void testNegativegetAccountTransaactions() throws Exception{
        List<AccountTransactions> accnts = new ArrayList<AccountTransactions>();
        accnts.add(acctTran);
        Mockito.when(mockService.getAllTransactions(1)).thenThrow(mockExcpetion);
        mockcontroller.getAccountTransactionList(1);
    }
}
