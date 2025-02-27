package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

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
//view state

	@GetMapping("viewstate")
	public String viewState(Integer stateId, Model model) {
		// ?
		System.out.println("id ===> " + stateId);
		Optional<StateEntity> op = repoState.findById(stateId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
	        StateEntity state = op.get();
			// send data to jsp ->
			model.addAttribute("state", state);

		}

		return "ViewState";
	}
	//delete product
	@GetMapping("deletestate")
	public String deleteState(Integer stateId) {
		repoState.deleteById(stateId);//delete from members where memberID = :memberId
		return "redirect:/liststate";
	}
}
