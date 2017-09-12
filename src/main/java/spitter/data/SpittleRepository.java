package spitter.data;


import org.springframework.stereotype.Component;
import spitter.Spittle;

import java.util.List;


public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);
}
