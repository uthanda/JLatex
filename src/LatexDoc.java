import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LatexDoc {
	private LatexPreamble preamb;
	private ArrayList<LatexSection> sections = new ArrayList();
	public LatexDoc(String type, String title, String date, String author,ArrayList<LatexPackage> packages){
		preamb = new LatexPreamble(type,title,date,author,packages);
	}
	public LatexDoc(LatexPreamble pre){
		preamb = pre;
	}
	public void addSection(LatexSection sec){
		sections.add(sec);
	}
	public String toLatexCode(){
		String out = "";
		
		out += preamb.toLatexCode();
		out += "\n\\begin{document}\n";
		out += "\\maketitle\n";
		for(LatexSection sec : sections) out += sec.toLatexCode();
		
		out += "\n\\end{document}\n";
		
		return out;
	}
	public void toLatexFile(String filename){
		try {
			PrintWriter writer = new PrintWriter(filename + ".tex", "UTF-8");
			writer.write(this.toLatexCode());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
