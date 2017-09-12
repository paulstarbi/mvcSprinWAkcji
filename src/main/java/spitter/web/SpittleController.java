package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spitter.Spittle;
import spitter.data.SpittleRepository;

import java.util.List;


@Controller
@RequestMapping ("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(
            SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//
//        model.addAttribute(spittleRepository
//                .findSpittles(Long.MAX_VALUE, 20));
//
//        return "spittles";
//    }
//
    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue ="23999") long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {

        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model ) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
