
package by.it.academy.Mk_JD2_88_22.service.pool;

import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.SavedPool;
import by.it.academy.Mk_JD2_88_22.service.api.pool.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.service.api.pool.IPoolService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PoolService implements IPoolService {

    private static PoolService instance = new PoolService();

    private List<String> artists = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<SavedPool> pools = new ArrayList<>();


    public PoolService() {
        this.artists.add("Ария");
        this.artists.add("Квин");
        this.artists.add("Баста");
        this.artists.add("Европа+");


        this.genres.add("Поп");
        this.genres.add("Рок");
        this.genres.add("Джаз");
        this.genres.add("Классика");
        this.genres.add("....");
    }

    @Override
    public List<String> getArtists() {
        return Collections.unmodifiableList(artists);
    }

    @Override
    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    @Override
    public List<SavedPool> getPools() {
        return Collections.unmodifiableList(pools);
    }

    @Override
    public void creatPool(Pool pool) {
        SavedPool saved = new SavedPool(LocalDateTime.now(), pool);
        this.pools.add(saved);
        ChoiceWithCount.getPoolsModified().add(saved);
    }

    public void deserializedPool(Pool pool, LocalDateTime deserializedTime) {
        SavedPool saved = new SavedPool(deserializedTime, pool);
        this.pools.add(saved);
        ChoiceWithCount.getPoolsModified().add(saved);
    }

    public static PoolService getInstance() {
        return instance;
    }
}
