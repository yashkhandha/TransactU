/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication.gui;

import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author yashkhandha
 */
public interface TransactionGUI {
    
    
    /**
     * Clear all the inputs in the GUI
     */
    void clearInput();

    /**
     * Clear all the text fields in the GUI
     */
    void clearTextFields();
    
    /**
     * Clear all the combo boxes in the GUI
     */
    void clearComboBoxes();
    
    /**
     * Display a message in a dialog box
     *
     * @param message - the message to display
     */
    void displayMessageInDialog(String message);
    
    
    /**
     * Return the Add Property button
     *
     * @return the attribute addButton
     */
    JButton getAddButton();

    /**
     * Return the Close Window button
     *
     * @return the attribute closeButton
     */
    JButton getCloseButton();
    
    /**
     * Return the details of the transactions to add to the repository
     *
     * @return a BankTransaction object that contains all the details
     */
    BankTransaction getTransactionDetails();
    
    /**
     * Display the details of the contact people
     *
     * @param contact people - the details of the contact people to display
     */
    void displayUsers(List<PersonAccount> person);
    
    /**
     * Return the contact person to search the repository for
     *
     * @return the contact person of a property
     */
    PersonAccount getSelectedUser();

    int getTransactionId();


}
