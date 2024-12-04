package jlatex.command;

import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

public class LatexNewCommand extends LatexCommand<LatexNewCommand>
{
	private LatexSimpleContentStream commandValue = new LatexSimpleContentStream();
	private LatexText commandName = new LatexText();
	
	private LatexCurlyBraceCommandParameter commandNameParam = new LatexCurlyBraceCommandParameter(commandName);
	private LatexCurlyBraceCommandParameter commandValueParam = new LatexCurlyBraceCommandParameter(commandValue);
	
	public LatexNewCommand()
	{
		super("newcommand", true);
		
		addParameter(commandNameParam);
		addParameter(commandValueParam);
	}
	
	public LatexNewCommand commandName(String name)
	{
		commandName.content("\\" + name);
		return this;
	}
	
	public LatexNewCommand addValueContent(LatexContent content)
	{
		commandValue.addContent(content);
		return this;
	}
}
