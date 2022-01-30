
package by.it.academy.Mk_JD2_88_22.service.api;

import by.it.academy.Mk_JD2_88_22.service.api.dto.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.SavedPool;

import java.util.List;

public interface IPoolService {
    List<String> getArtists();

    List<String> getGenres();

    List<SavedPool> getPools();

    void creatPool(Pool pool);

}