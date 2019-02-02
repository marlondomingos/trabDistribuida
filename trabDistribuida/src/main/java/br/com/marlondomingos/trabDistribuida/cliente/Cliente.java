package br.com.marlondomingos.trabDistribuida.cliente;

import java.net.UnknownHostException;
import java.io.IOException;
import java.net.Socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");
		
		File file = new File("C:\\Trabalho\\Arquivo.txt");
		FileInputStream fileIn = new FileInputStream(file);
		
		OutputStream socketOut = cliente.getOutputStream();
		byte[] cbuffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = fileIn.read(cbuffer)) != -1) {
                socketOut.write(cbuffer, 0, bytesRead);
                socketOut.flush();
            }

		cliente.close();
        
    }
}