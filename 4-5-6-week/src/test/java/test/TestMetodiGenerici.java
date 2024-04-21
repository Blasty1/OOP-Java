package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static ereditarieta.UtilitaArray.*;
public class TestMetodiGenerici {
    @Test
    public void testRimuovi()
    {
        Integer[] interi = {1,1,2,3,5,8,13,21,34};
        //senza l'uso dei generics
        //Integer rimosso =(Integer)remove(interi,13); 

        //con l'uso dei generics
        int rimosso2 = remove(interi,21);  //fa l'autoboxing

        assertEquals(21, rimosso2);

    }
    @Test
    public void testMax()
    {
        Integer[] interi = {1,1,2,3,5,8,13,21,34};
    
        int max_got = max(interi);
        assertEquals(34, max_got);

    }
}
