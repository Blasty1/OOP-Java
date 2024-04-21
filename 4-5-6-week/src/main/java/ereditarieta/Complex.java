package ereditarieta;

//ha senso che sia una classe e non un interfaccia perchè abbiamo dei metodi
public abstract class Complex extends Number implements Comparable<Complex>{
    public abstract double re();
    public abstract double im();
    public abstract double mod();
    public abstract double fase();

    // seconda versione più compatta e usando i generics
    @Override
    public int compareTo(Complex obj)
    {
        return Double.compare(mod(), obj.mod());
    }

    // @Override
    // public int compareTo(Object obj)
    // {
    //     double questo_mod = this.mod();
    //     double altro_mod = ((Complex) obj).mod();

    //     if(questo_mod < altro_mod) return -1;
    //     if(questo_mod > altro_mod) return 1;
    //     return 0;

    // }
    @Override
    public double doubleValue() {
       return this.re();
    }

    @Override
    public float floatValue() {
        return (float) this.re();
    }
    @Override
    public String toString()
    {
        return "(" + this.re() + " + " + this.im() +"i)";
    }

    @Override
    public int intValue() {
        return (int) this.re();
    }

    @Override
    public long longValue() {
        return (long)this.re();
    }
}

// public interface Complex {
//     public abstract double re();
//     public abstract double im();
//     public abstract double mod();
//     public abstract double fase();
// }
