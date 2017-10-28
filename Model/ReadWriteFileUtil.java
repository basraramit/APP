package Model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and write file util.
 */
 public class ReadWriteFileUtil {
	/**
	 * Hide the constructor.
	 */
	private ReadWriteFileUtil() {}
	/**
	 * Write file.
	 */
	public static boolean write(String fileName, String content) {
		File obj = new File(fileName);
		try {
			obj.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(obj));
			out.write(content);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	/**
	 * Read file.
	 */
	public static List<String> read(String fileName) {
		List<String> result = new ArrayList<>();
		try {
			File file = new File(fileName);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			line = br.readLine();
			while (null != line) {
				result.add(line);
				line=br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
