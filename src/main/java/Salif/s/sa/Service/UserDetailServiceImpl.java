
package Salif.s.sa.Service;

import Salif.s.sa.Entity.User;
import Salif.s.sa.Repository.UserRepository;
import Salif.s.sa.Service.UserDetailServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    UserRepository userRepository;

   

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<User> user = userRepository.findByUsername(username);

       UserBuilder builder = null;
       if(user.isPresent()){
        User currentUser = user.get();
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(currentUser.getPassword());
        builder.roles(currentUser.getRole());
       }else{
        throw new UsernameNotFoundException("User not found");
       }
       return builder.build();
    }
}
