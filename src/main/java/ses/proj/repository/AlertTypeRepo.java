package ses.proj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ses.proj.entity.AlertType;

@Repository
public interface AlertTypeRepo extends CrudRepository<AlertType, Long>{

}
