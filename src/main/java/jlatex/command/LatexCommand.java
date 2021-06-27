package jlatex.command;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.LatexContent;

public class LatexCommand extends LatexContent
{
	private final String name;
	private List<LatexCommandParameter<?>> parameters = new ArrayList<>();

	public LatexCommand(String name, LatexCommandParameter<?>... parameters) {
		this.name = name;
		this.parameters = Arrays.asList(parameters);
	}
	
	public void addParameter(LatexCommandParameter<?> parameter) {
		this.parameters.add(parameter);
	}
	
	@Override
	public final void write(PrintWriter writer)
	{
		writer.printf("\\%s", name);
		
		parameters.forEach(param -> param.write(writer));
	}
}
