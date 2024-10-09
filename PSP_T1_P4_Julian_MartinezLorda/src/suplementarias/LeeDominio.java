package suplementarias;

import java.io.File;
import java.io.FileReader;
import java.io.PipedOutputStream;

public class LeeDominio extends Thread {
	private PipedOutputStream pos;

	public LeeDominio(PipedOutputStream pos) {
		this.pos = pos;
	}

	public void run() {
		File f = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "hosts");
		if (f.exists() && f.canRead()) {
			FileReader fr;
			try {
				fr = new FileReader(f);
				int i;
				char aux;
				boolean passedSpace = false;
				boolean newLine = false;
				while ((i = fr.read()) != -1) {
					aux = (char) i;
					if (aux == ' ') {
						passedSpace = true;
					}
					if (aux == '\n') {
						newLine = true;
					}
					if (passedSpace && aux != ' ') {
						pos.write(i);
						pos.flush();
						if (newLine) {
							passedSpace = false;
							newLine = false;
						}
					}
				}
				pos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
