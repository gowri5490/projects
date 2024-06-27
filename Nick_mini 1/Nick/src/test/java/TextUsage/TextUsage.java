package TextUsage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextUsage {

	public static void write(List<String> outputToTextFile) throws IOException {
		File file = new File("./src/Output.txt");
		file.createNewFile();
		FileWriter write = new FileWriter(file);
		for(String x: outputToTextFile)
			write.write(x+"\n");
		write.close();	
	}

}
