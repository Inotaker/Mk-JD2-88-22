package by.it.academy.Mk_JD2_88_22.endpoints;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;
import by.it.academy.Mk_JD2_88_22.service.api.dto.Pool;

import java.util.List;

public class PoolMain {
    public static void main(String[] args) {
        IPoolService service = new PoolService();
        List<String> artists = service.getArtists();
        List<String> genres = service.getGenres();

        int choiceArtist = 2;
        int[] choiceGenres = new int[3];
        choiceGenres[0] = 0;
        choiceGenres[1] = 5;
        choiceGenres[2] = 10;

        String about = "Привет, я Илья";

        Pool pool = new Pool(choiceArtist, choiceGenres, about);

        service.creatPool(pool);

        System.out.println(service.getArtists());
        System.out.println(service.getGenres());
        System.out.println(service.getPools());

        Pool pool2 = new Pool(4,new int[]{1,2,3},"hELLO");
        service.creatPool(pool2);

        System.out.println(service.getArtists());
        System.out.println(service.getGenres());
        System.out.println(service.getPools());
    }
}
