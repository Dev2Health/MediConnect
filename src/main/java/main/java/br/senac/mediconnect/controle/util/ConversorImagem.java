package main.java.br.senac.mediconnect.controle.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class ConversorImagem {

	public static byte[] obterBytesImagem(Part parteImagem) throws IOException {

		InputStream imagemInputstream = parteImagem.getInputStream();

		return IOUtils.toByteArray(imagemInputstream);

		
	}
	
	public static String urlFoto(byte[] foto, String extensao) {
		String urlFoto =("data:" + extensao + ";base64," + Base64.getEncoder().encodeToString(foto));
		return urlFoto;
	}
}
