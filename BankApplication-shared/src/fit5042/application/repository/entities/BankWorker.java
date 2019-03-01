/*l
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repository.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author yashkhandha
 */
@Entity
@DiscriminatorValue(value="Bank worker")
@NamedQueries({
    @NamedQuery(name = BankWorker.FIND_ALLL, query = "SELECT b FROM BankWorker b")})
public class BankWorker extends PersonAccount{

    private String qualification;
    private double salary;
    private String jobTitle;
   
    public static final String FIND_ALLL="BankWorker.getAll";
    
     public BankWorker() {
         super();
       
    }
    
    public BankWorker(String qualification, double salary, String jobTitle) {
        this.qualification = qualification;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "BankWorker{" + "qualification=" + qualification + ", salary=" + salary + ", jobTitle=" + jobTitle + '}';
    }
}
