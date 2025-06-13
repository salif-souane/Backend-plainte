package Salif.s.sa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
   @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    public  Client(){
    }

    public Client(int id, String email, String name, String password) {
        this.id = id;
        this.name = email;
        this.email = name;
        this.password = password;

    }

   

    public int getClient(){
        return this.id;
    }

    public void setClient(int id){
        this.id = id;
    }

   

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return this.name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public String getPassword(){
        return this.password ;
    }

    public void setPassword(String password){
        this.password = password ;
    }
}
