package jlatex;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;

public class LatexLabel extends LatexCommand
{
	private LatexText label;
	
	private LatexCurlyBraceCommandParameter labelParam = new LatexCurlyBraceCommandParameter(label);
	
	public LatexLabel()
	{
		super("label");
		addParameter(labelParam);
	}

	public String getLabel()
	{
		return label.getContent();
	}

	public void setLabel(String label)
	{
		this.label.setContent(label);
	}
	
	public LatexLabel label(String label)
	{
		this.label.setContent(label);
		return this;
	}
}