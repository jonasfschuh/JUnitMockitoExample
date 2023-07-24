/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CalculadoraTest;

import Calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 310173751
 */
public class CalculadoraTestJCS {
    
    public CalculadoraTestJCS() {
    }
   
    @Test
    public void testarSeJulioEhGremista() {
        Boolean ehGremista = false;
        
        //Assert.assertTrue(ehGremista);        
        Assert.assertFalse(ehGremista);        
    }
    
    @Test
    public void testarSeJulioEhColorado() {
        //
        Boolean ehColorado = true;
        
        Assert.assertTrue(ehColorado);
    }
    
    
    @Test
    public void testarSomaCalculadora() {
        //
        Calculadora calculadora = new Calculadora();
        calculadora.valor1 = 7L;
        calculadora.valor2 = 20L;
        calculadora.somarValores();
        
        Long resultadoEsperado = 27L;
        
        //Assert.assertTrue(resultadoEsperado == calculadora.resultado);
        Assert.assertEquals(resultadoEsperado, calculadora.resultado);
    }
    
    
    
}
