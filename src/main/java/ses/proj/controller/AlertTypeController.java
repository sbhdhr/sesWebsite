package ses.proj.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ses.proj.entity.AlertType;
import ses.proj.repository.AlertTypeRepo;
import ses.proj.utility.MapValidationErrorService;

@RestController
@RequestMapping("api/alerttype")
public class AlertTypeController {

	@Autowired
	AlertTypeRepo atrepo;

	@Autowired
	private MapValidationErrorService errorService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllAlerts() {

		List<AlertType> types = (List<AlertType>) atrepo.findAll();

		return new ResponseEntity<List<AlertType>>(types, HttpStatus.OK);

	}

	@PostMapping("")
	public ResponseEntity<?> createNewAlertType(@Valid @RequestBody String s, BindingResult result) {
		System.out.println(s);
		AlertType at = new AlertType();
		at.setDesc(s);
		if (result.hasErrors()) {
			ResponseEntity<?> errorMap = errorService.mapValidationError(result);
			return errorMap;
		} else {
			AlertType response = atrepo.save(at);
			return new ResponseEntity<AlertType>(response, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/{alertTypeId}")
	public ResponseEntity<?> deleteAlert(@PathVariable Long alertTypeId) {
		//System.out.println("delete ::"+alertId);
		HashMap<String, String> res= new HashMap<String, String>();
		
		if (atrepo.existsById(alertTypeId))
		{
			atrepo.deleteById(alertTypeId);
			res.put("success", "Alert :: "+alertTypeId+" deleted.");
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.OK);
		}else {
			res.put("error", "Alert :: "+alertTypeId+" is invalid.");
			return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.BAD_REQUEST);
		}
	}

}
