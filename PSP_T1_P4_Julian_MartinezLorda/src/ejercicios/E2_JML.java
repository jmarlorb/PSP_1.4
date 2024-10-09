package ejercicios;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import suplementarias.EscribeDominio;
import suplementarias.LeeDominio;

public class E2_JML {

	public static void main(String[] args) {
		
		try {
			PipedInputStream pis = new PipedInputStream();
			PipedOutputStream pos = new PipedOutputStream(pis);
			LeeDominio ld = new LeeDominio(pos);
			EscribeDominio ed = new EscribeDominio(pis);
			ld.run();
			ed.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
