import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LatexDoc {
	private LatexPreamble preamb;
	private ArrayList<LatexContent> contents = new ArrayList();
	public LatexDoc(String type, String title, String date, String author,ArrayList<LatexPackage> packages,ArrayList<String> dclassopts){
		preamb = new LatexPreamble(type,title,date,author,packages,dclassopts);
	}
	public LatexDoc(LatexPreamble pre){
		preamb = pre;
	}
	public void addContent(LatexContent cont){
		contents.add(cont);
	}
	public String toLatexCode(){
		String out = "";
		
		out += preamb.toLatexCode();
		out += "\n\\begin{document}\n";
		out += "\\maketitle\n";
		for(LatexContent cont : contents) out += cont.toLatexCode();
		
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
