package jlatex.content;

import java.io.PrintWriter;

import jlatex.util.LatexContent;

public class LatexFloat implements LatexContent
{
	private Float value;
	private String format;

	public Float getValue()
	{
		return value;
	}

	public void setValue(Float value)
	{
		this.value = value;
	}

	public LatexFloat value(Float value)
	{
		this.value = value;
		return this;
	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public LatexFloat format(String format)
	{
		this.setFormat(format);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		if (value == null)
		{
			return;
		}
		else if (format != null)
		{
			writer.format(format, value);
		}
		else
		{
			writer.print(value);
		}
	}
}
