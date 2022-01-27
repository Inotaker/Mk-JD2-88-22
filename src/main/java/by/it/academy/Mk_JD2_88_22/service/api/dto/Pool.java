
package by.it.academy.Mk_JD2_88_22.service.api.dto;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;

import java.util.Arrays;

public class Pool {
    private int artist;
    private int[] genres;
    private String about;

    public Pool(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
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
        IPoolService poolService = new PoolService();
        return "Исполнитель - " + poolService.getArtists().get(artist - 1).toString() + "\n жанры под номером - " + Arrays.toString(genres) + "\n информация о проголосовавшем - " + about;
    }
}