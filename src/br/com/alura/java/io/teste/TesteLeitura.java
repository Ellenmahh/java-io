/**
 * 
 */
package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author Ellen Mayara
 *
 */
public class TesteLeitura {

	public static void main(String[] args) throws IOException {

		OutputStream fos = new FileOutputStream("teste2.txt");
		Writer osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);

		bw.write("sd asdasd as das asd asd as dasd asd a as sdssssss  ");
		bw.newLine();
		
		bw.close();
	}

}
