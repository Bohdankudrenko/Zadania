package Zadanie2;

public class Wieloryb extends Ryba{
    @Override
    public void jedz() {
        System.out.println("Wieloryb zjada plankton.");
    }

    @Override
    public void plyn() {
        System.out.println("Wieloryb płynie przez ocean.");
    }

    @Override
    public void wynurz() {
        System.out.println("Wieloryb wynurza się z wody.");
    }

    @Override
    public void zanurz() {
        System.out.println("Wieloryb zanurza się pod wodę.");
    }

    @Override
    public void wydalaj() {
        System.out.println("Wieloryb wydala resztki pokarmowe.");
    }
}