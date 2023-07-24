/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

/**
 *
 * @author 310173751
 */
public class Calculadora {
    
    public Long valor1;
    public Long valor2;
    public Long resultado;
    
    // construtor da classe 
    public Calculadora() {        
        this.valor1 = 0L;
        this.valor2 = 0L;
        this.resultado = 0L;
    };
    
    public void somarValores() {
        resultado = valor1 + valor2;        
    }
    
    public void exibirMensagem(String msg) {
        System.out.println("Dentro da classe Calculadora: " + msg);
    }
}
