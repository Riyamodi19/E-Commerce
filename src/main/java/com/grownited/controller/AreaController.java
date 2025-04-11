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
	public String newArea() {
		return "NewArea";
	}
	
	@PostMapping("savearea")
	public String saveArea(AreaEntity entityarea) {
		System.out.println(entityarea.getAreaName());
		repoArea.save(entityarea);
		return "redirect:/listarea";
	}
	
	//listarea
		@GetMapping("listarea")
		public String listarea(Model model) {
			List<AreaEntity> areaList = repoArea.findAll();// select * from area; //500 -> arearEntity
			
			//how to send data from controller to jsp 
			//Model 
			model.addAttribute("areaList", areaList);
							//dataName , dataValue 
			
			return "ListArea";
		}
		
		@GetMapping("viewarea")
		public String viewArea(Integer areaId, Model model) {
			// ?
			System.out.println("id ===> " + areaId);
			Optional<AreaEntity> op = repoArea.findById(areaId);
			if (!op.isPresent()) {
				// not found
			} else {
				// data found
				AreaEntity area = op.get();
				// send data to jsp ->
				model.addAttribute("area", area);

			}

			return "ViewArea";
		}
		
		@GetMapping("deletearea")
		public String deleteArea(Integer areaId) {
			repoArea.deleteById(areaId);
			return "redirect:/listarea";
		}	
	
	
}
