package spitter.data.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spitter.Spittr;
import spitter.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepo implements SpitterRepository {

    List<Spittr> users = new ArrayList<>();


    @Override
    public void save(Spittr spitter) {
        users.add(spitter);
    }

}
