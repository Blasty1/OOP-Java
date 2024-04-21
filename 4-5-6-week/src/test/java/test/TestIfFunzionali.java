package test;

import java.util.function.IntSupplier;

import org.junit.Test;

import ereditarieta.EsempiIfFunzional;

public class TestIfFunzionali {
 
    @Test 
    public void testGeneratore()
    {
        int[] ultimi = {1,1};

        //fibonacci
        IntSupplier generatore1 = new IntSupplier() {
            //posso far riferimento all'array ultimi perchè è una classe anonima locale.
            @Override
            public int getAsInt()
            {
                int risultato = ultimi[0];
                int prossimo = ultimi[0] + ultimi[1];

                ultimi[0] = ultimi[1];
                ultimi[1] = prossimo;

                return risultato;
            }
        };


        //possiamo usare anche la lambda extension 
        IntSupplier generatore2 =() -> {
                int risultato = ultimi[0];
                int prossimo = ultimi[0] + ultimi[1];

                ultimi[0] = ultimi[1];
                ultimi[1] = prossimo;

                return risultato;
        };

        IntSupplier gen = EsempiIfFunzional.fibonacci();
        for(int i=0; i < 5 ; i++)
        {
            System.out.println(gen.getAsInt());
        }
    }

    @Test 
    public void testGeneratoreGeneralizzato()
    {
        //equivale a (a,b) -> { return a+b; }
        IntSupplier gen = EsempiIfFunzional.fibonacciGeneralizzato((a,b) -> a+b);
        for(int i=0; i < 5 ; i++)
        {
            System.out.println(gen.getAsInt());
        }

    }

    static int somma(int a, int b)
    {
        return a+b;
    }

    //method reference
    @Test 
    public void testGeneratoreGeneralizzato2()
    {
        //equivale a (a,b) -> { return a+b; }
        IntSupplier gen = EsempiIfFunzional.fibonacciGeneralizzato(TestIfFunzionali::somma);
        for(int i=0; i < 5 ; i++)
        {
            System.out.println(gen.getAsInt());
        }

    }
}
