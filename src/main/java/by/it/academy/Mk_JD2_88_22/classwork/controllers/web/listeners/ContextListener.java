package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.listeners;

import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.SavedPoll;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContextListener implements ServletContextListener {
    PollService service = PollService.getInstance();
    File file = new File("C:\\tools\\pools.txt");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("|~~|~~|Servlet context initialized " + servletContextEvent.getServletContext().getServletContextName() + "|~~|~~|");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            List<SavedPoll> deserializeList = (ArrayList<SavedPoll>) objectInput.readObject();
            for (SavedPoll savedPoll : deserializeList) {
                Poll poll = new Poll(savedPoll.getPool().getArtist(), savedPoll.getPool().getGenres(), savedPoll.getPool().getAbout());
                LocalDateTime deserializedTime = savedPoll.getTime();
                service.deserializedPool(poll, deserializedTime);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("|~~|~~|Servlet context destroyed " + servletContextEvent.getServletContext().getServletContextName() + "|~~|~~|");
        List<SavedPoll> serializeList = new ArrayList<>(service.getPolls());
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(serializeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
