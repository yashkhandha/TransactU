/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repository.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author yashkhandha
 */
@Entity
@DiscriminatorValue(value="Public user")
public class PublicUser extends PersonAccount {

  
    private double income;
    private String passportNumber;
    
      public PublicUser() {
    }

    
    public PublicUser(double income, String passportNumber) {
        this.income = income;
        this.passportNumber = passportNumber;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "PublicUser{" + "income=" + income + ", passportNumber=" + passportNumber + '}';
    }
    
}
