package abstractInterfejsy;

public class Prostokat extends Figura{
    public double a, b;

    @Override
    public double Pole() {
        return a*b;
    }

    @Override
     public double Obwod() {
        return (2*a)+(2*b);
    }
}
