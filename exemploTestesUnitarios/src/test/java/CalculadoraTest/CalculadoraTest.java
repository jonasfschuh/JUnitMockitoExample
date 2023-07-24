package CalculadoraTest;

import Calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 310173751
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void hello() {
         System.out.println("teste classe teste");
     }
     
    @Test
     public void testarResultadoSomaCalculadora() {
         System.out.println("testarResultadoSomaCalculadora...");
         
         Calculadora calc = new Calculadora();
         calc.valor1 = 1L;
         calc.valor2 = 2L;
         calc.somarValores();
         
         System.out.println("Teste - resultado é: " + calc.resultado);
         
         // resultado esperado é 3.
         Long resultadoEsperado = 3L;
         //Assert.assertTrue(calc.resultado == 3L);         
         Assert.assertEquals(calc.resultado, resultadoEsperado);
     }

    @Test
     public void testarResultadoErro() {
         System.out.println("testarResultadoSomaCalculadora...");
         
         Calculadora calc = new Calculadora();
         calc.valor1 = 1L;
         calc.valor2 = 3L;
         calc.somarValores();
         
         System.out.println("Teste - resultado é: " + calc.resultado);
         
         // resultado esperado é 3.
         Assert.assertTrue(calc.resultado == 3L);
     }
     
     
}
