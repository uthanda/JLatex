package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LatexParagraph extends LatexContent
{
	private List<LatexContent> contents = new ArrayList<>();

	public List<LatexContent> getContents()
	{
		return contents;
	}

	public void setContents(List<LatexContent> contents)
	{
		this.contents = contents;
	}
	
	public LatexParagraph addContent(LatexContent content)
	{
		this.contents.add(content);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		contents.stream().forEach(content -> content.write(writer));
	}
}
