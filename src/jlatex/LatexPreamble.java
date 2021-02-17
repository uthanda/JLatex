package jlatex;

import java.util.List;

public class LatexPreamble extends LatexContent
{
	private String dclass;
	private String title;
	private String date;
	private String author;
	
	private List<LatexPackage> packages;
	private List<String> dclassopts = null;

	public LatexPreamble(String dclass, String title, String author)
	{
		this.dclass = dclass;
		this.title = title;
		this.author = author;
		this.dclassopts = null;
		this.date = null;
		this.packages = null;
	}

	public LatexPreamble(String dclass, String title, String date, String author, List<String> dclassopts)
	{
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.dclassopts = dclassopts;
		this.packages = null;
	}

	public LatexPreamble(String dclass, String title, String date, String author, List<LatexPackage> packages, List<String> dclassopts)
	{
		this.dclass = dclass;
		this.title = title;
		this.date = date;
		this.author = author;
		this.packages = packages;
		this.dclassopts = dclassopts;
	}

	@Override
	public String toLatexCode()
	{
		String out = "";
		out = out + "\\documentclass";
		if (dclassopts != null)
		{
			out += "[";
			for (String s : dclassopts)
			{
				out += s;
				if (dclassopts.indexOf(s) != dclassopts.size() - 1)
					out += ",";
			}
			out += "]";
		}
		out += "{" + dclass + "}\n\n";
		if (packages != null)
		{
			for (LatexPackage l : packages)
			{
				out += l.toLatexCode();
			}
		}
		out = out + "\n\\title{" + title + "}\n";
		out = out + "\\author{" + author + "}\n";
		if (date != null)
			out = out + "\\date{" + date + "}\n";

		return out;
	}
}
