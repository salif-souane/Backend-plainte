package Salif.s.sa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Salif.s.sa.Entity.Client;
import Salif.s.sa.Service.ClientService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "client")
public class CLientController {

    
    @Autowired
    private ClientService clientService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void creer(@RequestBody Client Client){
        this.clientService.creer(Client);
    }


    @GetMapping()
    public List<Client> rechercher(){
        return this.clientService.rechercher();
    }

    @GetMapping(path = "{id}")
    public Client lire(@PathVariable int id){
        return this.clientService.lire(id);
    } 

    
    @PutMapping(path = "{id}")
    public void modifier(@PathVariable int id, @RequestBody Client Client){
        this.clientService.modifier(Client);
    }

    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.clientService.supprimer(id);
    }
}
