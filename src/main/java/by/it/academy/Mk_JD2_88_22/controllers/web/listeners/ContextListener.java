package by.it.academy.Mk_JD2_88_22.controllers.web.listeners;

import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.Pool;
import by.it.academy.Mk_JD2_88_22.service.api.dto.pool.SavedPool;
import by.it.academy.Mk_JD2_88_22.service.pool.PoolService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContextListener implements ServletContextListener {
    PoolService service = PoolService.getInstance();
    File file = new File("C:\\tools\\pools.txt");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("|~~|~~|Servlet context initialized " + servletContextEvent.getServletContext().getServletContextName() + "|~~|~~|");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            List<SavedPool> deserializeList = (ArrayList<SavedPool>) objectInput.readObject();
//            //only one Pool
//            SavedPool serializePool = (SavedPool) objectInput.readObject();
//            //
//            Pool pool = new Pool(serializePool.getPool().getArtist(), serializePool.getPool().getGenres(), serializePool.getPool().getAbout());
//            LocalDateTime deserializedTime = serializePool.getTime();
//            service.deserializedPool(pool, deserializedTime);
            for (SavedPool savedPool : deserializeList) {
                Pool pool = new Pool(savedPool.getPool().getArtist(), savedPool.getPool().getGenres(), savedPool.getPool().getAbout());
                LocalDateTime deserializedTime = savedPool.getTime();
                service.deserializedPool(pool, deserializedTime);
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
        List<SavedPool> serializeList = new ArrayList<>(service.getPools());
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
//            //only one Pool
//            objectOutput.writeObject(service.getPools().get(0));
//            //
            objectOutput.writeObject(serializeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
