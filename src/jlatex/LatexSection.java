package jlatex;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LatexSection extends LatexContent
{
	private String name;
	private List<LatexContent> contents;
	private List<LatexSection> subsections = new ArrayList<>();

	public LatexSection(String name)
	{
		this.name = name;
		this.contents = new ArrayList<>();
	}

	public LatexSection(String name, List<LatexContent> contents)
	{
		this.name = name;
		this.contents = contents;
	}

	public void addContents(LatexContent cont)
	{
		contents.add(cont);
	}

	public void addSubSection(LatexSection subsection)
	{
		this.subsections.add(subsection);
	}

	public String getName()
	{
		return name;
	}

	public List<LatexContent> getContents()
	{
		return contents;
	}

	@Override
	public String toLatexCode()
	{
		String out = "";

		out += "\n\\section{" + name + "}\n";
		for (LatexContent s : contents)
		{
			out += s.toLatexCode() + "\n\n";
		}
		for (LatexSection s : subsections)
		{
			out += "\n\\subsection{" + s.getName() + "}\n";
			for (LatexContent y : s.getContents())
				out += y.toLatexCode() + "\n\n";
		}

		return out;
	}

	public void toLatexFile(String filename)
	{
		try
		{
			PrintWriter writer = new PrintWriter(filename + ".tex", "UTF-8");
			writer.write(this.toLatexCode());
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
