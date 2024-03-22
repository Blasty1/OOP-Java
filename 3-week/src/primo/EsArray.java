package primo;

import java.util.Arrays;

public class EsArray {
    public static void main(String[] args)
    {
        int []v={1,2,0,10,3,5};

        int i=v[0];
        for(int j=0; j < v.length; j++)
        {
            System.out.println("Elemento v[" + j +"] = "+ v[j]);
        }
        System.out.println(v); // --> [I@36baf30c --> codifica interna per dire che è un array di interi ( [I ) --> quello che segue dopo la @ è un identificativo unico (hash code) per l'array 
        System.out.println(Arrays.toString(v)); //per stampare l'array
        Arrays.sort(v);
        System.out.println(Arrays.toString(v)); //per stampare l'array

        double[][] matrice; // array di un array di Double

        matrice= new double[2][2];

        matrice[0][0] = 5;

        System.err.println(Arrays.toString(matrice[0]) + '\n' + Arrays.toString(matrice[1]));

        matrice[0] = new double[10];
        matrice[1] = new double[2];
        double riga[] = matrice[0];
        if( riga == matrice[0])
        {
            System.err.println("TESTTTT");
        }
        System.err.println(Arrays.toString(matrice[0]) + '\n' + Arrays.toString(matrice[1]));

    }
}
