import java.util.ArrayList;

public class LatexPreamble extends LatexContent{
	private String dclass,title,date,author;
	private ArrayList<LatexPackage> packages;
	public LatexPreamble(String dclass, String title, String author){
		this.dclass = dclass;
		this.title = title;
		this.author = author;
		this.date = null;
		this.packages = null;
		
	}
	public LatexPreamble(String dclass, String title, String date, String author){
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.packages = null;
	}
	public LatexPreamble(String dclass, String title, String date, String author, ArrayList<LatexPackage> packages){
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.packages = packages;
	}
	@Override
	public String toLatexCode() {
		String out = "";
		out = out + "\\documentclass{" + dclass + "}\n\n";
		if(packages != null){
			for(LatexPackage l : packages){
				out += l.toLatexCode();
			}
		}
		out = out + "\n\\title{" + title + "}\n";
		out = out + "\\author{" + author + "}\n";
		if(date != null) out = out + "\\date{" + date + "}\n";
		
		
		
		return out;
	}
}
