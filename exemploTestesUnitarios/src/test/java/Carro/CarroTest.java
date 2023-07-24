/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Carro;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Jonas Fernando Schuh
 */
public class CarroTest {
    
    public CarroTest() {
    }
    
    @Test
    public void testMain() {        
        System.out.println("Incializando " + this.getClass().getSimpleName());        
    }
    
    @Test
    public void testOdometroCarro() {        
        Carro car = new Carro("Opala", new Combustivel("Gasolina"));
        
        System.out.println("Classe real. Tipo de combustível é: " + car.combustivel.tipo + " classe " + car.combustivel.getClass().getSimpleName());
        
        car.andar(200L);
        car.andar(50L);
        
        //assertTrue(250L == car.odometro.longValue());                
        assertEquals(250L, car.odometro.longValue());
    }
    
    
    @Test
    /*
    https://medium.com/cwi-software/testando-seu-c%C3%B3digo-java-com-o-mockito-framework-8bea7287460a
    
    Mock: cria uma instancia de uma classe, porém Mockada. 
        Se você chamar um metodo ele não irá chamar o metodo real, a não ser que você queira.
    Spy: cria uma instancia de uma classe, que você pode mockar ou chamar os metodos reais. 
        É uma alternativa ao InjectMocks, quando é preciso mockar metodos da propria classe que esta sendo testada.
    InjectMocks: criar uma intancia e injeta as dependências necessárias que estão anotadas com @Mock.
    Verify: verifica a quantidade de vezes e quais parametros utilizados para acessar um determinado metodo.
    When: Após um mock ser criado, você pode direcionar um retorno para um metodo dado um paremetro de entrada.
    Given: Mesmo propósito que o when, porém é utilizado para BDD. Fazendo parte do BDDMockito.
    
    // Exemplo 1 - Mock
    
    */
    public void testOdometroCarroMockCombustivel() {        
        
        Combustivel combMock = mock(Combustivel.class);
        combMock.tipo = "Diesel";
        
        Carro car = new Carro("Opala", combMock);
        
        System.out.println("Classe real. Tipo de combustível é: " + car.combustivel.tipo + " classe " + car.combustivel.getClass().getSimpleName());
        
        car.andar(200L);
        car.andar(50L);
        
        //assertTrue(250L == car.odometro.longValue());                
        assertEquals(250L, car.odometro.longValue());
    }
    
    /*
    
    Exemplo 2 - Mock When 
    
    Nesse exemplo abaixo, criei um mock() da classe Carro para testar o 
        comportamento do metodo amdar. Evidentemente, eu terei um resultado positivo, 
        independente do valor que eu passar para ser validado. Isso ocorre porque eu utilizei o when().
    
    */
    @Test
    public void testOdometroCarroMockWhen() {        
        
        Carro car = mock(Carro.class);
        System.out.println("Classe:  " + car.getClass().getSimpleName());        
        if (car.combustivel == null) {
            System.out.println("Classe combustível não está instanciada na classe ");
        } else {
            System.out.println("Classe combustível está instanciada na classe ");
        }
        
        car.combustivel = new Combustivel("Metanol");
        
        System.out.println("Classe:  " + car.combustivel.getClass().getSimpleName());        
        System.out.println("Classe real. Tipo de combustível é: " + car.combustivel.tipo + " classe " + car.combustivel.getClass().getSimpleName());
        
        when(car.andar(0L)).thenReturn(true);
        assertTrue(car.andar(0L));
    }
    
    /*
           Caso 2 When 
    Agora, se eu chamar o metodo real, utilizando o thenCallRealMethod() 
        do Mockito, o teste falha. Porque o 0 informado é inválido, 
       e o meu teste passou pelo metodo andar() de fato.
    
    */
    @Test
    public void testOdometroCarroMockWhenCaso2() {        
        
        Carro car = mock(Carro.class);
        System.out.println("Classe:  " + car.getClass().getSimpleName());        
        if (car.combustivel == null) {
            System.out.println("Classe combustível não está instanciada na classe ");
        } else {
            System.out.println("Classe combustível está instanciada na classe ");
        }
        
        car.combustivel = new Combustivel("Querosene");
        
        System.out.println("Classe:  " + car.combustivel.getClass().getSimpleName());        
        System.out.println("Classe real. Tipo de combustível é: " + car.combustivel.tipo + " classe " + car.combustivel.getClass().getSimpleName());
        
        when(car.andar(0L)).thenCallRealMethod();
        assertFalse(car.andar(0L));
    }
    
    /*
       https://dev.to/daienelima/mockito-como-utilizar-de-maneira-simples-4h86
    
       Exemplo 3 - Spy
    
        Usamos o @Spy para espionar uma instância existente.
        No exemplo abaixo eu adicionei dois elementos a uma lista e em seguida 
        verifiquei se os elementos foram mesmo inseridos.
    
        Com o Spy, posso alterar um método, e "emular" outro valor.
            No caso carros.size() para retornar 5 em vez de 2 usando Mockito.doReturn()
    
    */
    
    @Test
    public void spyTest() {
        List<Carro> carros = Mockito.spy(new ArrayList<>());
        Carro carro1 = new Carro("Fusca", new Combustivel("Gasolina"));
        Carro carro2 = new Carro("Brasilia", new Combustivel("Alcool"));
        
        carros.add(carro1);
        carros.add(carro2);
        assertEquals(2, carros.size());
        

        Mockito.doReturn(5).when(carros).size();
        assertEquals(5, carros.size());
    }
    
}
