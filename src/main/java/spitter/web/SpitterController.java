package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String postSpitter(Spittr spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUserName();
    }

}
