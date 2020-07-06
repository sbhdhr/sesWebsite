package ses.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ses.proj.entity.IncomingAlert;

@Repository
public interface IncomingAlertRepo extends CrudRepository<IncomingAlert, Long>{
	
	@Query(value = "select max(id) from incoming_alert;", nativeQuery = true)
	Object getMaxIncAlertId();
	
	@Query(value = "select * from incoming_alert where event_id=?1", nativeQuery = true)
	List<IncomingAlert> getAllAlertsForEventId(Long eventId);
	
	@Query(value = "select * from incoming_alert order by id", nativeQuery = true)
	List<IncomingAlert> getAllAlerts();
}
