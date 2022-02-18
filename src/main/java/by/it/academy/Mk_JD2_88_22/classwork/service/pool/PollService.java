
package by.it.academy.Mk_JD2_88_22.classwork.service.pool;

import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.SavedPoll;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PollService implements IPollService, Serializable {

    private static final long serialVersionUID = 1L;

    private static PollService instance = new PollService();

    private List<String> artists = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<SavedPoll> pools = new ArrayList<>();


    public PollService() {
        this.artists.add("Ария");
        this.artists.add("Квин");
        this.artists.add("Баста");
        this.artists.add("Европа+");
        this.artists.add("Король и Шут");
        this.artists.add("All Good Things");
        this.artists.add("Hollywood Undead");


        this.genres.add("Поп");
        this.genres.add("Рок");
        this.genres.add("Джаз");
        this.genres.add("Классика");
        this.genres.add("Рэп");
        this.genres.add("Электроника");
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
    public List<SavedPoll> getPolls() {
        return Collections.unmodifiableList(pools);
    }

    @Override
    public void creatPoll(Poll poll) {
        SavedPoll saved = new SavedPoll(LocalDateTime.now(), poll);
        this.pools.add(saved);
        ChoiceWithCount.getPoolsModified().add(saved);
    }

    public void deserializedPool(Poll poll, LocalDateTime deserializedTime) {
        SavedPoll saved = new SavedPoll(deserializedTime, poll);
        this.pools.add(saved);
        ChoiceWithCount.getPoolsModified().add(saved);
    }

    public static PollService getInstance() {
        return instance;
    }
}
