package src.carsharing;

import src.carsharing.Posto.Lato;

public class Tragitto {
    private String da;
    private String a;
    private Ora oraPartenza;
    private Ora oraArrivo;

    // due modi
    // Posto posti[];
    Posto[] posti; // punta un array di qualuque dimensione

    public Tragitto(String a, String da, int h0, int m0, int h1, int m1)
    {
        this.da = da;
        this.a = a;
        oraPartenza = new Ora(h0, m0);
        oraArrivo = new Ora(h1, m1);

        posti = new Posto[5]; //sono inizializzati a null
        char [] posizioni= {'A' , 'A' , 'P' ,'P','P'}; //static initialiazer --> A = anteriore e P = posteriore
        Lato[] lati = {Lato.SINISTRO , Lato.DX , Lato.SINISTRO, Lato.CENTRO , Lato.DX};
        boolean[] cond={true,false,false,false,false};
        for(int i=0; i < posti.length; i++)
        {
            posti[i]=new Posto(posizioni[i], lati[i],cond[i]);
        }

        //in alternativo , quando abbiamo già inizializzato posto --> versione leggermenta diversa dello static initialiazer
        //static initializer (not with declaration)
        posti=new Posto[]{
            new Posto('A', Lato.SINISTRO,true),
            new Posto('P', Lato.DX),
            new Posto('P', Lato.SINISTRO),
            new Posto('P', Lato.CENTRO),
            new Posto('A', Lato.DX),
        };
    }

    public int durata()
    {
        return oraArrivo.differenzaMinuti(oraPartenza);
    }

    /**
     * il passeggero viene prenotato sul primo posto disponibile 
     * per il tragitto ( ammesso che ci sia )
     * @param nomePasseggero
     * @return true se è riuscito a trovare il posto
     */
    public boolean prenota(String nomePasseggero)
    {
        for(int i=0; i < posti.length; i++)
        {
            if(! posti[i].eOccupato() )
            {
                posti[i].prenota(nomePasseggero);
                return true;
            }
        }

        // alternativa for each
        for(Posto p : posti)
        {
            if(! p.eOccupato() )
            {
                p.prenota(nomePasseggero);
                return true;
            }
        }
        return false;
    }


    //----------------------------
    // class Ora{     //è una inner class --> ha il riferimento all'oggetto contenitore
    static class Ora{ //Nested class ( non ha legami con la classe contenitore )

        int ore;
        int minuti;
        public Ora(int h, int m)
        {
            this.ore = h;
            this.minuti = m;
        }

        public String toString()
        {
            return this.ore + ":" + this.minuti;
        }

        public int differenzaMinuti(Ora altra)
        {
            return this.ore*60+this.minuti - altra.ore*60 - altra.minuti;
        }

        public int durata()
        {
            //l'oggetto interno ha una visibilità su quello esterno.
            return this.ore*60+this.minuti - ( oraPartenza.ore*60 + oraPartenza.minuti );
        }
    }   
}
