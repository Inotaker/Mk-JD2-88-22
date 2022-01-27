
package by.it.academy.Mk_JD2_88_22.service;

import by.it.academy.Mk_JD2_88_22.service.api.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;
import by.it.academy.Mk_JD2_88_22.service.api.dto.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.SavedPool;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PoolService implements IPoolService {

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

    @Override
    public List<ChoiceWithCount> getTopArtist() {
        return null;
    }

    @Override
    public List<ChoiceWithCount> getTopGenres() {
        return null;
    }

    @Override
    public List<SavedPool> getSortedPool(Comparator<SavedPool> comparator) {
        return null;
    }

}
