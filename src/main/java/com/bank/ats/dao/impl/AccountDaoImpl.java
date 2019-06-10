package com.bank.ats.dao.impl;

import com.bank.ats.dao.AccountDao;
import com.bank.ats.entity.Accounts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Accounts> getAccounts(){
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Accounts> cq = cb.createQuery(Accounts.class);
        final Root<Accounts> accnts = cq.from(Accounts.class);
        cq.select(accnts);
        return entityManager.createQuery(cq).getResultList();
    }
}
