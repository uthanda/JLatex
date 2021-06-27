package jlatex.table;

import java.io.PrintWriter;

import jlatex.LatexText;

public class LatexEnumText<E extends Enum<?> & LatexEnum> extends LatexText
{
	private Class type;
	private E value;
	
	public LatexEnumText(Class<E> type) {
		this.type = type;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LatexEnumText<E> content(String text)
	{
		value = (E) Enum.valueOf(type, text);
		return this;
	}
	
	@Override
	public void setContent(String text)
	{
		content(text);
	}
	
	public LatexEnumText<E> content(E text)
	{
		this.value = text;
		return this;
	}
	
	public void setContent(E text)
	{
		this.value = text;
	}
	
	@Override
	public void write(PrintWriter writer)
	{
		writer.print(value.getLatexContent());
	}

	@Override
	public String getContent()
	{
		return value != null ? value.getLatexContent() : null;
	}
	
	public E getEnumValue()
	{
		return value;
	}
}
