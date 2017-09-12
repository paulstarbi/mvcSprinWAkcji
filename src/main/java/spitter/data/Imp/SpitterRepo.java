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
    public Spittr save(Spittr spitter) {
        users.add(spitter);
        return spitter;
    }

    @Override
    public Spittr findByName(String username) {
        final Spittr[] result = new Spittr[1];
        users.forEach(user -> {
            if(user.getUserName().equalsIgnoreCase(username))
                result[0] = user;
        });
        return result[0];
    }

}
