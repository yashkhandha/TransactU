package fit5042.application.web;

import fit5042.application.repositories.UserRepository;
import fit5042.application.repository.entities.Address;
import fit5042.application.repository.entities.BankWorker;
import fit5042.application.repository.entities.PersonAccount;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author yashkhandha
 */
@Named(value = "userController")
@ApplicationScoped
public class UserController {
    
    @EJB
    private UserRepository userRepository;
    private PersonAccount person = new PersonAccount();
    private Address address = new Address();
    private List<PersonAccount> filteredUsers;
    private BankWorker worker = new BankWorker();

    
    public UserController() {    
    }
    
    public List<PersonAccount> getAllUsers(){
        return this.userRepository.getAllUsers();
    }
    
    public List<BankWorker> getAllBankUsers(){
        return this.userRepository.getAllBankUsers();
    }
    
    public List<String> getAllNames(){
        return this.userRepository.getUserName();
    }
    
    public List<Integer> getAllIds(){
        return this.userRepository.getUserIds();
    }
    
    public String add(){
        this.person.setUserAddress(address);
        this.userRepository.addUser(this.person);
        person = new PersonAccount();
        return "/user/viewusers";
    }
    
    public String addView(){
        this.person = new PersonAccount();
        this.address= new Address();
        return "/user/adduser";
    }
    
    public String fetchUser(PersonAccount person){
        this.person = person;
        return "/user/userdetail";
    }
    
     public void delete(PersonAccount person) throws Exception{
        this.userRepository.removeUser(person.getUserId());
        this.getAllUsers();
    }
    
    public String editUser(PersonAccount person){
        this.person = person;
        return "/user/edituser";
    }
    
    public String edit(){
        this.userRepository.editUser(this.person);
        return "/user/viewusers";
    } 
     
    
    public PersonAccount getPerson() {
        return person;
    }

    public void setPerson(PersonAccount person) {
        this.person = person;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<PersonAccount> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<PersonAccount> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

     public BankWorker getWorker() {
        return worker;
    }

    public void setWorker(BankWorker worker) {
        this.worker = worker;
    }

}
