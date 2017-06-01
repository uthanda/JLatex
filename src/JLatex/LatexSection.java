package JLatex;

import java.util.ArrayList;

public class LatexSection extends LatexContent{
	private String name;
	private ArrayList<String> contents;
	private ArrayList<LatexSection> subsections = new ArrayList<LatexSection>();
	
	public LatexSection(String name){
		this.name = name;
		this.contents = new ArrayList<String>();
	}
	public LatexSection(String name, ArrayList<String> contents){
		this.name = name;
		this.contents = contents;
	}
	public void addContents(String cont){
		contents.add(cont);
	}
	public String getName(){
		return name;
	}
	public ArrayList<String> getContents(){
		return contents;
	}
	public String toLatexCode() {
		String out = "";
		
		out += "\n\\section{" + name + "}\n";
		for(String s : contents){
			out += s + "\n\n";
		}
		for(LatexSection s : subsections){
			out += "\n\\subsection{" + s.getName() +"}\n";
			for(String y : s.getContents()) out += y + "\n\n";
		}
		
		return out;
	}

}
