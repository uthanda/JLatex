package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public abstract class LatexList<T> extends LatexContent
{
	private LatexCommand begin = new LatexCommand("begin");
	private LatexCommand end = new LatexCommand("end");
	
	private final List<LatexItem> items = new ArrayList<>();
	
	protected LatexList(String type)
	{
		begin.addParameter(new LatexCurlyBraceCommandParameter(new LatexText().content(type)));
		end.addParameter(new LatexCurlyBraceCommandParameter(new LatexText().content(type)));
	}

	public List<LatexItem> getElements()
	{
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public T addElement(LatexItem content)
	{
		this.items.add(content);
		return (T)this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		begin.write(writer);
		
		items.forEach(element -> element.write(writer));
		
		end.write(writer);
	}
}
