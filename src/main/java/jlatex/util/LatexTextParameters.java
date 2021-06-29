package jlatex.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LatexTextParameters implements LatexContent
{
	private List<String> parameters = new ArrayList<>();

	@Override
	public void write(PrintWriter writer)
	{
		writer.print(parameters.stream().collect(Collectors.joining(",")));
	}

	public LatexTextParameters addParameter(String parameter)
	{
		parameters.add(parameter);
		return this;
	}

	public LatexTextParameters addParameters(List<String> parameters)
	{
		parameters.addAll(parameters);
		return this;
	}

	@Override
	public boolean isEmpty()
	{
		return parameters.isEmpty();
	}

	public List<String> getParameters()
	{
		return parameters;
	}
}
