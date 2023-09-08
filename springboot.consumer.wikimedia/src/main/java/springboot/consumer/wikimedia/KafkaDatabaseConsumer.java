package springboot.consumer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import springboot.consumer.wikimedia.entity.WikimediaData;
import springboot.consumer.wikimedia.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	
	
	private WikimediaDataRepository datarepository ; 
	
	
	
	public KafkaDatabaseConsumer(WikimediaDataRepository datarepository) {
		super();
		this.datarepository = datarepository;
	}

	private static final Logger LOGGER 
	= LoggerFactory.getLogger(KafkaDatabaseConsumer.class) ; 
	
	@KafkaListener(topics = "wikimedia_recentchange",
			groupId = "myGroup")
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Event message recieved -> %s", eventMessage));
		
		WikimediaData wikimediadata= new WikimediaData();
		
		String hdhd = "dada" ; 
		wikimediadata.setWikiEventData(eventMessage);
		
		datarepository.save(wikimediadata) ; 
		
	}
}
