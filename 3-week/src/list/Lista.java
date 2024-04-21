package src.list;

public class Lista {
    public static void main(String[] args)
    {
        System.out.println("Test 1");
        String test="bruno";
        test.toUpperCase();
        String output = String.format("\n%b %s %d %5.1f", false , "stringa",5,1.46);
        System.out.println(test + " " + test.toUpperCase() + output);
        System.out.println(Lista.sum(9,2,3,4,5,1,3,2));
    }

    public static enum Bar{
        BarBivio, BarRosanna, BarTest2
    }

    public static int sum(int ... numeri)
    {
        int tot=0;
        for(int numero : numeri)
        {
            tot += numero;
        }

        return tot;
    }
}
