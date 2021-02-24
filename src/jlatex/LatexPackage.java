package jlatex;

import java.util.List;
import java.util.stream.Collectors;

public class LatexPackage extends LatexContent
{
	String name;
	List<String> options;

	public LatexPackage(String pName)
	{
		this.name = pName;
		this.options = null;
	}

	public LatexPackage(String pName, List<String> pOptions)
	{
		this.name = pName;
		this.options = pOptions;
	}

	@Override
	public String toLatexCode()
	{
		String out = "";

		out += "\\usepackage";
		if (this.options != null)
		{
			out += "[";
			out += options.stream().collect(Collectors.joining(","));
			out += "]";
		}
		out += "{" + this.name + "}\n";

		return out;
	}

}
