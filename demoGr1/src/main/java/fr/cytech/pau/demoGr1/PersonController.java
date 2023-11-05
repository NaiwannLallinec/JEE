package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

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
	public String submitForm(@ModelAttribute Person person, Model model) {
		Person existingPerson = personRepository.findByFirstName(person.getFirstName());
		if (existingPerson != null) {
			return "redirect:/form-error";
		} else {
			personRepository.save(person);
			return "redirect:/form-reussi";
		}
	}

	@GetMapping("form-error")
	public String listErrorPeople(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message2", "Le nom d'utilisateur existe déjà");
		return "redirect:/form";
	}

	@GetMapping("form-reussi")
	public String listRightPeople(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message3", "Votre compte a bien été créé !");
		return "redirect:/form";
	}

	@GetMapping("list")
	public String listPeople(Model model) {
		Iterable<Person> people = personRepository.findAll();
		model.addAttribute("people", people);
		return "person-list";
	}

	@PostMapping("/connect")
	public String connect(@ModelAttribute Person person, HttpSession session) {
		if ("admin".equals(person.getFirstName()) && "admin".equals(person.getLastName())) {
			Person personne = personRepository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
			session.setAttribute("person",personne);
			session.setAttribute("admin",1);
			return "redirect:/found-admin";
		} else {
			Person personne = personRepository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
			if (personne != null) {
				session.setAttribute("person",personne);
				return "redirect:/found";
			} else {
				return "redirect:/not-found";
			}
		}
	}

	@GetMapping("/found")
	public String rediriger() {
		return "accueil";
	}

	@GetMapping("/found-admin")
	public String redirigerAdmin() {
		return "bravo-admin";
	}

	@GetMapping("/not-found")
    public String nonrediriger(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Utilisateur non trouvé");
        return "redirect:/form";
    }

	@PostMapping("/stocking")
	public String stocker() {
		return "redirect:/productregister";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/accueil";
    }
}
