package spitter.data.Imp;

import org.springframework.stereotype.Component;
import spitter.model.Spitter;
import spitter.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepo implements SpitterRepository {

    List<Spitter> users = new ArrayList<>();


    @Override
    public Spitter save(Spitter spitter) {
        users.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByName(String username) {
        final Spitter[] result = new Spitter[1];
        users.forEach(user -> {
            if(user.getUserName().equalsIgnoreCase(username))
                result[0] = user;
        });
        return result[0];
    }

}
