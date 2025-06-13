package Salif.s.sa.Repository;

import java.util.Optional;

import org.springframework.boot.env.ConfigTreePropertySource.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Salif.s.sa.Entity.User;

public interface UserRepository extends JpaRepository<User, Long >  {
    Optional <User> findByUsername(String username);  
 
}
