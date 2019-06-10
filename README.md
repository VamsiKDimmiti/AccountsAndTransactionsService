# AccountsAndTransactionsService
Rest Service to derive all the available accounts and transaction list of an Account

This Restful webservice provide two rest end points
1. A rest endpoint to view the list of accounts available
Rest URL : http://localhost:8083//accountsList
2. A rest endpoint to view the list of transactions for the selected account
Rest URL :  http://localhost:8083/account/transactionList

To test this service, it doesn't need any db setup as it is using H2 Embedded DB with 2 entities - ACCOUNTS and ACCOUNT_TRANSACTIONS.
The data will be loaded on start of the application.
If we want to add more data, we can do that 2 ways
Scenario1: Give the insert scripts with values for the respective entities in the file - src/main/resources/data.sql and then run the application

Scenario2: Start the application and open the H2 DB console using http://localhost:8083/h2-console/l where we can insert more data.

How to Execute:

Run this Service as a Spring Boot Application with maven build. Once the application is up and running, open a SOAPUI or POSTMAN.

To get the List of Accounts:
Use the URL - http://localhost:8083//accountsList to send the Get Request which will retrieve all the available list of Accounts

To get the List of T to transactions for an Account:
Use the URL - http://localhost:8083/account/transactionList to send the Get Request with Key as "accountNumber" and the value as one of the available account number in the above list.

In case there is no data, it will return null otherwise will throw exception.



