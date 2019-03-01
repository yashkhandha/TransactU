/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Messom
 */
@Path("greeting")
public class helloWorld {
    @EJB
    private NameStorageBean nameStorage;
    TransactionRepository repository = new TransactionRepository();
    
    @Context
    private UriInfo context;

    public helloWorld() {
    }
 
    @GET
    @Produces("text/html")
    public String getTransactionTypes() {
        //TODO return proper representation object
        return repository.getTransactionTypes();
        //throw new UnsupportedOperationException();
    }
   

}
