package ownUtil;

// Observable Interface
public interface Observable {
    void addObserver(Observer observer);      // Beobachter hinzufügen
    void removeObserver(Observer observer);   // Beobachter entfernen
    void notifyObservers();                   // Alle Beobachter benachrichtigen
}
