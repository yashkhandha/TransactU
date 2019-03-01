/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repositories;

import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yashkhandha
 */
@Stateless
public class TransactionRepositoryImpl implements TransactionRepository {

    public static final String PERSISTENCE_UNIT="fit5042-BankApp";
    
    public TransactionRepositoryImpl() {
        
    }
    
    //Using container managed entity manager
    @PersistenceContext(unitName="fit5042-BankApp")
    private EntityManager entityManager;
    
    //
    @Override
    public void addTransaction(BankTransaction transaction) throws Exception {
        entityManager.persist(transaction);
    }

    //
    @Override
    public void editTransaction(BankTransaction transaction) throws Exception {
        entityManager.merge(transaction);
    }

    //
    @Override
    public void removeTransaction(int transactionNumber) throws Exception {
        entityManager.remove(this.searchTransactionByNumber(transactionNumber));
    }

    //
    @Override
    public List<BankTransaction> getAllTransactions() throws Exception {
        return this.entityManager.createNamedQuery(BankTransaction.FIND_ALL).getResultList();
    }

    //
    @Override
    public BankTransaction searchTransactionByNumber(int transactionNumber) throws Exception {
        return entityManager.find(BankTransaction.class, transactionNumber); 
    }

    //
    @Override
    public List<BankTransaction> searchTransactionByTransactionType(String transactionType) throws Exception {
        return entityManager.createNamedQuery(BankTransaction.FIND_BY_TRANSACTION_TYPE).getResultList();
    }

    //
    @Override
    public List<BankTransaction> searchTransactionbyTransactionName(String transactionName) throws Exception {
        return entityManager.createNamedQuery(BankTransaction.FIND_BY_TRANSACTION_NAME).getResultList();
    }

    //
    @Override
    public Set<BankTransaction> searchTransactionsByUser(PersonAccount user) throws Exception {
        user = entityManager.find(PersonAccount.class,user.getUserId());
        user.getTransactions().size();
        entityManager.refresh(user);
        return user.getTransactions();
    }

}
