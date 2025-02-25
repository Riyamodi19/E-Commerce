package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;


@Controller
public class StateController {
	//input
	//process
	
	@Autowired
	StateRepository repoState;
	
	
@GetMapping("newstate")
public String newState() {
	return "NewState";
}
@PostMapping("savestate")
public String saveState(StateEntity state) {
	System.out.println(state.getStateName());
	repoState.save(state);
	return "redirect:/liststate";
}
//list state
@GetMapping("liststate")
public String listState(Model model) {
	List<StateEntity> stateList = repoState.findAll();// select * from members; //500 -> MemberEntity
	
	//how to send data from controller to jsp 
	//Model 
	model.addAttribute("stateList", stateList);
					//dataName , dataValue 
	
	return "ListState";
}
}
