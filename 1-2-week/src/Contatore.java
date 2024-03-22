public class Contatore {

    private int val;

    public Contatore()
    {
        this.val=0;
    }
    public Contatore inc() {
        this.val++;
        return this;
    }

    public int valore() {
        return this.val;
    }

    public Contatore dec() {
       this.val--;
       return this;
    }

}
