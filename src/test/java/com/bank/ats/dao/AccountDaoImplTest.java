package com.bank.ats.dao;

        import com.bank.ats.dao.impl.AccountDaoImpl;
        import com.bank.ats.entity.Accounts;
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
        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountDaoImplTest {

    @Mock
    private static Logger log = LoggerFactory.getLogger(AccountDaoImplTest.class);

    @Mock
    private EntityManager mockEmanager;

    @InjectMocks
    AccountDaoImpl mockAccntDao;

    @Mock
    private CriteriaBuilder builder;

    @Mock
    private TypedQuery<Accounts> typedQuery;

    @Mock
    private CriteriaQuery<Accounts> criteria;

    @Mock
    private Root<Accounts> root;

    @Mock
    DataException mockDataException;

    @Mock
    DataAccessException mockDAException;

    private static Accounts acct;


    @BeforeClass
    public static void setup(){
        acct = new Accounts();
        acct.setAccountNumber(1);
        acct.setAccountName("John");
        acct.setAccountType("Current");
        acct.setAvailableBalance(BigDecimal.valueOf(2000.56));
        acct.setCurrency("AUD");
    }

    @Test
    public void testPositiveGetAccounts() throws Exception{
        List<Accounts> acctList = new ArrayList<Accounts>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(Accounts.class)).thenReturn(criteria);
        Mockito.when(criteria.from(Accounts.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenReturn(acctList);
        mockAccntDao.getAccounts();
        Assert.assertEquals("John",mockAccntDao.getAccounts().get(0).getAccountName());
    }

    @Test()
    public void testNegGetAccounts() throws Exception{
        List<Accounts> acctList = new ArrayList<Accounts>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(Accounts.class)).thenReturn(criteria);
        Mockito.when(criteria.from(Accounts.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(new NoResultException());
        mockAccntDao.getAccounts();
        Assert.assertEquals(null, mockAccntDao.getAccounts());
    }

    @Test(expected = ATSException.class)
    public void testNeg1GetAccounts() throws Exception{
        List<Accounts> acctList = new ArrayList<Accounts>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(Accounts.class)).thenReturn(criteria);
        Mockito.when(criteria.from(Accounts.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(mockDAException);
        mockAccntDao.getAccounts();

    }

    @Test(expected = ATSException.class)
    public void testNeg2GetAccounts() throws Exception{
        List<Accounts> acctList = new ArrayList<Accounts>();
        acctList.add(acct);
        Mockito.when(mockEmanager.getCriteriaBuilder()).thenReturn(builder);
        Mockito.when(builder.createQuery(Accounts.class)).thenReturn(criteria);
        Mockito.when(criteria.from(Accounts.class)).thenReturn(root);
        Mockito.when(criteria.select(root)).thenReturn(criteria);
        Mockito.when(mockEmanager.createQuery(criteria)).thenReturn(typedQuery);
        Mockito.when(mockEmanager.createQuery(criteria).getResultList()).thenThrow(mockDataException);
        mockAccntDao.getAccounts();

    }

}
