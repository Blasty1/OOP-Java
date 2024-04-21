package ereditarieta;
import java.util.Comparator;

//è una classe che non ha attributi 
public class ComparatoreComplexParteReale implements Comparator{

    @Override
    public int compare(Object arg0, Object arg1) {
        double re1=((Complex) arg0).re();
        double re2=((Complex) arg1).re();

        if (re1 < re2) return -1;
        if( re1 > re2 ) return 1;
        return 0;
    }

}