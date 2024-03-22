public class EsChain {

    public static void main(String[] args)
    {
        //approccio TDD: Test-Driven-Development

        Contatore c = new Contatore();
        c.inc();
        verifica(c.valore() == 1,"mi aspettavo 1");

        c.dec();
        verifica(c.valore() == 0,"mi aspettavo 0");

        c.inc().dec().inc().inc();
        verifica(c.valore() == 2,"mi aspettavo 2");


    }

    public static void verifica(boolean b,String msg)
    {
        if(b)
        {
            System.out.println(".");
        }else{
            System.out.println("ERRORE: " + msg);
        }
    }
}
