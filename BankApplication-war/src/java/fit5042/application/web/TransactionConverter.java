/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.web;

import fit5042.application.repositories.TransactionRepository;
import fit5042.application.repositories.UserRepository;
import fit5042.application.repository.entities.BankTransaction;
import fit5042.application.repository.entities.PersonAccount;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author yashkhandha
 */
@FacesConverter("convertertest")
    public class TransactionConverter implements Converter {

    @EJB(name = "UserRepository")
    private UserRepository userRepository;
    
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value){
            if (value == null || value.length() == 0) {
                return null;
            }
            return userRepository.searchUserByUserId(getKey(value));
        }

        int getKey(String value) {
            int key;
            key = Integer.parseInt(value);
            return key;
        }

        String getStringKey(int value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PersonAccount) {
                
                return String.valueOf(((PersonAccount) object).getUserId()) ;
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BankTransaction.class.getName()});
                return null;
            }
        }

    }
