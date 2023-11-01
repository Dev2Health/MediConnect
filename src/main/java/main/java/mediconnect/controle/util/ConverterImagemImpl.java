package main.java.mediconnect.controle.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class ConverterImagemImpl implements ConverterImagem {

	public byte[] obterBytesImagem(Part parteImagem) throws IOException {
		InputStream imagemInputstream = parteImagem.getInputStream();
 
		return IOUtils.toByteArray(imagemInputstream);
	}
}
