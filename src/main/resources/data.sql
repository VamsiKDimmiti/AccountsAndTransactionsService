insert into accounts values(1,'Dave', 'Savings','2000.50',TO_DATE('10/06/2019', 'DD/MM/YYYY'),'AUD');
insert into accounts values(2,'Smith','Current','6000.50',TO_DATE('10/06/2019', 'DD/MM/YYYY'),'NZD');

insert into ACCOUNT_TRANSACTIONS values( 1, 1,'3000.00', null,'Credit', TO_DATE('01/06/2019', 'DD/MM/YYYY'),'Salary1');
insert into ACCOUNT_TRANSACTIONS values(2, 1, null, '1000.00','Debit', TO_DATE('02/06/2019', 'DD/MM/YYYY'),'Rent');
insert into ACCOUNT_TRANSACTIONS values(3, 1, '0.50',null, 'Credit',TO_DATE('10/06/2019', 'DD/MM/YYYY'), 'Interest');

insert into ACCOUNT_TRANSACTIONS values(4, 2, '8000.00', null, 'Credit',TO_DATE('01/06/2019', 'DD/MM/YYYY'), 'Salary1');
insert into ACCOUNT_TRANSACTIONS values(5, 2, null ,'2000.00' , 'Debit', TO_DATE('02/06/2019', 'DD/MM/YYYY'),'Rent');
insert into ACCOUNT_TRANSACTIONS values(6, 2, '0.50',null, 'Credit', TO_DATE('10/6/2019', 'DD/MM/YYYY'), 'Interest');