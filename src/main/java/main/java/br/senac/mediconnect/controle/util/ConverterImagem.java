package main.java.br.senac.mediconnect.controle.util;

import java.io.IOException;

import javax.servlet.http.Part;

public interface ConverterImagem {
	
	byte[] obterBytesImagem(Part parteFoto) throws IOException;

}
