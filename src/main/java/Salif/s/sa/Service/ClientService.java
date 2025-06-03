package Salif.s.sa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Salif.s.sa.Entity.Client;
import Salif.s.sa.Repository.ClientRepository;
import Salif.s.sa.Repository.SentimentRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SentimentRepository sentimentRepository;
    
    public void creer(Client client){
        Client clientDansBDD =  this.clientRepository.findByEmail(client.getEmail());
        if(clientDansBDD == null){
         this.clientRepository.save(client);
         
    }
}

    public List<Client> rechercher(){
            return this.clientRepository.findAll();
        
    }

    
    public Client lire(int id){
       Optional<Client> optionalClient = this.clientRepository.findById(id);
       if(optionalClient.isPresent()){
        return optionalClient.get();
       }else{
        return null;
       }
    }
    
    
    public Client LireOuCreer(Client clientAcreer) {
    // Vérifier d'abord par email (le plus unique)
    Client clientExistant = this.clientRepository.findByEmail(clientAcreer.getEmail());
    
    // Si non trouvé par email, vérifier par nom
    if (clientExistant == null) {
        clientExistant = this.clientRepository.findByName(clientAcreer.getName());
    }
    
    // on verifie avec le password
    if (clientExistant == null) {
        clientExistant = this.clientRepository.findByPassword(clientAcreer.getPassword());
    }
    
    return clientExistant;
}


    public void modifier(Client client){
        this.clientRepository.save(client);
    }

    public void supprimer(int id){
        this.clientRepository.deleteById(id);
    }
}
