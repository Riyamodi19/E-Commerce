package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;

@Controller
public class CityController {
	@Autowired
	CityRepository repoCity;
	
	@Autowired
	StateRepository repoState;
	
@GetMapping("newcity")
public String newCity(Model model) {
	
	List<StateEntity> allState = repoState.findAll();
	model.addAttribute("allState",allState);
	return "NewCity";
}

@PostMapping("savecity")
public String saveCity(CityEntity cityEntity) {
	System.out.println(cityEntity.getCityName());
	repoCity.save(cityEntity);
	return "redirect:/listcity";
}
//list city
@GetMapping("listcity")
public String listCity(Model model) {
	List<Object[]> listCity = repoCity.getAll();// select * from members; //500 -> MemberEntity
	//how to send data from controller to jsp 
	//Model 
	model.addAttribute("allCity",listCity);
					//dataName , dataValue 
	
	return "ListCity";
}
//viewcity

@GetMapping("viewcity")
public String viewCity(Integer cityId, Model model) {
	// ?
	//System.out.println("id ===> " + cityId);
	//Optional<CityEntity> op = repoCity.findById(cityId);
	//if (op.isEmpty()) {
		// not found
	//} else {
		// data found
       //CityEntity city = op.get();
		// send data to jsp ->
		//model.addAttribute("city", city);
	List<Object[]> op = repoCity.getByCityId(cityId);
	model.addAttribute("city", op);
	return "ViewCity";
}
//delete city
@GetMapping("deletecity")
public String deleteCity(Integer cityId) {
	repoCity.deleteById(cityId);//delete from members where memberID = :memberId
	return "redirect:/listcity";
}
//edit city 

@GetMapping("editcity")
public String editCity(Integer cityId,Model model) {
	Optional<CityEntity> op = repoCity.findById(cityId);
	if (!op.isPresent()) {
		return "redirect:/listcity";
	} else {
		model.addAttribute("city",op.get());
		return "EditCity";

	}
}
//save -> entity -> no id present -> insert 
//save -> entity -> id present -> not present in db -> insert 
//save -> entity -> id present -> present in db -> update  

//update city

@PostMapping("updatecity")
public String updateCity(CityEntity cityEntity) {//pcode vhreg type vid 
	
	System.out.println(cityEntity.getCityId());//id? db? 

	Optional<CityEntity> op = repoCity.findById(cityEntity.getCityId());
	
	if(op.isPresent())
	{
		CityEntity dbCity = op.get(); //pcode vhreg type id userId 
		dbCity.setCityName(cityEntity.getCityName());//code 
		repoCity.save(dbCity);
	}
	return "redirect:/listcity";
}

}
