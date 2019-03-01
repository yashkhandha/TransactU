/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repositories;

import fit5042.application.repository.entities.BankWorker;
import fit5042.application.repository.entities.PersonAccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yashkhandha
 */
@Stateless
public class UserRepositoryImpl implements UserRepository {
    
    public static final String PERSISTENCE_UNIT="fit5042-BankApp";
    
    //Using container managed entity manager
    @PersistenceContext(unitName="fit5042-BankApp")
    private EntityManager entityManager;
    
    //
    @Override
    public List<PersonAccount> getAllUsers() {
       return entityManager.createNamedQuery(PersonAccount.FIND_ALL).getResultList();
    }
     @Override
    public List<BankWorker> getAllBankUsers() {
        //return entityManager.createNamedQuery(BankWorker.FIND_ALLL).getResultList();
        return entityManager.createNativeQuery(BankWorker.FIND_ALL).getResultList();
       
    }
   
    //
    @Override
    public void addUser(PersonAccount person) {
        entityManager.persist(person);
    }

    //
    @Override
    public void editUser(PersonAccount person) {
        entityManager.merge(person);
    }
    
    //
    @Override
    public void removeUser(int userId) {
        entityManager.remove(this.searchUserByUserId(userId));
    }

    //
    @Override
    public PersonAccount searchUserByUserId(int userId) {
        return entityManager.find(PersonAccount.class,userId);
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public List<String> getUserName(){
        return entityManager.createNamedQuery(PersonAccount.FIND_NAME).getResultList();
    }

    @Override
    public List<Integer> getUserIds() {
        return entityManager.createNamedQuery(PersonAccount.FIND_ID).getResultList();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public PersonAccount getUserByName(String userFirstName) {
        TypedQuery<PersonAccount> query = entityManager.createQuery("Select u from PersonAccount u where u.userFirstName LIKE :userFirstName", PersonAccount.class);
        return query.setParameter("userFirstName", userFirstName).getSingleResult();
    }
}
