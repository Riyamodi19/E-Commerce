package com.grownited.controller;

import java.util.List;


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

}
