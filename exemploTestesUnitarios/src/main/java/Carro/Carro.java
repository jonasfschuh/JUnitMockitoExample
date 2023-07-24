package Carro;

/**
 *
 * @author Jonas Fernnado Schuh
 */
public class Carro {
    
    String modelo;
    Combustivel combustivel;
    Long odometro;
    
    public Carro(String modelo, Combustivel combustivel) {
        this.modelo = modelo;
        this.combustivel = combustivel;
        odometro = 0L;
    }
    
    public Boolean andar(Long distancia) {
        if (distancia > 0L) {
            odometro += distancia;
            System.out.println("Carro andou " + distancia + " metros;");
            return true;
        } 
        return false;
    }
    
    public static void main(String[] args) {
        Carro carro = new Carro("Chevette", new Combustivel("Alcool"));
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Modelo do carro é: " + carro.modelo + " e o combustivel e: " + carro.combustivel.tipo);
        carro.andar(10L);
        carro.andar(15L);
        System.out.println("Odometro atual do carro: " + carro.odometro + " metros.");
        System.out.println("\n-------------------------------------------------------");
    }
}
