package jlatex;

import java.io.PrintWriter;

public class LatexText extends LatexContent
{
	private String text;
	
	public LatexText()
	{
	}
	
	public LatexText(String text)
	{
		this.text = text;
	}
	
	public LatexText(Integer integer)
	{
		this.text = integer.toString();
	}

	public String getContent()
	{
		return text;
	}

	public void setContent(String text)
	{
		this.text = text;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.print(this.applyLatexEscapes(text));
	}

	public LatexContent content(String text)
	{
		this.text = text;
		return this;
	}
}
