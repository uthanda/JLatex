package jlatex.command;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.util.LatexContent;

public class LatexCommand<T> implements LatexContent
{
	private final String name;
	private List<LatexCommandParameter<?>> parameters = new ArrayList<>();
	private boolean addNewLine = false;

	public LatexCommand(String name, LatexCommandParameter<?>... parameters)
	{
		this(name, false, parameters);
	}

	public LatexCommand(String name, boolean addNewLine, LatexCommandParameter<?>... parameters)
	{
		this.addNewLine = addNewLine;
		this.name = name;
		this.parameters.addAll(Arrays.asList(parameters));
	}

	@SuppressWarnings("unchecked")
	public T addParameter(LatexCommandParameter<?> parameter)
	{
		this.parameters.add(parameter);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T addParameters(List<LatexCommandParameter<?>> parameters)
	{
		this.parameters.addAll(parameters);
		return (T) this;
	}

	@Override
	public final void write(PrintWriter writer)
	{
		writer.printf("\\%s", name);

		parameters.forEach(param -> {
			param.write(writer);
		});

		if (addNewLine)
		{
			writer.println();
		}
	}
}
