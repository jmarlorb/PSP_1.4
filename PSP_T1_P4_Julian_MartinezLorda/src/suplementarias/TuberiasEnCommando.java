package suplementarias;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TuberiasEnCommando implements Runnable {

	@Override
	public void run() {
		String[] command = { "powershell.exe ", "-Command ",
				"Get-Content \"" + System.getProperty("user.dir") + System.getProperty("file.separator") + "hosts\""
						+ " | ForEach-Object { ($_ -split ' ')[1] } | Sort-Object"};
		Process process;
		try {
			process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			process.waitFor();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
