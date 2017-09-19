package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.model.Spitter;
import spitter.data.SpitterRepository;

import javax.validation.Valid;

@Controller
@RequestMapping ("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository repository){
        this.spitterRepository = repository;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute ("spitter") Spitter spitter, BindingResult result) {

        if (result.hasErrors() || spitter.getUserName().isEmpty()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String procedeUserSide(@PathVariable ("username") String username,
                                  Model model) {
        Spitter spitter = spitterRepository.findByName(username);
        model.addAttribute("spitter", spitter);

        return "profile";
    }

}
