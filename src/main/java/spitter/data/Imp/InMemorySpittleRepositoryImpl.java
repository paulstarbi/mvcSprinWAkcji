package spitter.data.Imp;

import org.springframework.stereotype.Component;
import spitter.Spittle;
import spitter.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InMemorySpittleRepositoryImpl implements SpittleRepository {

    List<Spittle> splits;

    public List<Spittle> findSpittles(long max, int count) {
        return temporaryInit();
    }

    private List<Spittle> temporaryInit() {
        splits = new ArrayList<Spittle>();

        for (int i = 0; i < 15; i++) {
            splits.add(new Spittle("splite numer "+ i, new Date(System.currentTimeMillis())));
        }

        return splits;
    }
}
