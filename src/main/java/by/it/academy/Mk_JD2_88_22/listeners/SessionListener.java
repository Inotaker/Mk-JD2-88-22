package by.it.academy.Mk_JD2_88_22.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static int countSession = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("|~~|~~|Session " + httpSessionEvent.getSession().getId() + " created|~~|~~|");
        countSession++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("|~~|~~|Session " + httpSessionEvent.getSession().getId() + " terminated|~~|~~|");
        countSession--;
    }

    public static int getCountSession() {
        return countSession;
    }
}
