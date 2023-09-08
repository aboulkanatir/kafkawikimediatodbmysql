package springboot.consumer.wikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.consumer.wikimedia.entity.WikimediaData;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
