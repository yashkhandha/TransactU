/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repositories;

import fit5042.application.repository.entities.BankWorker;
import fit5042.application.repository.entities.PersonAccount;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.Query;

/**
 * UserRepository class to handle user CRUD
 * @author yashkhandha
 */
@Remote
public interface UserRepository {
    
    /**
     * Return all the users in the repository
     * @return List of users
     */
    public List<PersonAccount> getAllUsers();
    
    //public List<BankWorker> getAllBankUsers();
    
    /**
     * Add the person object in the User repository
     * @param person the user to add
     */
    public void addUser(PersonAccount person);
    
    /**
     * Update the person details
     * @param person the instance of a user to be updated
     */
    public void editUser(PersonAccount person);
    
    /**
     * Remove a user from User Repository
     * @param userId the user Id of a person to be removed from the repository
     */
    public void removeUser(int userId);
    
    /**
     * Search for a user by user id
     * @param userId the user id of the user to search for
     * @return PersonAcount user object
     */
    public PersonAccount searchUserByUserId(int userId);
 
    public List<String> getUserName();
    
    public List<Integer> getUserIds();
    
    public PersonAccount getUserByName(String name);
    
     public List<BankWorker> getAllBankUsers();
}
