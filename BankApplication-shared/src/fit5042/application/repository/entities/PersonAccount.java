package fit5042.application.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;

/**
 * PersonAccount class is defined to save the details of a system user
 * @author yashkhandha
 */
@Entity
@Table(name="PERSON_ACCOUNT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@NamedQueries({
    @NamedQuery(name = PersonAccount.FIND_ALL, query = "SELECT u FROM PersonAccount u"),
    @NamedQuery(name = PersonAccount.FIND_NAME, query = "Select u.userFirstName from PersonAccount u"),
    @NamedQuery(name=PersonAccount.FIND_USER_BY_NAME,query = "Select u from PersonAccount u where u.userFirstName LIKE :userFirstName"),
    @NamedQuery(name=PersonAccount.FIND_ID, query = "Select u.userId from PersonAccount u ")
})
public class PersonAccount implements Serializable {

    public static final String FIND_ALL="PersonAccount.getAll";
    public static final String FIND_NAME="PersonAccount.getName";
    public static final String FIND_USER_BY_NAME="PersonAccount.getUser";
    public static final String FIND_ID="PersonAccount.getIds";
    //for storing user id 
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int userId;
    //for storing user last name
    @Column(name="user_last_name")
    private String userLastName;
    //for storing user first name
    @Column(name="user_first_name")
    private String userFirstName;
    //for storing user email address
    @Column(name="user_email_address")
    private String userEmailAddress;
    //for storing user dob
    @Column(name="date_of_birth")
    private String dateOfBirth;
    //for storing user type (Bank Worker/Public)
    @Column(name="user_type")
    private String userType;
    //for storing user address
    @Embedded
    private Address userAddress;
    //Defining bidirectional relational mapping
    @OneToMany(mappedBy="user")
    private Set<BankTransaction> transactions;
    //for storing user phone number
    private int userPhoneNumber;
    
    //Default constructor
    public PersonAccount() {
    }
    
    //parametrized constructor
    public PersonAccount(int userId, String userLastName, String userFirstName, String userEmailAddress, String userPassword, String userType, Address userAddress, Set<BankTransaction> transactions, int userPhoneNumber) {
        this.userId = userId;
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.userEmailAddress = userEmailAddress;
        this.dateOfBirth = userPassword;
        this.userType = userType;
        this.userAddress = userAddress;
        this.transactions =  new HashSet<>();
        this.userPhoneNumber = userPhoneNumber;
    }
    
    //Accessors and Mutators for accessing the attributes
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public Set<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    
    //to string method to display the attributes
    @Override
    public String toString() {
        return "SystemUser{" + "userId=" + userId + ", userLastName=" + userLastName + ", userFirstName=" + userFirstName + ", userEmailAddress=" + userEmailAddress + ", userPassword=" + dateOfBirth + ", userType=" + userType + ", userAddress=" + userAddress + ", transactions=" + transactions + ", userPhoneNumber=" + userPhoneNumber + '}';
    }
}
