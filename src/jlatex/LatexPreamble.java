package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LatexPreamble extends LatexContent
{
	private String dclass;
	private String title;
	private String date;
	private String author;
	
	private List<LatexPackage> packages = new ArrayList<>();
	private List<String> dclassopts = new ArrayList<>();
	
	public String getDclass()
	{
		return dclass;
	}

	public void setDclass(String dclass)
	{
		this.dclass = dclass;
	}
	
	public LatexPreamble dclass(String dclass)
	{
		this.dclass = dclass;
		return this;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public LatexPreamble title(String title)
	{
		this.title = title;
		return this;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}
	
	public LatexPreamble date(String date)
	{
		this.date = date;
		return this;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public LatexPreamble author(String author)
	{
		this.author = author;
		return this;
	}

	public List<LatexPackage> getPackages()
	{
		return packages;
	}

	public LatexPreamble addPackages(List<LatexPackage> packages)
	{
		this.packages.addAll(packages);
		return this;
	}
	
	public LatexPreamble addPackage(LatexPackage lp)
	{
		this.packages.add(lp);
		return this;
	}

	public List<String> getDclassopts()
	{
		return dclassopts;
	}

	public LatexPreamble addDclassopts(List<String> dclassopts)
	{
		this.dclassopts.addAll(dclassopts);
		return this;
	}
	
	public LatexPreamble addDclassopt(String dclassopts)
	{
		this.dclassopts.add(dclassopts);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.print("\\documentclass");
		
		if (dclassopts != null)
		{
			writer.print('[');
			for (String s : dclassopts)
			{
				writer.print(s);
				if (dclassopts.indexOf(s) != dclassopts.size() - 1)
				{
					writer.print(',');
				}
			}
			writer.print(']');
		}
		
		writer.print("{");
		writer.print(dclass);
		writer.println("}");
		
		if (packages != null)
		{
			for (LatexPackage l : packages)
			{
				l.write(writer);
			}
		}

		writer.println("\\title{" + title + "}");
		writer.println("\\author{" + author + "}");
		
		if (date != null) {
			writer.print("\\date{");
			writer.print(date);
			writer.println("}");
		}
	}
}
