/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplicationapp;

import bankapplication.gui.TransactionGUI;
import bankapplication.gui.TransactionGUIImpl;
import fit5042.application.repositories.TransactionRepository;
import fit5042.application.repositories.UserRepository;
import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author yashkhandha
 */
public class TransactionManager implements ActionListener, ListSelectionListener {

    @EJB
    private static TransactionRepository transactionRepository;
    
    @EJB
    private static UserRepository userRepository;
    
    private String name;
    private TransactionGUI gui;
    
    public TransactionManager(String name) {
        this.name = name;
    }
    
    public void initView() {
        this.gui = new TransactionGUIImpl(this, this);
        this.displayAllUsers();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == gui.getAddButton()) {
            this.addTransaction();
        }  else {
            System.exit(0);
        }
    }
    
    private void displayAllUsers() {
        try {
            List<PersonAccount> persons = userRepository.getAllUsers();
            
            if (persons != null) {
                this.gui.displayUsers(persons);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve contact people: " + ex.getMessage());
        }
    }

    private void addTransaction() {
        BankTransaction transaction = gui.getTransactionDetails();
       // userRepository.getUserByName()
        try {
            transactionRepository.addTransaction(transaction);
            this.gui.clearInput();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to add transaction: " + ex.getMessage());
        } finally {
            this.gui.clearInput();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            final TransactionManager manager = new TransactionManager("Transaction Repository");
            manager.initView();
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
   
    
}
