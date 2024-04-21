package ereditarieta;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

public class EsempiIfFunzional {
    //factory method ( metodo fabbrica ) che resistuisce un generatore di numeri di fibonacci
    public static IntSupplier fibonacci()
    {
        int[] ultimi = {1,1};
        return () -> {
            int risultato = ultimi[0];
            int prossimo = ultimi[0] + ultimi[1];

            ultimi[0] = ultimi[1];
            ultimi[1] = prossimo;

            return risultato;
        };
    }  
  

    //la somma diventa un operazione qualsiasi --> uso un intBinaryOperator
    public static IntSupplier fibonacciGeneralizzato(IntBinaryOperator operatore)
    {
        int[] ultimi = {1,1};
        return () -> {
            int risultato = ultimi[0];
            int prossimo = operatore.applyAsInt(ultimi[0], ultimi[1]);

            ultimi[0] = ultimi[1];
            ultimi[1] = prossimo;

            return risultato;
        };
    } 

    public static Comparator confrontoTra(Function estrattore)
    {
        return (o1,o2) -> {
            Object chiave1 = estrattore.apply(o1);
            Object chiave2 = estrattore.apply(o2);
            return ((Comparable)chiave1).compareTo(chiave2);
        };
    }
}
