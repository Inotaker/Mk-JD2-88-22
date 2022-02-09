package by.it.academy.Mk_JD2_88_22.service.api.pool;

import by.it.academy.Mk_JD2_88_22.service.pool.PollService;
import by.it.academy.Mk_JD2_88_22.service.dto.polls.SavedPoll;

import java.util.*;

public class ChoiceWithCount {
    private static IPollService poolService = PollService.getInstance();
    private static List<SavedPoll> poolsModified = new ArrayList<>();


    private static Map<String, Integer> performerTop = new HashMap<>();
    private static Map<String, Integer> genresTop = new HashMap<>();

    public static List<Map.Entry<String, Integer>> getPerformerTop() {
        performerTop.clear();
        int numberOfPerformer = 0;
        List<String> performerList = poolService.getArtists();
        for (SavedPoll savedPoll : poolsModified) {
            numberOfPerformer = savedPoll.getPool().getArtist();
            String performerByHisNumber = performerList.get(numberOfPerformer - 1);
            if (performerTop.containsKey(performerByHisNumber)) {
                for (Map.Entry<String, Integer> entry : performerTop.entrySet()) {
                    if (entry.getKey().equals(performerByHisNumber)) {
                        performerTop.put(performerByHisNumber, entry.getValue() + 1);
                    }
                }
            } else {
                performerTop.put(performerByHisNumber, 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedPerformerTop = new ArrayList<>(performerTop.entrySet());
        sortedPerformerTop.sort(Map.Entry.comparingByValue());
        Collections.reverse(sortedPerformerTop);
        return sortedPerformerTop;
    }

    public static List<Map.Entry<String, Integer>> getGenresTop() {
        genresTop.clear();
        int numberOfGenres = 0;
        List<String> genresList = poolService.getGenres();
        for (SavedPoll savedPoll : poolsModified) {
            for (int i = 0; i < savedPoll.getPool().getGenres().length; i++) {
                numberOfGenres = savedPoll.getPool().getGenres()[i];//достаю номер жанра, за который проголосовали
                String genreByHisNumber = genresList.get(numberOfGenres - 1);
                if (genresTop.containsKey(genreByHisNumber)) {
                    for (Map.Entry<String, Integer> entry : genresTop.entrySet()) {
                        if (entry.getKey().equals(genreByHisNumber)) {
                            genresTop.put(genreByHisNumber, entry.getValue() + 1);
                        }
                    }
                } else {
                    genresTop.put(genreByHisNumber, 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> sortedGenresTop = new ArrayList<>(genresTop.entrySet());
        sortedGenresTop.sort(Map.Entry.comparingByValue());
        Collections.reverse(sortedGenresTop);
        return sortedGenresTop;
    }

    public List<SavedPoll> getSortedPoolByTime() {
        return poolsModified;
    }

    public static List<SavedPoll> getPoolsModified() {
        return poolsModified;
    }

}
