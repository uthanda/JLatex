package jlatex.reference;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

/**
 * Represents a label-based command (such as \\label{} or \\ref{})
 * 
 * @author Michael Oland
 *
 * @param <T> Subclass for the builder paradigm. 
 */
public abstract class LatexAbstractLabel<T extends LatexAbstractLabel<T>> extends LatexCommand<T>
{
	private LatexText label = new LatexText().escapeCharacters(false);

	private LatexCurlyBraceCommandParameter labelParam = new LatexCurlyBraceCommandParameter(label);

	protected LatexAbstractLabel(String name)
	{
		super(name);

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

	@SuppressWarnings("unchecked")
	public T label(String label)
	{
		this.label.setContent(label);
		return (T) this;
	}

}