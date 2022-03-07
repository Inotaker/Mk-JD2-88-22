
package by.it.academy.Mk_JD2_88_22.classwork.dto.polls;

import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;

import java.io.Serializable;
import java.util.Arrays;

public class Poll implements Serializable {
    private static final long serialVersionUID = 1L;
    private int artist;
    private int[] genres;
    private String about;

    public Poll(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public Poll(){

    }
    public int getArtist() {
        return artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        IPollService poolService = new PollService();
        return "Исполнитель - " + poolService.getArtists().get(artist - 1).toString() + "| жанры под номером - " + Arrays.toString(genres) + "| информация о проголосовавшем - " + about;
    }
}