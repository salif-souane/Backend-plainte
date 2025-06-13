package Salif.s.sa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Salif.s.sa.Entity.Client;
import Salif.s.sa.Entity.Sentiment;
import Salif.s.sa.Entity.User;
import Salif.s.sa.Repository.ClientRepository;
import Salif.s.sa.Repository.SentimentRepository;
import Salif.s.sa.Repository.UserRepository;

@SpringBootApplication()
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	SentimentRepository sentimentRepository;

	@Autowired
	ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
	/** 	Client client1 = new Client(0, "salifsouane@gmail.com", "salif souane", "password3");
		Client client2 = new Client(1, "mansourmboup@gmail.com", "mansour mboup", "password4");
		clientRepository.saveAll(Arrays.asList(client1, client2));

		Sentiment sentiment1 = new Sentiment(0, "je suis pas tres satisfait des services au niveau de l'hopital regional de kolda precisement au niveau du service de securité, les gens sont fatigue", null, client1);
		Sentiment sentiment2 = new Sentiment(1, "je suis pas tres satisfait des services au niveau de l'hopital regional de kolda precisement au niveau du service de securité, les gens sont fatigue", null, client2);
		sentimentRepository.saveAll(Arrays.asList(sentiment1, sentiment2));
*/
		userRepository.save(new User("user", "passwordUser", "USER"));
		userRepository.save(new User("admin", "passwordAdmin", "ADMIN"));
	}
	
}
