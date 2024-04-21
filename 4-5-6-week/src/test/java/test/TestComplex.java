package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import ereditarieta.ComparatoreComplexParteReale;
import ereditarieta.Complex;
import ereditarieta.ComplexRect;

public class TestComplex {

    @Test
    public void testRe()
    {
        Number n= new ComplexRect(2,1);
        assertEquals(2, n.intValue());
    }

    @Test
    public void testString()
    {
        Number n= new ComplexRect(2,1);

        assertEquals("(2.0 + 1.0i)", n.toString());
    }


    @Test
    public void testSorting()
    {
        ComplexRect []arr = {
            new ComplexRect(2,2),
            new ComplexRect(0,10),
            new ComplexRect(1,1)
        };

        Comparator comparatore = new ComparatoreComplexParteReale(); //porta solo il comportamento e non dati
        
        Arrays.sort(arr,comparatore); //errore per il cast in Comparable --> è necessario che ComplexRect implementi l'interfaccia comparable.

        assertEquals(0.0,arr[0].re(),0.01);
        assertEquals(1.0,arr[1].re(),0.01);
        assertEquals(2.0,arr[2].re(),0.01);
    }

    //stesso esempio ma con la classe anonima, evitando di creare ogni volta una nuova classe fine a se stessa.
    @SuppressWarnings("unchecked")
    @Test
    public void testSorting2()
    {
        ComplexRect []arr = {
            new ComplexRect(2,2),
            new ComplexRect(0,10),
            new ComplexRect(1,1)
        };

        //classe anonima
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object arg0, Object arg1) {
                double re1=((Complex) arg0).re();
                double re2=((Complex) arg1).re();

                if (re1 < re2) return -1;
                if( re1 > re2 ) return 1;
                return 0;
            }
        }); //errore per il cast in Comparable --> è necessario che ComplexRect implementi l'interfaccia comparable.

        assertEquals(0.0,arr[0].re(),0.01);
        assertEquals(1.0,arr[1].re(),0.01);
        assertEquals(2.0,arr[2].re(),0.01);
    }


  //stesso esempio ma con la classe anonima scritta usando la lambda expression

  @Test
  public void testSorting3()
  {
      ComplexRect []arr = {
          new ComplexRect(2,2),
          new ComplexRect(0,10),
          new ComplexRect(1,1)
      };
      //lambda expression
      Arrays.sort(arr,(arg0, arg1) -> {
        double re1=((Complex) arg0).re();
        double re2=((Complex) arg1).re();

        if (re1 < re2) return -1;
        if( re1 > re2 ) return 1;
        return 0;
    });

      assertEquals(0.0,arr[0].re(),0.01);
      assertEquals(1.0,arr[1].re(),0.01);
      assertEquals(2.0,arr[2].re(),0.01);
  }

  @Test
  public void testSorting4()
  {
      ComplexRect []arr = {
          new ComplexRect(2,2),
          new ComplexRect(0,10),
          new ComplexRect(1,1)
      };
      //lambda expression
      //comparing richiede una funzione che estrae dal parametro (oggetto complesso ) un attributo che viene utilizzato per il confronto.
      Arrays.sort(arr,Comparator.comparing((Complex c) -> c.re() ).thenComparing(((Complex c) -> c.im()))); //autoboxing --> il double diventerà un oggetto wrapper associato a double

      assertEquals(0.0,arr[0].re(),0.01);
      assertEquals(1.0,arr[1].re(),0.01);
      assertEquals(2.0,arr[2].re(),0.01);
  }


  @Test
  public void testSorting5()
  {
      ComplexRect []arr = {
          new ComplexRect(2,2),
          new ComplexRect(0,10),
          new ComplexRect(1,1)
      };
      //method reference 
      Arrays.sort(arr,Comparator.comparing(Complex::re)); 
      //è uguale a Arrays.sort(arr,Comparator.comparing((r) -> r.re())); 


      assertEquals(0.0,arr[0].re(),0.01);
      assertEquals(1.0,arr[1].re(),0.01);
      assertEquals(2.0,arr[2].re(),0.01);
  }
}