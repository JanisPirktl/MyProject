package Synchronized;

import javax.swing.event.EventListenerList;
import java.util.*;

public class EventlistenerList {


    private EventListenerList listeners = new EventListenerList();
    private List<String> ads = Arrays.asList("Jetzt explodiert auch der Haarknoten",
            "Red Fish verleiht Flossen",
            "Bom Chia Wowo",
            "Wunder Whip. Iss milder.");

    public void Radio() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Collections.shuffle(ads);
                notifyAdvertisement(new AdEvent(this, ads.get(0)));
            }
        }, 0, 500);
    }

    public synchronized void addAdListener(AdListener listener) {
        listeners.add(AdListener.class, listener);
    }

    public synchronized void removeAdListener(AdListener listener) {
        listeners.remove(AdListener.class, listener);
    }

    protected synchronized void notifyAdvertisement(AdEvent event) {
        for (AdListener l : listeners.getListeners(AdListener.class))
            l.advertisement(event);
    }
}





