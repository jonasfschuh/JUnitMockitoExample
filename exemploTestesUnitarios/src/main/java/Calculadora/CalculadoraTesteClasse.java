package Calculadora;

/**
 *
 * @author 310173751
 */
public class CalculadoraTesteClasse {
    
    public static void main(String[] args) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Incializando a classe Calculadora...");
        
        Calculadora calculadora = new Calculadora();
        calculadora.exibirMensagem("Teste");
        
        calculadora.valor1 = 1L;
        calculadora.valor2 = 2L;
        calculadora.somarValores();
        
        System.out.println("Resultado é: " + calculadora.resultado);
        
        System.out.println("\n------------------------------------------------------------------------");
    }
    
}
