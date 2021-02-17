package jlatex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String toLatexCode()
	{
		return contents.stream().map(LatexContent::toLatexCode).collect(Collectors.joining());
	}
}
