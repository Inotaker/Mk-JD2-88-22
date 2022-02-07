
package by.it.academy.Mk_JD2_88_22.service.api.dto.pool;

import by.it.academy.Mk_JD2_88_22.service.pool.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.pool.IPoolService;

import java.io.Serializable;
import java.util.Arrays;

public class Pool implements Serializable {
    private static final long serialVersionUID = 1L;
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
        return "Исполнитель - " + poolService.getArtists().get(artist - 1).toString() + "| жанры под номером - " + Arrays.toString(genres) + "| информация о проголосовавшем - " + about;
    }
}