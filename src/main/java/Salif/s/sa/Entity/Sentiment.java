package Salif.s.sa.Entity;

import Salif.s.sa.Enums.TypeSentiments;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String texte;
    private TypeSentiments type;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Client client;

    public Sentiment(){
    }

    public Sentiment(int id, String texte, TypeSentiments type, Client client){
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId(){
        return this.id; 
    }

    public void setId(){
        this.id = id;
    }

    public String getTexte(){
        return this.texte;
    }

    public void setTexte(String texte){
        this.texte = texte;     
    }

    public TypeSentiments getType(){
        return this.type;
    }

    public void setType(TypeSentiments type){
        this.type = type;
    }

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }
    
}
