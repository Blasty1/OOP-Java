package it.polito.po2024.esempi.lista;

import java.util.Iterator;

//è un parametro di tipo della class
public class ListaUniversale<E> implements Iterable<E>{
    private static final boolean DEEP_EQUALS=false;
    protected class Elemento {
        public Elemento(E i) {
            valore = i;
            next = testa;  // funziona perchè siamo in una INNER CLASS
        }
        E valore;
        Elemento next;
    }
    protected Elemento testa;
    protected int dimensione;
    protected Elemento current;

    public int dimensione() {
        return dimensione;
    }
    // in C invece di int potrei usare void*
    public void aggiungi(E i) {
        testa = new Elemento(i);
        dimensione++;
    }

    public E primo() {
        this.current = testa;
        return testa.valore;
    }

    public E prossimo() {
        current = current.next;
        return current.valore;
    }

    public boolean fine() {
        return current.next==null;
   }

   public class Iteratore { // inner class 
        private Elemento prossimo = testa;

        public Iteratore(){
            this.prossimo = testa;
        }

        public boolean esisteProssimo() {
            return prossimo != null;
        }

        public E prossimo() {
            E valore = prossimo.valore;
            prossimo = prossimo.next;
            return valore;
        }

    }

public Iteratore iteratore() {
    return new Iteratore();
}
public boolean contiene(E el) {
   
    Iteratore it = iteratore();
        
    while(it.esisteProssimo())
    {
        if(it.prossimo().equals(el))
        {
            return true;
        }
    }
    return false;

}

@Override
public boolean equals(Object o)
{
    if(o instanceof ListaUniversale l)
    {
        // ListaUniversale l = (ListaUniversale) o;

        if(l.dimensione == this.dimensione)
        {
            Iteratore mio = iteratore();
            Iteratore suo = l.iteratore();
            
         
            while(mio.esisteProssimo())
            {
                if(DEEP_EQUALS)
                {
                    //DEEP EQUALS
                    if(!mio.prossimo().equals(suo.prossimo()))
                    {
                        return false;
                    }
                
                }else
                {
                    //SHALLOW EQUALS
                    if(mio.prossimo() != suo.prossimo())
                    {
                        return false;
                    }
                }
               
            }

            return true;
            ///////////////////

            



        }

        return false;
    }

    return false;

}

// no lamba expression ( iterator non è un interfaccia funzionale ) ma usiamo direttamente una classe anonima
@Override
public Iterator<E> iterator()
{
    return new Iterator<E>(){
        private Elemento prossimo = testa;

        @Override
        public boolean hasNext() {
            return prossimo != null;
        }

        @Override
        public E next() {
            E valore = prossimo.valore;
            prossimo = prossimo.next;
            return valore;
        }

    };
}
}