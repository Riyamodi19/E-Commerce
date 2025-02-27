package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AreaEntity;
import com.grownited.repository.AreaRepository;

@Controller
public class AreaController {
	@Autowired 
	AreaRepository repoArea;
	
	@GetMapping("newarea")
    public String newarea() {
	 return "NewArea";
	}
	
	@PostMapping("savearea")
	public String savearea(AreaEntity areaEntity) {
		System.out.println(areaEntity.getAreaName());
		repoArea.save(areaEntity);
		return "redirect:/listarea";// jsp name
	}
	//list area
	@GetMapping("listarea")
	public String listArea(Model model) {
		List<AreaEntity> areaList = repoArea.findAll();// select * from members; //500 -> MemberEntity
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("areaList", areaList);
						//dataName , dataValue 
		
		return "ListArea";
	}

   //view area

	@GetMapping("viewarea")
	public String viewArea(Integer areaId, Model model) {
		// ?
		System.out.println("id ===> " + areaId);
		Optional<AreaEntity> op = repoArea.findById(areaId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
	        AreaEntity area = op.get();
			// send data to jsp ->
			model.addAttribute("area", area);

		}

		return "ViewArea";
	}
	//deletearea
	@GetMapping("deletearea")
	public String deleteArea(Integer areaId) {
		repoArea.deleteById(areaId);//delete from members where memberID = :memberId
		return "redirect:/listarea";
	}
}
