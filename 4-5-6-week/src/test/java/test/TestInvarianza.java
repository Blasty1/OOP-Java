package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TestInvarianza {
    @Test
    public void testCoVarianza()
    {
        Integer[] numeri={1,2,3};
        Object[] oggetti;

        oggetti = numeri;// gli array sono co-varianti
        //non ci da errore ma in realtà è sbagliato
        assertThrows(ArrayStoreException.class,() -> { oggetti[1] = "test"; });
        // nomeClase.class ci permette di fare un operazione di reflection : la capacità di un programma di ragionare su se stesso ( il programma è in grado di ispezionare anche il codice )
        //ritorna un contenitore in cui si ha la descrizione della classe.
    }

    @Test
    public void testReflection()
    {
        String s = "test";
        Object o = s;
        Class c = o.getClass(); //dato un oggetto ottengo il descrittore della classe
        //posso andare ad esaminare il contenuto di una classe
        // c.getMethods() --> ottengo i metodi
        // c.getFields() --> ottengo gli attributi
        String nomeClasse = c.getName();


        //un altro modo per ottenere il descrittore della classe è partire dal nome della classe
        Class c2 = String.class; //.class è come se fosse un attributo statico presente in tutte le classi

        assertEquals(nomeClasse, "java.lang.String");
    }
}
