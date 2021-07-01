package jlatex.organization;

import java.io.PrintWriter;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

public abstract class LatexDivision<T> extends LatexContentStream<LatexContent>
{
	private final LatexText name = new LatexText();
	private final LatexCommand<?> section;

	public LatexDivision(String type)
	{
		section = new LatexSimpleCommand(type,true,new LatexCurlyBraceCommandParameter(this.name));
	}

	public String getName()
	{
		return name.getContent();
	}

	public void setName(String name)
	{
		this.name.setContent(name);
	}

	@SuppressWarnings("unchecked")
	public T name(String name)
	{
		this.name.setContent(name);
		return (T) this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		section.write(writer);
		super.write(writer);
	}

}