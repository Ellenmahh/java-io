/**
 * 
 */
package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ellen Mayara
 *
 */
public class TesteEscrita {

	public static void main(String[] args) throws IOException {

		//Lendo o arquivo
		FileInputStream fis = new FileInputStream("teste.txt");
		//transformando os bytes em caracteres
		InputStreamReader isr = new InputStreamReader(fis);
		// ler cada linha ao inves de cada byte
		BufferedReader bf = new BufferedReader(isr);
		String linha = bf.readLine();
		
		while(linha != null) {
			System.out.println(linha);
			linha = bf.readLine();
		}
		
		bf.close();
	}

}
