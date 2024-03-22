package ereditarieta;

public class EsempioConversioni {
    public static void main(String[] args)
    {
        //unico modo per gestire un array di tipi numerici differenti
        //con le classi wrap posso fare una cosa di questo tipo mentre con i tipi primitivi non mi è concesso.
        Number[] numeri={1,3.14,42}; //dietro c'è nascosto l'autoboxing (diventeranno oggetti delle rispettiva wrapping class)
        int acc=0;
        for(Number n : numeri)
        {
           // Integer i = n --> questa conversione non funziona
           //Integer i = (Integer)n; //esempio di downcast --> in questo caso errore perchè il riferimento sta puntando ad un tipo double ( nel caso di 3.14 )
           //Soluzione safe a downcast
           if( n instanceof Integer )
           {
                Integer i = (Integer)n;
                acc += i; //l'errore viene scoperto run-time , il down cast non è sicuro

           }
           

        }
        System.err.println();
    }
    
}
