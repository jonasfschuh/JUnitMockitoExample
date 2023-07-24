package Carro;

/**
 *
 * @author Jonas Fernando Schuh
 */
public class Combustivel {
    
    String tipo;
    
    public Combustivel(String tipo) {
        this.tipo = tipo;
    }
    
    public static void main(String[] args) {
        Combustivel combustivel = new Combustivel("Gasolina");
        System.out.println("\n-------------------------------------------------------");
        System.out.println("O tipo de ocmbustivel e: " + combustivel.tipo);
        System.out.println("\n-------------------------------------------------------");
    }
    
}
