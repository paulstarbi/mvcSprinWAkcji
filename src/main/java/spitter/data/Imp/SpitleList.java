package spitter.data.Imp;

import org.springframework.stereotype.Component;
import spitter.model.Spittle;
import spitter.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SpitleList implements SpittleRepository {

    List<Spittle> splits;

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> toShow = temporaryInit();
        int from = toShow.size()-count-1;
        int to = toShow.size()-1;

        return toShow.subList(from, to);
    }

    public Spittle findOne(final long i) {
        return splits.get(22);
    }

    private List<Spittle> temporaryInit() {
        splits = new ArrayList<Spittle>();

        for (int i = 0; i < 75; i++) {
            splits.add(new Spittle("splite numer "+ i, new Date(System.currentTimeMillis())));
        }

        return splits;
    }
}
