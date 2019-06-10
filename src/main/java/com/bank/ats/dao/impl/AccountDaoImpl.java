package com.bank.ats.dao.impl;

import com.bank.ats.dao.AccountDao;
import com.bank.ats.entity.Accounts;
import com.bank.ats.exception.ATSException;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private static Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Accounts> getAccounts() throws ATSException {

        try {
            final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            final CriteriaQuery<Accounts> cq = cb.createQuery(Accounts.class);
            final Root<Accounts> accnts = cq.from(Accounts.class);
            cq.select(accnts);
            return entityManager.createQuery(cq).getResultList();
        }catch(NoResultException ne){
            return null;
        }catch(DataAccessException | DataException de){
            log.error("Error in retrieving the data from Accounts table: "+de );
            throw new ATSException("Error in retrieving the data from Accounts table: "+de.getMessage());
        }catch(Exception e){
            log.error("Error in retrieving the data from Accounts table: "+e );
            throw new ATSException("Error in retrieving the data from Accounts table: "+e.getMessage());
        }
    }
}
