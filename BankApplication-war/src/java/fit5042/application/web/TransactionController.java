package fit5042.application.web;

import fit5042.application.repositories.TransactionRepository;
import fit5042.application.repositories.UserRepository;
import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author yashkhandha
 */
@Named(value = "transactionController")
@ApplicationScoped
public class TransactionController {

    
    @EJB(name = "TransactionRepository")
    private TransactionRepository transactionRepository;
    @EJB(name = "UserRepository")
    private UserRepository userRepository;
    private BankTransaction transaction = new BankTransaction();
    private PersonAccount person = new PersonAccount();
    public static int identifier;
    public static String name;

    private List<BankTransaction> filteredtransactions;
    
    /**
     * Creates a new instance of TransactionApplication
     */
    public TransactionController() {    
    //Client client = ClientBuilder.newClient();
    //WebTarget target = client.target("http://localhost:8080/Webservices/webresources/greeting");
    //System.out.println(target.request(MediaType.TEXT_PLAIN).get(String.class));
    }    
    public List<BankTransaction> getAllTransactions() throws Exception{
       
        return this.transactionRepository.getAllTransactions();
    }
    
    public BankTransaction getTransaction() {
        return transaction;
    }
    
    public BankTransaction getTransactionByNumber(int id){
        try {
            return transactionRepository.searchTransactionByNumber(id);
        } catch (Exception ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            }
    
    public void setTransaction(BankTransaction transaction) {
        this.transaction = transaction;
    }
    
    public String add() throws Exception{
        
        PersonAccount user = userRepository.getUserByName(name);
                this.transaction.setUser(user);
        
        //PersonAccount p = userRepository.searchUserByUserId(identifier);
        //this.transaction.setUser(p);
        this.transactionRepository.addTransaction(this.transaction);
        this.transaction = new BankTransaction();
        return "/transaction/viewtransaction";
    }
    
    public String addView(){
        this.transaction = new BankTransaction();
        return "/transaction/addtransaction";
    }
    
    public void delete(BankTransaction transaction) throws Exception{
        this.transactionRepository.removeTransaction(transaction.getTransactionNumber());
        this.getAllTransactions();
    }
    
    //populate the data with passed object
    public String edit(BankTransaction transaction){
        this.transaction = transaction;
        return "/transaction/edittransaction";    
    }
    
    //complete editing
    public String edit() throws Exception{
        this.transactionRepository.editTransaction(this.transaction);
        return "/transaction/viewtransaction";    
    }
    
    public String fetchTransaction(BankTransaction transaction){
        this.transaction = transaction;
        return "/transaction/transactiondetail";
    }
    
    public List<BankTransaction> getFilteredtransactions() {
        return filteredtransactions;
    }

    public void setFilteredtransactions(List<BankTransaction> filteredtransactions) {
        this.filteredtransactions = filteredtransactions;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public PersonAccount getPerson() {
        return person;
    }

    public void setPerson(PersonAccount person) {
        this.person = person;
    }
    
    
}
