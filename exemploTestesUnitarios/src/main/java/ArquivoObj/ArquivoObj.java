/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ArquivoObj;

import Arquivo.Arquivo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas Fernando Schuh
 */
public class ArquivoObj {

    String caminhoArquivo = null;    
    PrintWriter gravarArq = null;
    FileWriter arq = null;
    
    public ArquivoObj(String caminho) {
        caminhoArquivo = caminho;
    }
    
    public void criar() {
        try {
            arq = new FileWriter(caminhoArquivo);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        gravarArq = new PrintWriter(arq);
    }
    
    public void Salvar() {    
        int i; 
        int n = 7;        

        gravarArq.printf("+--Resultado--+%n");
        for (i=1; i<=10; i++) {
          gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
        }
        gravarArq.printf("+-------------+%n");

        try {
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void main(String[] args) {        
        ArquivoObj arquivoObj = new ArquivoObj("c:\\temp\\testeArquivo.txt");
        arquivoObj.criar();
        arquivoObj.Salvar();
    }
}
