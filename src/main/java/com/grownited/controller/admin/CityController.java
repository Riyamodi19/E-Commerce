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
	System.out.println("id ===> " + cityId);
	Optional<CityEntity> op = repoCity.findById(cityId);
	if (op.isEmpty()) {
		// not found
	} else {
		// data found
        CityEntity city = op.get();
		// send data to jsp ->
		model.addAttribute("city", city);

	}

	return "ViewCity";
}
//delete city
@GetMapping("deletecity")
public String deleteCity(Integer cityId) {
	repoCity.deleteById(cityId);//delete from members where memberID = :memberId
	return "redirect:/listcity";
}

}
