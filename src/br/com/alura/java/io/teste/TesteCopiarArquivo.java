/**
 * 
 */
package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Ellen Mayara
 *
 */
public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {

		InputStream fis = System.in;
		Reader isr = new InputStreamReader(fis);
		BufferedReader bf = new BufferedReader(isr);
		String linha = bf.readLine();
		
		OutputStream fos = new FileOutputStream("teste2.txt");
		Writer osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);
		
		while(linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			linha = bf.readLine();
		}
		
		bf.close();
		bw.close();
	}

}
