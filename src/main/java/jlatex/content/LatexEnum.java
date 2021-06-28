package jlatex.content;

import java.io.PrintWriter;

import jlatex.LatexContent;
import jlatex.util.LatexEnumeration;

public class LatexEnum<E extends Enum<?> & LatexEnumeration> extends LatexContent
{
	private E value;
	
	public LatexEnum<E> value(E text)
	{
		this.value = text;
		return this;
	}
	
	public void setValue(E text)
	{
		this.value = text;
	}
	
	public E getValue()
	{
		return value;
	}

	@Override
	public void write(PrintWriter writer)
	{
		if(value == null) {
			return;
		}
		
		writer.print(value.getLatexContent());
	}

	public E getEnumValue()
	{
		return value;
	}
}
