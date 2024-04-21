package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.polito.po2024.esempi.lista.ListaUniversale;
import it.polito.po2024.esempi.lista.ListaUniversale.Iteratore;

public class TestListaUniversale {
    @Test
    public void testLista()
    {
        ListaUniversale<Integer> l = new ListaUniversale<Integer>();

        l.aggiungi(3);
        //l.aggiungi("tre");
        l.aggiungi(4);

        ListaUniversale<Integer>.Iteratore it = l.iteratore();
        int somma=0;
        while(it.esisteProssimo())
        {
            somma += it.prossimo();
        }
        assertEquals(somma,7);
        assertTrue(l.contiene(Integer.valueOf(3)));

    }


    @Test
    public void testTipiEterogenei()
    {
        ListaUniversale l = new ListaUniversale();

        l.aggiungi(3);
        l.aggiungi("tre");
        l.aggiungi(4);

        Iteratore it = l.iteratore();
        int somma=0;
        while(it.esisteProssimo())
        {
            Integer i = (Integer)it.prossimo(); //down-cast pericoloso che mi complinca anche la scrittura del codice
            somma += i;
        }


    }
    @Test
    public void testForEach()
    {
        ListaUniversale<Integer> l = new ListaUniversale<>();

        l.aggiungi(1);
        l.aggiungi(2);
        l.aggiungi(3);

        int somma = 0;
      for(Integer i : l )
      {
        somma += i;
      }
      assertEquals(somma, 6);


    }

    @Test
    public void testInvarianza()
    {
        ListaUniversale<Integer> l1 = new ListaUniversale<>();
        ListaUniversale<?> l2 = new ListaUniversale<>(); //wildcard

        l2= l1; //non posso scriverlo, me lo impedisce


        Integer[] ai = {1,2,3,5,8};
        Number[] an;

        an = ai; //posso scriverlo

    }


}
