import java.util.ArrayList;

class Giocatore {
    private String nome;
    private ArrayList<Scheda> schede;

    public Giocatore(String nome) {
        this.nome = nome;
        this.schede = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiScheda(Scheda scheda) {
        this.schede.add(scheda);
    }

    public ArrayList<Scheda> getSchede() {
        return schede;
    }
}