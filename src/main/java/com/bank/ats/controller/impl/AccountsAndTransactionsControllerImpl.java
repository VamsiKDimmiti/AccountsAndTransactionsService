package com.bank.ats.controller.impl;

import com.bank.ats.controller.AccountsAndTransactionsController;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;
import com.bank.ats.service.AccountsAndTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsAndTransactionsControllerImpl implements AccountsAndTransactionsController {

    @Autowired
    protected AccountsAndTransactionsService acctTransService;

    @RequestMapping("/accountsList")
    public List<Accounts> getAccountsList() throws ATSException {
        return acctTransService.getAllAccounts();
    }

    @RequestMapping("/account/transactionList")
    public List<AccountTransactions> getAccountTransactionList (
       @RequestParam(value = "accountNumber") int accountNum) throws ATSException{
       return  acctTransService.getAllTransactions(accountNum);
    }
}
