import java.util.ArrayList;
import java.util.Random;

public class Scheda {

    private ArrayList<ArrayList<Integer>> righe;

    public Scheda() {
        this.righe = new ArrayList<>();
        Random r = new Random();
        ArrayList<Integer> numeriGenerati = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> riga = new ArrayList<>();
            while (riga.size() < 5) {
                int numero = r.nextInt(90) + 1;
                if (!numeriGenerati.contains(numero)) {
                    numeriGenerati.add(numero);
                    riga.add(numero);
                }
            }
            righe.add(riga);
        }
    }

    public ArrayList<ArrayList<Integer>> getRighe() {
        return righe;
    }

    public boolean rimuoviNumero(int numero) {
        for (ArrayList<Integer> riga : righe) {
            if (riga.remove((Integer) numero)) {
                return true;
            }
        }
        return false;
    }

    public int NumeriRimastiRiga(int rigaIndex) {
        return righe.get(rigaIndex).size();
    }
}