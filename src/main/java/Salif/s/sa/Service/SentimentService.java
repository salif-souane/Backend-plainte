package Salif.s.sa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;

import Salif.s.sa.Entity.Client;
import Salif.s.sa.Entity.Sentiment;
import Salif.s.sa.Enums.TypeSentiments;
import Salif.s.sa.Repository.ClientRepository;
import Salif.s.sa.Repository.SentimentRepository;

@Service
public class SentimentService {
    
    @Autowired
    SentimentRepository sentimentRepository;

    @Autowired
    ClientService clientService;


    public void creer(Sentiment sentiment) {
    String texte = sentiment.getTexte().toLowerCase();
    boolean typeTrouve = false;

    // Détresse Émotionnelle
    if (contientUnDeCesMots(texte, "peur", "panique", "anxiété", "stress", "cauchemar", "crise")) {
        sentiment.setType(TypeSentiments.Détresse_Émotionnelle);
        typeTrouve = true;
    }
    // Colère et Rancœur
    else if (contientUnDeCesMots(texte, "rage", "frustration", "trahison", "humiliation", "impuissance")) {
        sentiment.setType(TypeSentiments.Colère_et_Rancœur);
        typeTrouve = true;
    }
    // Honte et Culpabilité
    else if (contientUnDeCesMots(texte, "culpabilité", "honte", "salir", "dégoût de soi", "mériter")) {
        sentiment.setType(TypeSentiments.Honte_et_Culpabilité);
        typeTrouve = true;
    }
    // Isolement et Solitude
    else if (contientUnDeCesMots(texte, "seul·e", "abandonné·e", "incompris·e", "silence", "cacher")) {
        sentiment.setType(TypeSentiments.Isolement_et_Solitude);
        typeTrouve = true;
    } 
    // Dépression et Désespoir
    else if (contientUnDeCesMots(texte, "vide", "fatigue", "pleurs", "inutile", "sans espoir")) {
        sentiment.setType(TypeSentiments.Dépression_et_Désespoir);
        typeTrouve = true;
    } 
    // Traumatisme et Dissociation
    else if (contientUnDeCesMots(texte, "engourdissement", "déréalisation", "flashbacks", "mémoire bloquée")) {
        sentiment.setType(TypeSentiments.Traumatisme_et_Dissociation);
        typeTrouve = true;
    }
    // Sentiments de Perte
    else if (contientUnDeCesMots(texte, "deuil", "confiance brisée", "identité perdue", "illusion")) {
        sentiment.setType(TypeSentiments.Sentiments_de_Perte);
        typeTrouve = true;
    }
    // Vulnérabilité Physique
    else if (contientUnDeCesMots(texte, "douleur", "nausée", "insomnie", "symptômes physiques", "tremblements")) {
        sentiment.setType(TypeSentiments.Vulnérabilité_Physique);
        typeTrouve = true;
    }

    if (!typeTrouve) {
        sentiment.setType(TypeSentiments.Autres);
    }

    Client client = this.clientService.LireOuCreer(sentiment.getClient());
    sentiment.setClient(client);
    this.sentimentRepository.save(sentiment);
}

// Méthode utilitaire pour vérifier plusieurs mots
  private boolean contientUnDeCesMots(String texte, String... mots) {
    for (String mot : mots) {
        if (texte.contains(mot.toLowerCase())) {
            return true;
        }
    }
    return false;
}
    
    public List<Sentiment> lire(){
        return this.sentimentRepository.findAll();
    }

    public void supprimer(int id){
        this.sentimentRepository.deleteById(id);
    }

    public void modifier(Sentiment sentiment){
        this.sentimentRepository.save(sentiment);
    }
}
