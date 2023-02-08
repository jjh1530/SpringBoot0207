package jh.ftb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jh.ftb.entity.BootBoard;
import jh.ftb.service.BootBoardService;

@Controller
@RequestMapping("/board/*")
public class BootBoardController {

	@Autowired
	BootBoardService bootBoardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BootBoard> list = bootBoardService.getLists();
		model.addAttribute("list", list);
		return "board/list";  
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(BootBoard vo) {
		bootBoardService.register(vo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	@ResponseBody
	public BootBoard get(Long idx) {
		BootBoard vo = bootBoardService.get(idx);
		return vo;
	}
	
	@GetMapping("/remove")
	public String remove(Long idx) {
		bootBoardService.delete(idx);
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BootBoard vo) {
		bootBoardService.modify(vo);
		return "redirect:/board/list";
	}
}
