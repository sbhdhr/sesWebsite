package ses.proj.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ses.proj.entity.AlertType;
import ses.proj.entity.IncomingAlert;
import ses.proj.repository.AlertTypeRepo;
import ses.proj.repository.IncomingAlertRepo;

@RestController
@RequestMapping("api/alert")
public class IncomingAlertController {

	@Autowired
	IncomingAlertRepo iarepo;

	@Autowired
	AlertTypeRepo atrepo;

	@GetMapping("/all")
	public ResponseEntity<?> getAllAlerts() {

		List<IncomingAlert> alerts = (List<IncomingAlert>) iarepo.findAll();
		// System.out.println("i am being called");

		return new ResponseEntity<List<IncomingAlert>>(alerts, HttpStatus.OK);

	}

	@GetMapping("/max")
	public ResponseEntity<?> getMaxIncAlertId() {

		Object ido = iarepo.getMaxIncAlertId();
		Long id;
		if (ido != null) {
			BigInteger idbi = (BigInteger) ido;
			id = idbi.longValue();
		} else {
			id = 0L;
		}
		return new ResponseEntity<Long>(id, HttpStatus.OK);

	}

	@PostMapping("/{eventId}/{alertType}")
	public ResponseEntity<?> createAlert(@PathVariable Long eventId,@PathVariable Long alertType) {

		Optional<AlertType> typeOpt = atrepo.findById(alertType);
		if (typeOpt.isPresent()) {
			IncomingAlert alert = new IncomingAlert();
			alert.setDesc(typeOpt.get().getDesc());
			alert.setEventId(eventId);

			alert = iarepo.save(alert);
			return new ResponseEntity<IncomingAlert>(alert, HttpStatus.CREATED);
		}
		HashMap<String, String> res = new HashMap<String, String>();
		res.put("error", "Alert Value " + alertType + " is invalid.");
		return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{alertId}")
	public ResponseEntity<?> deleteAlert(@PathVariable Long alertId) {
		// System.out.println("delete ::"+alertId);
		HashMap<String, String> res = new HashMap<String, String>();

		if (iarepo.existsById(alertId)) {
			iarepo.deleteById(alertId);
			res.put("success", "Alert :: " + alertId + " deleted.");
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.OK);
		} else {
			res.put("error", "Alert :: " + alertId + " is invalid.");
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{alertId}")
	public ResponseEntity<?> handleAlert(@PathVariable Long alertId) {
		HashMap<String, String> res = new HashMap<String, String>();

		Optional<IncomingAlert> alertOpt = iarepo.findById(alertId);
		if(alertOpt.isPresent()) {
			List<IncomingAlert> alerts = iarepo.getAllAlertsForEventId(alertOpt.get().getEventId());
			Long[] ids = new Long[alerts.size()];
			int c=0;
			for(IncomingAlert a : alerts) {
				a.setHandled(true);
				ids[c++]=a.getId();
			}
			iarepo.saveAll(alerts);
			String msg = "Alert :: ";
			for(Long l:ids) {
				msg=msg+" "+l.toString();
			}
			msg = msg + " updated.";
					
			res.put("success", msg );
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.OK);
		} else {
			res.put("error", "Alert :: " + alertId + " is invalid.");
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.BAD_REQUEST);
		}
	}

}
