package Salif.s.sa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Salif.s.sa.Entity.Sentiment;
import Salif.s.sa.Service.SentimentService;

@RestController
@RequestMapping(path = "sentiment")
public class SentimentController {

    @Autowired
    SentimentService sentimentService;

    @PostMapping()
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentService.creer(sentiment);
    }

    @GetMapping()
    public @ResponseBody List<Sentiment> lire(){
        return this.sentimentService.lire();
    }

    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.sentimentService.supprimer(id);
    }

    @PutMapping(path = "{id}")
    public void modifier(@RequestBody Sentiment sentiment, @PathVariable int id){
        this.sentimentService.modifier(sentiment);
    }

}
