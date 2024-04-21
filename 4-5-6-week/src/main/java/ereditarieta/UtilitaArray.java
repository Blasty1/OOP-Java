package ereditarieta;

public class UtilitaArray{
    // cancellare un elemento da un array e restituirlo
    public static <T> T remove(T[] arr, Object el)
    {
        for(int i=0; i < arr.length ; i++)
        {
            if(arr[i].equals(el))
            {
                T canc = arr[i];
                arr[i] = null;
                return canc;
            }
        }
        return null;
    }

    //Bounded type --> posso sostituire T solo con tipi che implementano l'interfaccia comparable
    public static <T extends Comparable<T> > T max(T[] arr)
    {
       T max = null;
       for( T current : arr)
       {
            //l'idea è di voler mettere un vincolo sui tipi T --> devono implementare Comparable e per farlo (vedere sopra )
            if( max == null || max.compareTo(current) < 0 )
            {
                max = current;
            }
       }
       return max;
    }
}
