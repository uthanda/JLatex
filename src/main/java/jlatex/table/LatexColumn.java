package jlatex.table;

import java.io.PrintWriter;
import java.util.List;

import jlatex.LatexContent;
import jlatex.content.LatexContentStream;

public class LatexColumn extends LatexContent
{
	private LatexContentStream contents = new LatexContentStream();

	public LatexContentStream getContents()
	{
		return contents;
	}

	public void setContents(LatexContentStream contents)
	{
		this.contents = contents;
	}

	public LatexColumn addContent(LatexContent content)
	{
		this.contents.addContent(content);
		return this;
	}
	
	public LatexColumn addContents(List<LatexContent> contents)
	{
		this.contents.addContents(contents);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		contents.write(writer);
	}

	public LatexColumn contents(LatexContentStream title)
	{
		this.setContents(title);
		return this;
	}
}
