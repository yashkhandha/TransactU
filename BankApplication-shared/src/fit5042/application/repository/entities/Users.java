/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.application.repository.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author yashkhandha
 */
@Entity
@SequenceGenerator(name="USERS_SEQ",initialValue=1,allocationSize=500)
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_SEQ")
    private long id;
    private String username;
    private String password;

    public Users()
    {
    }
    
    public Users(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

    
}
