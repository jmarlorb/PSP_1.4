package suplementarias;

import java.io.PipedInputStream;
import java.util.ArrayList;

public class EscribeDominio extends Thread {
	private PipedInputStream pis;
	
	public EscribeDominio(PipedInputStream pis) {
		this.pis = pis;
	}
	
	public void run() {
		try {
		      int num = -1;
		      String aux = "";
		      while ((num = pis.read()) != -1) {
		        aux+=(char)num;
		      }
		      
		      ArrayList<String> dominios = new ArrayList<String>();
		      String[] aux2 = aux.split("\n");
		      for (int i = 0; i<aux2.length; i++) {
		    	  dominios.add(aux2[i].strip());
		      }
		      dominios.sort(null);
		      for (String s: dominios) {
		    	  System.out.println(s);
		      }
		      pis.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
}
