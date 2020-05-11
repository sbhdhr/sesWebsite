package ses.proj.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ses.proj.entity.IncomingAlert;

@Repository
public interface IncomingAlertRepo extends CrudRepository<IncomingAlert, Long>{
	
	@Query(value = "select max(id) from incoming_alert;", nativeQuery = true)
	Object getMaxIncAlertId();
}
