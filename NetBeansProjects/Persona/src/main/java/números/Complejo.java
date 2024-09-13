package números;

/**
 *
 * @author Mondongo
 */
public class Complejo {
    private double real;
    private double imag;

    public Complejo() {
        this.real = 0;
        this.imag = 0;
    }

    public Complejo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double consulta_Real() {
        return this.real;
    }

    public double consulta_Imag() {
        return this.imag;
    }

    public void cambia_Real(double real) {
        this.real = real;
    }

    public void cambia_Imag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imag + "i";
    }

    public void sumar(Complejo b) {
        this.real += b.consulta_Real();
        this.imag += b.consulta_Imag();
    }

    public static void main(String[] args) {
        Complejo numero1 = new Complejo();
        System.out.println("Número complejo 1 (inicializado a 0): " + numero1.toString());

        Complejo numero2 = new Complejo(3, 4);
        System.out.println("Número complejo 2: " + numero2.toString());

        numero1.cambia_Real(5);
        numero1.cambia_Imag(2);
        System.out.println("Número complejo 1 (modificado): " + numero1.toString());

        numero1.sumar(numero2);
        System.out.println("Suma de numero1 y numero2: " + numero1.toString());
    }
}

