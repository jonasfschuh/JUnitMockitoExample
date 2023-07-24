/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ArquivoObj;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Jonas Fernando Schuh
 */
public class ZipArquivo {

    static final int TAMANHO_BUFFER = 4096; // 4kb
    ArquivoObj arquivoObj = null;
    int cont;
    byte[] dados = new byte[TAMANHO_BUFFER];

    BufferedInputStream origem = null;
    FileInputStream streamDeEntrada = null;
    FileOutputStream destino = null;
    ZipOutputStream saida = null;
    ZipEntry entry = null;
    
    public ZipArquivo(ArquivoObj arquivoObj) {
        this.arquivoObj = arquivoObj;
    }
    
    public static void main(String[] args) {
        ArquivoObj arquivoObj = new ArquivoObj("c:\\temp\\teste2.txt");
        arquivoObj.criar();
        arquivoObj.Salvar();
        ZipArquivo ziparquivo = new ZipArquivo(arquivoObj);
        ziparquivo.carregarArquivoOrigem();
        ziparquivo.salvarArquivoDestino();
    }
    
    public void carregarArquivoOrigem() {
        File file = new File(arquivoObj.caminhoArquivo);
        try {
            streamDeEntrada = new FileInputStream(file);          
            destino = new FileOutputStream(new File(arquivoObj.caminhoArquivo + ".zip"));
            saida = new ZipOutputStream(new BufferedOutputStream(destino));
            origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
            entry = new ZipEntry(file.getName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZipArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void salvarArquivoDestino() {
       try {
            saida.putNextEntry(entry);

            while((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
                saida.write(dados, 0, cont);
            }
            origem.close();
            saida.close();
        } catch(IOException e) {
            Logger.getLogger(ZipArquivo.class.getName()).log(Level.SEVERE, null, e);
        }
    }   
}
