package com.example.clientsservicepd12.ui.controllers;

import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.models.Phone;
import com.example.clientsservicepd12.services.data.ClientService;
import com.example.clientsservicepd12.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class ClientUpdateController {
	@Autowired
	private ClientService clientService;
	@Autowired
	private PhoneService phoneService;

	@GetMapping("clientUpdate")
	public String clientUpdateLoad(Model model, @RequestParam("id") Integer id) {
		Client client = clientService.findBiId(id);
		model.addAttribute("client", client);
		List<Phone> phones = phoneService.findAll();
		model.addAttribute("phones", phones);
		/*String line = "<option value=\"%s\" %s>%s</option>\n";
		StringBuilder sb = new StringBuilder();
		for (Client.Gender gender : Client.Gender.values()) {
			sb.append(String.format(line,gender.name(),
				gender == client.getGender() ? "selected" : "",gender.name()));
		}
		model.addAttribute("select", sb.toString());*/
		return "clientUpdate";
	}

	@PostMapping("clientUpdateForm")
	public String clientUpdateForm(@ModelAttribute("client") Client client) {
		clientService.save(client);
		return "redirect:clients";
	}

	@PostMapping("addPhoneForm")
	public ModelAndView addPhoneForm(@ModelAttribute("phone") Phone phone,
										@RequestParam("clientId") Integer clientId) {
		Client client = clientService.findBiId(clientId);
		phone.setClient(client);
		phoneService.save(phone);
		System.err.println("addPhoneForm");
		return new ModelAndView("redirect:clientUpdate",
			new ModelMap("id", clientId));
	}

	@PostMapping("deletePhoneForm")
	public ModelAndView updatePhoneForm(
		@RequestParam("clientId") Integer clientId,
		@RequestParam("phoneDelete") Long phoneId
	) {
		phoneService.deleteById(phoneId);
		return new ModelAndView("redirect:clientUpdate",
			new ModelMap("id", clientId));
	}
}
