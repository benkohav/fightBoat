package fightboat.observer;

/*OBSERVER PATTERN: A way for an object (the subject) to notify a list of dependents (observers) about any state changes,
so they can automatically update themselves when the subject changes.

 */
public abstract class Listener {

    public abstract void takeInData(String strIn);
}
