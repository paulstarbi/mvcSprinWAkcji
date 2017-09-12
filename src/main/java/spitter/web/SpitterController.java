package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spitter.Spittr;
import spitter.data.SpitterRepository;

@Controller
@RequestMapping ("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository repository){
        this.spitterRepository = repository;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "registerForm";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(Spittr spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String procedeUserSide(@PathVariable ("username") String username,
                                  Model model) {
        Spittr spittr = spitterRepository.findByName(username);
        model.addAttribute(spittr);
        return "profile";
    }

}
