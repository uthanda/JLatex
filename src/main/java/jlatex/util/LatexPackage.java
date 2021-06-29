package jlatex.util;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexText;

public class LatexPackage extends LatexCommand<LatexPackage>
{
	private LatexText name = new LatexText().escapeCharacters(false);
	
	private LatexTextParameters options = new LatexTextParameters();
	
	public LatexPackage()
	{
		super("package", true);
		addParameter(new LatexSquareBracketCommandParameter(options));
		addParameter(new LatexCurlyBraceCommandParameter(name));
	}
	
	public String getName()
	{
		return name.getContent();
	}

	public void setName(String name)
	{
		this.name.setContent(name);
	}

	public LatexPackage name(String name)
	{
		this.name.setContent(name);
		return this;
	}

	public List<String> getOptions()
	{
		return options.getParameters();
	}
	
	public LatexPackage addOption(String option)
	{
		options.addParameter(option);
		return this;
	}
}
