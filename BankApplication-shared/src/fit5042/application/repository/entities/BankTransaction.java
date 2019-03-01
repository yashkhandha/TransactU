package fit5042.application.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * BankTransaction class to keep record of the banking transactions
 * @author yashkhandha
 */
@Entity
@Table(name="BANK_TRANSACTION")
@NamedQueries({
    @NamedQuery(name = BankTransaction.FIND_ALL, query = "SELECT t FROM BankTransaction t"),
    @NamedQuery(name = BankTransaction.FIND_BY_TRANSACTION_TYPE, query = "SELECT t FROM BankTransaction t where t.transactionType LIKE :transactionType"),
    @NamedQuery(name = BankTransaction.FIND_BY_TRANSACTION_NAME, query = "SELECT t FROM BankTransaction t where t.transactionName LIKE :transactionName")
})
public class BankTransaction implements Serializable {

    public static final String FIND_ALL="BankTransaction.getAll";
    public static final String FIND_BY_TRANSACTION_TYPE="BankTransaction.getByType";
    public static final String FIND_BY_TRANSACTION_NAME="BankTransaction.getByName";
    //for storing unique transaction number
    @Id
    @GeneratedValue
    @Column(name="transaction_number")
    private int transactionNumber;
    //for storing transaction name
    @Column(name="transaction_name")
    @NotNull(message="You must enter transaction name! Bean Validated")
    private String transactionName;
    //for storing transaction type
    @Column(name="transaction_type")
    private String transactionType;
    //for storing transaction description
    @Column(name="transaction_description")
    @NotNull(message="You must enter transaction description! Bean Validated")
    private String transactionDescription;
    //Defining bidirectional relational mapping
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_transaction")
    private PersonAccount user;
    
    //default constructor
    public BankTransaction() {
    }
    
    //parametrized constructor
    public BankTransaction(int transactionNumber, String transactionName, String transactionType, String transactionDescription, PersonAccount user) {
        this.transactionNumber = transactionNumber;
        this.transactionName = transactionName;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.user = user;
    }
    
    //accessors and mutataors for accessing the attributes
    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
    
    public PersonAccount getUser() {
        return user;
    }

    public void setUser(PersonAccount user) {
        this.user = user;
    }

    //to string method to display  the attributes
    @Override
    public String toString() {
        return "BankTransaction{" + "transactionNumber=" + transactionNumber + ", transactionName=" + transactionName + ", transactionType=" + transactionType + ", transactionDescription=" + transactionDescription + '}';
    }
     
}
