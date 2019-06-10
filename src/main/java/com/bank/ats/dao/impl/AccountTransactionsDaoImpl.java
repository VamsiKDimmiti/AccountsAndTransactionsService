package com.bank.ats.dao.impl;

import com.bank.ats.constants.AccountsAndTransactionsConstants;
import com.bank.ats.dao.AccountTransactionsDao;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.entity.Accounts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AccountTransactionsDaoImpl implements AccountTransactionsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccountTransactions> getAllTransactions(int accntNum){

        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<AccountTransactions> cq = cb.createQuery(AccountTransactions.class);
        final Root<AccountTransactions> accntrans = cq.from(AccountTransactions.class);
        cq.select(accntrans);
        cq.where(
            cb.equal(accntrans.get(AccountsAndTransactionsConstants.ACCOUNT_NUMBER),accntNum)
        );
        return entityManager.createQuery(cq).getResultList();
    }
}
