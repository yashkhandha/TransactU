/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication.gui;

import fit5042.application.repositories.UserRepository;
import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author yashkhandha
 */
public class TransactionGUIImpl extends JFrame implements TransactionGUI{

    private static UserRepository userR;
    
    private static final String[] TABLE_COLUMNS = {"ID", "Address", "No. of Bedrooms", "Size", "Price", "Contact Person"};
    
    private final JButton closeButton;
    private final JButton addButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    
    private final JLabel transactionIdLabel;
    private final JLabel transactionDescriptionLabel;
    private final JLabel transactionNameLabel;
    //private final JLabel transactionTypeLabel;
    private final JLabel transactionTypeLabel1;
    private final JLabel userLabel;
    
    private final JTextField transactionIdTextField;
    private final JTextField transactionDescriptionTextField;
    private final JTextField transactionNameTextField;
    //private final JTextField transactionTypeTextField;
    
    //private final JTable transactionTable;
    private final JComboBox userComboBox;
    private final JComboBox typeComboBox;
    
    BankTransaction transaction;
    
    public TransactionGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener) {
    
    super("Transaction Repository");
    
        this.closeButton = new JButton("Close");
        this.addButton = new JButton("Add");
        
        Container container = this.getContentPane();
        
        this.transactionIdLabel = new JLabel("Transaction ID :");
        this.transactionDescriptionLabel = new JLabel("Transaction Description :");
        this.transactionNameLabel = new JLabel("Transaction Name :");
        //this.transactionTypeLabel = new JLabel("Transaction  Type :");
        this.transactionTypeLabel1 = new JLabel("Transaction  Type :");
        this.userLabel = new JLabel("User :");
        
        this.transactionIdTextField = new JTextField();
        this.transactionDescriptionTextField = new JTextField();
        this.transactionNameTextField = new JTextField(); 
        //this.transactionTypeTextField = new JTextField();
        
        //this.transactionTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        //this.transactionTable.getSelectionModel().addListSelectionListener(listSelectionListener);       
        //this.transactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        //TableColumnModel propertyTableColumnModel = this.transactionTable.getColumnModel();
        //propertyTableColumnModel.getColumn(0).setPreferredWidth(50);
        //propertyTableColumnModel.getColumn(1).setPreferredWidth(300);
        //propertyTableColumnModel.getColumn(2).setPreferredWidth(100);
        //propertyTableColumnModel.getColumn(3).setPreferredWidth(100);
        //propertyTableColumnModel.getColumn(4).setPreferredWidth(100);
        //propertyTableColumnModel.getColumn(5).setPreferredWidth(100);
        
        this.userComboBox = new JComboBox();
        this.typeComboBox = new JComboBox(new Object[]{"Credit","Debit"});
        
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(11,2));
        this.buttonPanel.setLayout(new GridLayout(1,4));
        
        this.closeButton.addActionListener(actionListener);
        this.addButton.addActionListener(actionListener);
        
        this.inputPanel.add(this.transactionIdLabel);
        this.inputPanel.add(this.transactionIdTextField);
        
        this.inputPanel.add(this.transactionDescriptionLabel);
        this.inputPanel.add(transactionDescriptionTextField);
        
        this.inputPanel.add(this.transactionNameLabel);
        this.inputPanel.add(this.transactionNameTextField);
        
        //this.inputPanel.add(this.transactionTypeLabel);
        //this.inputPanel.add(this.transactionTypeTextField);
        
        this.inputPanel.add(this.transactionTypeLabel1);
        this.inputPanel.add(this.typeComboBox);
        
        this.inputPanel.add(this.userLabel);
        this.inputPanel.add(this.userComboBox);

        
        
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.closeButton);

        container.add(inputPanel,BorderLayout.NORTH);
        
        //container.add(new JScrollPane(this.transactionTable), BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);
       
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(750, 570);       
        this.setVisible(true);
       
    }
    
    @Override
    public void displayUsers(List<PersonAccount> person) {
        
        this.userComboBox.removeAllItems();
        
        this.userComboBox.addItem("");
        
        for (PersonAccount contactPerson : person) {
            this.userComboBox.addItem(contactPerson);
        }    
    }
    
    @Override
    public PersonAccount getSelectedUser() {
        if (this.userComboBox.getItemCount() > 0 && this.userComboBox.getSelectedIndex() > 0) {
            return (PersonAccount)this.userComboBox.getSelectedItem();
        } else {
            return null;
        }
    }
    
    @Override
    public int getTransactionId() {
        String id = this.transactionIdTextField.getText();
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);
    }

    @Override
    public BankTransaction getTransactionDetails()
    {
        
        //int id = Integer.parseInt(transactionIdTextField.getText());
        //String name = this.transactionNameTextField.getText();
        //String type = this.transactionTypeTextField.getText();
        //String description = this.transactionDescriptionTextField.getText();
        //String user = (String) this.userComboBox.getSelectedItem();
       // PersonAccount person = userR.getUserByName(user);
        
        //return new BankTransaction(id,name,type,description,person);
        return new BankTransaction(Integer.parseInt(transactionIdTextField.getText()), 
                            this.transactionNameTextField.getText(),
                            (String)this.typeComboBox.getSelectedItem(),
                            this.transactionDescriptionTextField.getText(),
                            (PersonAccount)this.userComboBox.getSelectedItem() 
                            );		
    }
    
    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    
    @Override
    public void clearInput() {
        this.clearTextFields();
        this.clearComboBoxes();
    }

    @Override
    public void clearTextFields() {
        this.transactionIdTextField.setText("");
        this.transactionDescriptionTextField.setText("");
        this.transactionNameTextField.setText("");
        //this.transactionTypeTextField.setText("");     
    }
    
    @Override
    public void clearComboBoxes() {
        if (this.userComboBox.getItemCount() > 0) {
            this.userComboBox.setSelectedIndex(0);
        } 
    }

    @Override
    public JButton getAddButton() {
        return addButton;
    }
    
    @Override
    public JButton getCloseButton() {
        return closeButton;
    } 
    
}
