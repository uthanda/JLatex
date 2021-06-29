package jlatex.reference;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

public class LatexReference extends LatexCommand<LatexReference>
{
	private LatexText label = new LatexText().escapeCharacters(false);

	private LatexCurlyBraceCommandParameter labelParam = new LatexCurlyBraceCommandParameter(label);

	public LatexReference()
	{
		super("ref");
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

	public LatexReference label(String label)
	{
		this.label.setContent(label);
		return this;
	}
}
