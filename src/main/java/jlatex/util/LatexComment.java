package jlatex.util;

import java.io.PrintWriter;

public class LatexComment implements LatexContent
{
	private String comment;

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	public LatexComment comment(String comment)
	{
		this.setComment(comment);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.printf("%% %s%n", comment);
	}
}
