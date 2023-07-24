/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas Fernando Schuh
 */
public class Arquivo {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int i, n;
        String caminhoArquivo = "c:\\temp\\testeArquivo.txt";

        //System.out.printf("Informe o número para a tabuada:\n");
        //n = ler.nextInt();
        n = 7;

        FileWriter arq = null;
        try {
            arq = new FileWriter(caminhoArquivo);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravarArq = new PrintWriter(arq);

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

        System.out.printf("\nTabuada do %d foi gravada com sucesso em " + caminhoArquivo, n);   
        
        try {
            Compactador.compactarParaZip(caminhoArquivo + ".zip", caminhoArquivo);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
