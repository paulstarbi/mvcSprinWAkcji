package spitter.data;

import spitter.Spittr;

public interface SpitterRepository {
    Spittr save(Spittr spitter);

    Spittr findByName(String username);
}
