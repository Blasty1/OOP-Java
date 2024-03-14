package carsharing;

public class Posto {
    static final char ANTERIORE = 'A';
    static final char POSTERIORE = 'P';
    
    enum Lato {
        SX,CENTRO,DX
    }

    private char posizione;
    private Lato lato;
    private boolean conducente = false;

    String nomePasseggero;
    boolean occupato;
 
    /**
     * Serve per prenotare il posto a nome di un passeggero 
     * @param passegero il nome del passeggero
     */
    public void prenota(String passegero)
    {
        this.nomePasseggero = passegero;
        this.occupato = true;
    }

    /**
     * Costruttore
     * @param lato
     * @param posizione
     * @param conducente
     */
    public Posto(Lato lato, char posizione, boolean conducente)
    {
        this.lato=lato;
        this.posizione=posizione;
        this.conducente=conducente;
    }

    //Esempio di Overloading
      /**
     * Costruttore
     * @param lato
     * @param posizione
     * 
     */
    public Posto(Lato lato, char posizione)
    {
        this.lato=lato;
        this.posizione=posizione;
        this.conducente=false;
    }
     /**
     * ritorna se è occupato o meno
     * @deprecated 
     * 
     */
    public boolean eOccupato()
    {
        return this.occupato;
    }

    /*
     * METODI GETTER
     */
    public Lato getLato()
    {
        return this.lato;
    }
    public char getPosizione()
    {
        return this.posizione;
    }
    public boolean getConducente()
    {
        return this.conducente;
    }
    /*
     * FINE METODI GETTER
    */

    public String descrivi()
    {
        String desc = new String();

        desc = ( this.posizione == Posto.ANTERIORE ? "Anteriore " : "Posteriore " );
        

        switch(this.lato)
        {
            case SX: desc+="Sinistra "; 
                break;
            case DX: desc+="Destra ";
                break;
            case CENTRO: desc+="Centro ";
                break;
        }

        if (this.conducente )
        {
            desc += "(conducente)";
        }
        return desc;
    }


}
