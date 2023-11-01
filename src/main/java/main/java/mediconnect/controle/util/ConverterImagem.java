package main.java.mediconnect.controle.util;

import javax.servlet.http.Part;
import java.io.IOException;

public interface ConverterImagem {
	
	byte[] obterBytesImagem(Part parteFoto) throws IOException;

}
