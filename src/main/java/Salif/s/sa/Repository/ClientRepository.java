package Salif.s.sa.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import Salif.s.sa.Entity.Client;
import java.util.List;


public interface ClientRepository<Integer> extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    Client findByName(String name);
    Client findByPassword(String password);
    
}
