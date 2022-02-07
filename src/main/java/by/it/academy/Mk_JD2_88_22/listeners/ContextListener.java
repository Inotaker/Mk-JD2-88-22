package by.it.academy.Mk_JD2_88_22.listeners;

import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.SavedPool;
import by.it.academy.Mk_JD2_88_22.service.pool.PoolService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.time.LocalDateTime;

public class ContextListener implements ServletContextListener {
    PoolService service = PoolService.getInstance();
    File file = new File("C:\\tools\\pools.txt");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("|~~|~~|Servlet context initialized " + servletContextEvent.getServletContext().getServletContextName() + "|~~|~~|");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            SavedPool savedPool = (SavedPool) objectInput.readObject();
            Pool pool = new Pool(savedPool.getPool().getArtist(), savedPool.getPool().getGenres(), savedPool.getPool().getAbout());
            LocalDateTime deserializedTime = savedPool.getTime();
            service.deserializedPool(pool, deserializedTime);
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
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            for (SavedPool pool : service.getPools()) {
                objectOutput.writeObject(pool);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
