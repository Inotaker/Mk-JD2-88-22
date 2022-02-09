
package by.it.academy.Mk_JD2_88_22.service.api.pool;

import by.it.academy.Mk_JD2_88_22.service.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.service.dto.polls.SavedPoll;

import java.util.List;

public interface IPollService {
    List<String> getArtists();

    List<String> getGenres();

    List<SavedPoll> getPolls();

    void creatPoll(Poll poll);

}