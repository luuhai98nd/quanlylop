package hvitclan.com.restful.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import hvitclan.com.restful.entites.Lop;
import hvitclan.com.restful.service.LopService;

@RestController
@RequestMapping(value = "/lop")
public class LopController {
	@Autowired
	LopService lopService;
	
	@GetMapping(value = "/get")
	public List<Lop> home() throws JsonProcessingException{
		return lopService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Lop add(@RequestBody String lop) {
		Gson gson = new Gson();
		Lop lopMoi = gson.fromJson(lop, Lop.class);
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<Lop>> violations= validator.validate(lopMoi);
		 
		for(ConstraintViolation<Lop> violation : violations) {
			System.out.println(violation.getMessage());
		}
		
		if (violations.size() == 0) 
		lopService.add(lopMoi);
		return lopMoi;
	}
}
