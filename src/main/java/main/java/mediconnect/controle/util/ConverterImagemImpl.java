package main.java.mediconnect.controle.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.*;

import javax.servlet.http.Part;

public class ConverterImagemImpl implements ConverterImagem {

	public byte[] obterBytesImagem(Part parteImagem) throws IOException {
		InputStream imagemInputstream = parteImagem.getInputStream();
 
		return IOUtils.toByteArray(imagemInputstream);
	}
}
