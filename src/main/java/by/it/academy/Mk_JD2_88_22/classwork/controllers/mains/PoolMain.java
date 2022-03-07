package by.it.academy.Mk_JD2_88_22.classwork.controllers.mains;

import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;

import java.util.List;

public class PoolMain {
    public static void main(String[] args) throws InterruptedException {
        IPollService service = PollService.getInstance();
        List<String> artists = service.getArtists();
        List<String> genres = service.getGenres();

        int choiceArtist = 2;
        int[] choiceGenres = new int[3];
        choiceGenres[0] = 0;
        choiceGenres[1] = 5;
        choiceGenres[2] = 10;

        String about = "Привет, я Илья";

        Poll poll = new Poll(choiceArtist, choiceGenres, about);

        service.creatPoll(poll);

        System.out.println(service.getArtists());
        System.out.println(service.getGenres());
        System.out.println(service.getPolls());

        Poll poll2 = new Poll(4, new int[]{1, 2, 3}, "hELLO");
        service.creatPoll(poll2);

        System.out.println(service.getArtists());
        System.out.println(service.getGenres());
        System.out.println(service.getPolls());
    }
}
