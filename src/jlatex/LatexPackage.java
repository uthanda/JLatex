package jlatex;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LatexPackage extends LatexContent
{
	private String name;
	private List<String> options = new ArrayList<>();
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public LatexPackage name(String name)
	{
		this.name = name;
		return this;
	}

	public List<String> getOptions()
	{
		return options;
	}
	
	public LatexPackage addOption(String option)
	{
		options.add(option);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		writer.print("\\usepackage");

		if (this.options != null)
		{
			writer.print("[");
			writer.print(options.stream().collect(Collectors.joining(",")));
			writer.print("]");
		}

		writer.println("{" + this.name + "}");
	}
}
