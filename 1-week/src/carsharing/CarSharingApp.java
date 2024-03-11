package carsharing;

public class CarSharingApp {
    public static void main(String[] args)
    {
        int i=0;

        Posto p = new Posto(Posto.Lato.SX,Posto.ANTERIORE,true);
        System.out.println("Occupato: " + p.eOccupato());

        p.prenota("Bruno");

        System.out.println(p.descrivi());

        // approccio C, chi usa la libreria deve conoscere i dettagli interni
        // p.lato=Posto.SX;
        // p.posizione=Posto.ANTERIORE;
        // p.conducente=true;
        System.out.println("Occupato: " + p.eOccupato());
    }
}
