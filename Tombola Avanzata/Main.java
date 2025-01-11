import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Giocatore giocatore1 = new Giocatore("Alice");
        Giocatore giocatore2 = new Giocatore("Bob");
        Giocatore giocatore3 = new Giocatore("Carla");

        for (int i = 0; i < 2; i++) { 
            giocatore1.aggiungiScheda(new Scheda());
            giocatore2.aggiungiScheda(new Scheda());
            giocatore3.aggiungiScheda(new Scheda());
        }

        ArrayList<Giocatore> partecipanti = new ArrayList<>();
        partecipanti.add(giocatore1);
        partecipanti.add(giocatore2);
        partecipanti.add(giocatore3);

        Tombola tombola = new Tombola(partecipanti);

        System.out.println(tombola.partita());
    }
}