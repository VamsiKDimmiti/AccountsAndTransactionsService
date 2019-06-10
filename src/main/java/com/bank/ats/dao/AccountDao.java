package com.bank.ats.dao;

import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;

import java.util.List;

public interface AccountDao {
    public List<Accounts> getAccounts() throws ATSException;
}
