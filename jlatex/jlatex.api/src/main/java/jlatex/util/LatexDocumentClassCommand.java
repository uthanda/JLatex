package jlatex.util;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexText;

public class LatexDocumentClassCommand extends LatexCommand<LatexDocumentClassCommand>
{
	private LatexText className = new LatexText();
	
	private LatexCurlyBraceCommandParameter classNameParameter = new LatexCurlyBraceCommandParameter(className); 
	
	private LatexTextParameters options = new LatexTextParameters();
	
	private LatexSquareBracketCommandParameter optionsParameter = new LatexSquareBracketCommandParameter(className).optional(true); 

	public LatexDocumentClassCommand()
	{
		super("documentclass", true);
		addParameter(optionsParameter);
		addParameter(classNameParameter);
	}

	public LatexDocumentClassCommand className(String className) {
		this.className.content(className);
		return this;
	}
	
	public LatexDocumentClassCommand addOption(String option) {
		this.options.addParameter(option);
		return this;
	}

	public LatexDocumentClassCommand addOptions(List<String> options)
	{
		this.options.addParameters(options);
		return this;
	}
}
