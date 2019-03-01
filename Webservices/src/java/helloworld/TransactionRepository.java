/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author yashkhandha
 */
public class TransactionRepository {
    
    List<NameStorageBean> types;
    
    public TransactionRepository() {
        
       types = new ArrayList<>();
        
       NameStorageBean type1 = new NameStorageBean();
       type1.setType("Cash Transfer");
       type1.setDesc("Wire Transfer Received");
       
       NameStorageBean type2 = new NameStorageBean();
       type2.setType("Daily Cash Deposit");
       type2.setDesc("Daily Cash Deposit");
        
       types.add(type1);
       types.add(type2);
    }
    
    //GenericEntity<List<NameStorageBean>> entity = new GenericEntity<List<NameStorageBean>>(types){};
    
    public String getTransactionTypes(){
        return "Cash Transfer,Daily Cash Deposit";
    }
    
}
