
package by.it.academy.Mk_JD2_88_22.service.api.pool;

import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.SavedPool;

import java.util.List;

public interface IPoolService {
    List<String> getArtists();

    List<String> getGenres();

    List<SavedPool> getPools();

    void creatPool(Pool pool);

}