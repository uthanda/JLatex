import java.util.ArrayList;

public class LatexPreamble extends LatexContent{
	private String dclass,title,date,author;
	private ArrayList<LatexPackage> packages;
	private ArrayList<String> dclassopts = null;
	public LatexPreamble(String dclass, String title, String author){
		this.dclass = dclass;
		this.title = title;
		this.author = author;
		this.dclassopts= null;
		this.date = null;
		this.packages = null;
		
	}
	public LatexPreamble(String dclass, String title, String date, String author,ArrayList<String> dclassopts){
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.dclassopts = dclassopts;
		this.packages = null;
	}
	public LatexPreamble(String dclass, String title, String date, String author, ArrayList<LatexPackage> packages,ArrayList<String> dclassopts){
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.packages = packages;
		this.dclassopts = dclassopts;
	}
	@Override
	public String toLatexCode() {
		String out = "";
		out = out + "\\documentclass";
		if(dclassopts != null){
			out += "[";
			for(String s : dclassopts){
				out += s;
				if(dclassopts.indexOf(s) != dclassopts.size() - 1) out += ",";
			}
			out += "]";
		}
		out += "{" + dclass + "}\n\n";
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
