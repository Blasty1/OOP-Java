public class ExampleWrapper {
    public static void main(String[] args)
    {
        // i blocchi{} hanno due scope diversi
        {
            long t0=System.currentTimeMillis();
            int acc=0;

            for(int i=0; i < 1000000; ++i)
            {
                acc +=i;
            }

            System.out.println(acc);
            long t1=System.currentTimeMillis();
            System.out.println("Elapsed: "+(t1-t0));
        }
        {

            long t0=System.currentTimeMillis();
            Integer acc=0;

            for(Integer i=0; i < 1000000; ++i)
            {
                acc +=i; //la conversione è automatica, non esistono le somme tra Integer ma solo tra int
            }

            System.out.println(acc);
            long t1=System.currentTimeMillis();
            System.out.println("Elapsed: "+(t1-t0));
        }


    }
}
