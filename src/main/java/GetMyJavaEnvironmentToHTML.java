import java.io.*;
import java.util.*;
public class GetMyJavaEnvironmentToHTML {
	public static void main(String args[]) {
		try {
			File file = new File("property.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<style>\r\n"
					+ "	table {border-collapse : collapse; width : 100%}\r\n"
					+ "	th, td {border:solid 1px #000;}\r\n"
					+ "</style>\r\n"
					+ "<title>My Java Environment!!</title>");
			
			writer.write("<body>\r\n"
					+ "<h3>자바 환경 정보</h3>\r\n"
					+ "\r\n"
					+ "<table border = 1 width = \"600\">\r\n"
					+ "	<tr>\r\n"
					+ "		<th>키</th>\r\n"
					+ "		<th>속성</th>\r\n"
					+ "	</tr>");
			
			for(Object k : System.getProperties().keySet()) {
				String key = k.toString();
				String value = System.getProperty(key);
				
				writer.write("<tr> <td>" + key + "</td> <td>" + value + "</td> </tr>");
			}
			
			writer.write("</table> </body>");
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
