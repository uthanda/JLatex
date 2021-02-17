package jlatex;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LatexDocument
{
	private LatexPreamble preamb;
	private List<LatexContent> contents = new ArrayList<>();

	public LatexDocument(String type, String title, String date, String author, List<LatexPackage> packages, List<String> dclassopts)
	{
		preamb = new LatexPreamble(type, title, date, author, packages, dclassopts);
	}

	public LatexDocument(LatexPreamble pre)
	{
		preamb = pre;
	}

	public void addContent(LatexContent cont)
	{
		contents.add(cont);
	}

	public String toLatexCode()
	{
		String out = "";

		out += preamb.toLatexCode();
		out += "\n\\begin{document}\n";
		out += "\\maketitle\n";
		for (LatexContent cont : contents)
		{
			out += cont.toLatexCode();
		}

		out += "\n\\end{document}\n";

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
