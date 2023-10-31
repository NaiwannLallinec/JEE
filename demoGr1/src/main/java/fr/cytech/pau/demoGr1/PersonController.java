package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "person-form";
	}

	@PostMapping("/form")
	public String submitForm(@ModelAttribute Person person) {
		personRepository.save(person);
		return "redirect:/list";
	}

	@GetMapping("list")
	public String listPeople(Model model) {
		Iterable<Person> people = personRepository.findAll();
		model.addAttribute("people", people);
		return "person-list";
	}

	@PostMapping("/connect")
	public String connect(@ModelAttribute Person person) {
		Person personne = personRepository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
		if (personne != null) {
			return "redirect:/found";
		} else {
			return "redirect:/not-found";
		}
	}

	@GetMapping("/found")
	public String rediriger() {
		return "bravo";
	}

	@GetMapping("/not-found")
	public String nonrediriger() {
		return "aie";
	}
	
	@PostMapping("/stocking")
	public String stocker() {
		return "redirect:/productregister";
	}
}
