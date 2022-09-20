package com.example.clientsservicepd12.ui.controllers;

import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ClientsController {
	@Qualifier("clientServiceDb")
	@Autowired
	private ClientService clientService;

	@GetMapping("/")
	public String load() {
		return "redirect:clients";
	}

	@GetMapping("clients")
	public String loadClients(Model model) {
		List<Client> list = clientService.findAll();
		model.addAttribute("clients", list);
		return "clients";
	}

	@PostMapping("clientForm")
	public String clientForm(
		@RequestParam("surname") String surname,
		@RequestParam("name") String name,
		@RequestParam("patronymic") String patronymic,
		@RequestParam("birthDate") String birthDate,
		@RequestParam("gender") Client.Gender gender,
		@RequestParam("email") String email
	) {
		Client client = new Client(0, surname, name, patronymic,
			LocalDate.parse(birthDate), gender, email, null, null);
		clientService.save(client);
		return "redirect:clients";
	}

	@PostMapping("clientUpdateOpen")
	public ModelAndView clientUpdateOpen(@RequestParam("id") Integer id) {
		//Client client = clientService.findBiId(id);
		//return new ModelMap()
		return new ModelAndView("redirect:clientUpdate",
			new ModelMap("id", id));
	}
}
