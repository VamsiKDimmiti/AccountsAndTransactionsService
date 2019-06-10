package com.bank.ats.dao;

import com.bank.ats.dao.impl.AccountTransactionsDaoImpl;
import com.bank.ats.entity.AccountTransactions;
import com.bank.ats.exception.ATSException;
import org.hibernate.exception.DataException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountTransactionDaoImplTest {

    @Mock
    private static Logger log = LoggerFactory.getLogger(AccountTransactionDaoImplTest.class);

    @Mock
    private EntityManager mockEmanager;

    @InjectMocks
    AccountTransactionsDaoImpl mockAccntDao;

    @Mock
    private CriteriaBuilder builder;

    @Mock
    private TypedQuery<AccountTransactions> typedQuery;

    @Mock
    private CriteriaQuery<AccountTransactions> criteria;

    @Mock
    private Root<AccountTransactions> root;

    @Mock
    DataException mockDataException;

    @Mock
    DataAccessException mockDAException;

    private static AccountTransactions acct;

    @BeforeClass
    public static void setup(){
        acct = new AccountTransactions();
        acct.setAccountNumber(1);
        acct.setTransactionNarrative("Salary1");
    }

    @Test
    public void testPositiveGetAccountTransactions() throws Exception{
        List<AccountTransactions> acctList = new ArrayList<AccountTransactions>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(AccountTransactions.class)).thenReturn(criteria);
        Mockito.when(criteria.from(AccountTransactions.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenReturn(acctList);
        mockAccntDao.getAllTransactions(1);
        Assert.assertEquals("Salary1",mockAccntDao.getAllTransactions(1).get(0).getTransactionNarrative());
    }

    @Test()
    public void testNegGetGetAccountTransactions() throws Exception{
        List<AccountTransactions> acctList = new ArrayList<AccountTransactions>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(AccountTransactions.class)).thenReturn(criteria);
        Mockito.when(criteria.from(AccountTransactions.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(new NoResultException());
        mockAccntDao.getAllTransactions(1);
        Assert.assertEquals(null, mockAccntDao.getAllTransactions(1));
    }

    @Test(expected = ATSException.class)
    public void testNeg1GetAccountTransactions() throws Exception{
        List<AccountTransactions> acctList = new ArrayList<AccountTransactions>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(AccountTransactions.class)).thenReturn(criteria);
        Mockito.when(criteria.from(AccountTransactions.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(mockDAException);
        mockAccntDao.getAllTransactions(1);

    }

    @Test(expected = ATSException.class)
    public void testNeg2GetAccountTransactions() throws Exception{
        List<AccountTransactions> acctList = new ArrayList<AccountTransactions>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(AccountTransactions.class)).thenReturn(criteria);
        Mockito.when(criteria.from(AccountTransactions.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(mockDataException);
        mockAccntDao.getAllTransactions(1);

    }

}
