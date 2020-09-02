/**
 * 
 */
package br.com.alura.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Ellen Mayara
 *
 */
public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(new File("contas.csv"));
		
		while(scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			System.out.println(linha);
		}
	}

}
