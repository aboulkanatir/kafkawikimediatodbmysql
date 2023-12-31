package springboot.producer.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private WikimediaChangesProducer wikimediaChangesProducer; 
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		wikimediaChangesProducer.sendMessage();
		
	}

}
