package fightboat.observer;
import java.util.*;


/*OBSERVER PATTERN: A way for an object (the subject) to notify a list of dependents (observers) about any state changes,
so they can automatically update themselves when the subject changes.
 The EventPublisher is used to compile the updates we find throughout the game, and it specifically posts these updates to our event listener,
 which in turn records these changes in GameRecorder.
 */

// Singleton to make accessible everywhere in code
public class EventPublisher{

    private static EventPublisher pub = new EventPublisher();
    private EventPublisher() {}

    public static void postEvent(String event, String eventData) {
        for (Listener i : pub.listeners.keySet()) {
            ArrayList<String> events = pub.listeners.get(i);
            if (events.contains(event)) {
                i.takeInData(eventData);
            }
        }
    }

    HashMap<Listener,ArrayList<String>> listeners = new HashMap<>();

    public static void subscribe(Listener listener, ArrayList<String> events) {
        pub.listeners.put(listener,events);
    }
    public static void unsubscribe(Listener listener) {
        pub.listeners.remove(listener);
    }

}
