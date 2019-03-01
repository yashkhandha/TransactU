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
import javax.ejb.Remote;

/**
 *
 * @author yashkhandha
 */
@Remote
public interface TransactionRepository {
    
    /**
     * Add the transaction being passed as parameter into the repository
     *
     * @param transaction - the property to add
     */
    public void addTransaction(BankTransaction transaction) throws Exception;
    
    /**
     * Update a transaction in the repository
     * @param transaction the updated information regarding the transaction
     * @throws Exception 
     */
    public void editTransaction(BankTransaction transaction) throws Exception;
    
    /**
     * Remove the transaction, whose transaction number matches the one passed as a parameter, from the repository
     * @param transactionNumber the transaction number of the transaction to be removed
     */
    public void removeTransaction(int transactionNumber) throws Exception;
    
    /**
     * Return all the transactions in the repository
     * @return all transactions in the repository 
     */
    public List<BankTransaction> getAllTransactions() throws Exception; 
    
    /**
     * Search for a transaction by its transaction number
     *
     * @param transactionNumber - the transaction number of the transaction to search for
     * @return the transaction found
     */
    public BankTransaction searchTransactionByNumber(int transactionNumber) throws Exception;
    
    /**
     * Search transactions by transaction type
     * @param transactionType - the transaction type of the transaction to search for
     * @return list of all transactions from the repository based on the transaction type
     * @throws Exception 
     */
    public List<BankTransaction> searchTransactionByTransactionType(String transactionType) throws Exception;
    
    /**
     * Search transactions by transaction name
     * @param transactionName - the transaction name of the transaction to search for
     * @return list of transactions from the repository based on the transaction name
     * @throws Exception 
     */
    public List<BankTransaction> searchTransactionbyTransactionName(String transactionName) throws Exception;
    
    /**
     * Search transactions by user
     * @param user - the user  details  of the transaction to search for
     * @return list of transactions from the repository based on the user details
     * @throws Exception 
     */
    public Set<BankTransaction> searchTransactionsByUser(PersonAccount user) throws Exception;
    

    
}
