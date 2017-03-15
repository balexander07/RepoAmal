package AdactinPackage;

import java.io.IOException;

public class Temp extends DataDrivenApproach {
	
	public static void main (String[] args) throws IOException
	{
		loadConfig();
		initDriver();
		Login();
		//writeExcel();
	}
}
