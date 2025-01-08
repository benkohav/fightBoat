package fightboat.observer;

import java.util.*;

/*OBSERVER PATTERN: A way for an object (the subject) to notify a list of dependents (observers) about any state changes,
so they can automatically update themselves when the subject changes.

 */
// All publishers are singleton to
public abstract class Publisher {
    protected static Publisher pub = null;

    HashMap<Listener,ArrayList<String>> listeners = new HashMap<>();

    public static void subscribe(Listener listener, ArrayList<String> events) {
        pub.listeners.put(listener,events);
    }
    public static void unsubscribe(Listener listener) {
        pub.listeners.remove(listener);
    }

}
