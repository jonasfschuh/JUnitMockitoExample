/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Arquivos;

import ArquivoObj.ArquivoObj;
import ArquivoObj.ZipArquivo;
import java.io.File;
import java.io.IOException;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author 310173751
 */
public class ZipArquivoTest {
    
    public ZipArquivoTest() {
    }

    @Test
    public void testMain() {        
        System.out.println("Incializando " + this.getClass().getSimpleName());        
    }
    
    @Test
    public void testIfOriginFileWasCreated() throws IOException {        
        System.out.println("Incializando verificação se o arquivo de origem foi criado");        
        String caminho = "c:\\temp";
        String nomeArquivo = "teste2.txt";                 
        String caminhoCompleto = caminho + "\\" + nomeArquivo;
        
        ArquivoObj arquivoObj = new ArquivoObj(caminhoCompleto);
        arquivoObj.criar();
        arquivoObj.Salvar();
        ZipArquivo ziparquivo = new ZipArquivo(arquivoObj);
        ziparquivo.carregarArquivoOrigem();
        ziparquivo.salvarArquivoDestino();        
        
        // verifica se o arquivo existe 
        File file = new File(caminhoCompleto + ".zip");
        System.out.println(" caminho do arquivo: " + file.getCanonicalPath());
        
        assertTrue(file.exists());
    }   

    @Test
    public void testIfDestinyFileWasCreated() {        
        System.out.println("Incializando " + this.getClass().getSimpleName());        
    }   

    
    
}
