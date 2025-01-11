import java.util.ArrayList;
import java.util.Collections;

class Tombola {
    private ArrayList<Giocatore> partecipanti;
    private ArrayList<Integer> sacchetto;
    private boolean ternaFatta;
    private boolean quaternaFatta;
    private boolean cinquinaFatta;

    public Tombola(ArrayList<Giocatore> partecipanti) {
        this.partecipanti = partecipanti;
        this.sacchetto = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            sacchetto.add(i); 
        }
        Collections.shuffle(sacchetto);
        this.ternaFatta = false;
        this.quaternaFatta = false;
        this.cinquinaFatta = false;
    }

    public int estrazione() {
        int numero;
        numero=sacchetto.get(0);
        sacchetto.remove(0);
        return numero;
    }

    public String Vittoria() {
        for (Giocatore giocatore : partecipanti) {
            for (Scheda scheda : giocatore.getSchede()) {
                boolean tutteRigheVuote = true;
                for (int i = 0; i < 3; i++) {
                    int numeriRimasti = scheda.NumeriRimastiRiga(i);
                    int numeriEstratti = 5 - numeriRimasti;

                    tutteRigheVuote = tutteRigheVuote && (numeriRimasti == 0);

                    if (!cinquinaFatta && numeriEstratti == 5) {
                        cinquinaFatta = true;
                        return "Cinquina nella riga " + (i + 1) + " per " + giocatore.getNome();
                    }
                    if (!quaternaFatta && numeriEstratti == 4) {
                        quaternaFatta = true;
                        return "Quaterna nella riga " + (i + 1) + " per " + giocatore.getNome();
                    }
                    if (!ternaFatta && numeriEstratti == 3) {
                        ternaFatta = true;
                        return "Terna nella riga " + (i + 1) + " per " + giocatore.getNome();
                    }
                }
                if (tutteRigheVuote) {
                    return "Tombola! Il vincitore è " + giocatore.getNome();
                }
            }
        }
        return null;
    }

    public String partita() {
        while (!sacchetto.isEmpty()) {
            int estratto = estrazione();
            System.out.println("Numero estratto: " + estratto);

            for (Giocatore giocatore : partecipanti) {
                for (Scheda scheda : giocatore.getSchede()) {
                    if (scheda.rimuoviNumero(estratto)) {
                        System.out.println("Numero " + estratto + " rimosso da " + giocatore.getNome());
                    }
                }
            }

            String risultato = Vittoria();
            if (risultato != null && risultato.startsWith("Tombola")) {
                return risultato;
            } else if (risultato != null) {
                System.out.println(risultato);
            }
        }
        return "Tutti i numeri sono stati estratti e nessuno ha fatto tombola!";
    }
}