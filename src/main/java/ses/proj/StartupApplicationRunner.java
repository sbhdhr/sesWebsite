package ses.proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ses.proj.entity.AlertType;
import ses.proj.entity.DefaultAlerts;
import ses.proj.repository.AlertTypeRepo;

@Component
public class StartupApplicationRunner implements ApplicationRunner {

	@Autowired
	AlertTypeRepo atrepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

//		System.out.println("Adding default alerts..");
//		for (AlertType at : DefaultAlerts.getDefaultAlerts()) {
//			atrepo.save(at);
//		}
	}
}