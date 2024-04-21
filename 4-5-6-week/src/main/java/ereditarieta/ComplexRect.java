package ereditarieta;

public class ComplexRect extends Complex{
    protected double re;
    protected double im;

    public ComplexRect(double re, double im)
    {
        this.re=re;
        this.im=im;
    }

    @Override
    public double re() {
        return re;
    }

    @Override
    public double im() {
        return im;
    }

    @Override
    public double mod() {
        return Math.sqrt(re*re+im*im);
    }

    @Override
    public double fase() {
        return Math.atan(im / re);
    }

  
    
}
