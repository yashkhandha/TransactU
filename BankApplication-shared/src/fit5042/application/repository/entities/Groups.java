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
@SequenceGenerator(name="GROUPS_SEQ",initialValue=1,allocationSize=500)
public class Groups implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPS_SEQ")
    private long id;
    private String username;
    private String groupname;
    
    public Groups(){
        
    }
    public Groups(long id, String username, String groupname) {
        this.id = id;
        this.username = username;
        this.groupname = groupname;
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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
    @Override
    public String toString() {
        return "Groups{" + "id=" + id + ", username=" + username + ", groupname=" + groupname + '}';
    }
}
