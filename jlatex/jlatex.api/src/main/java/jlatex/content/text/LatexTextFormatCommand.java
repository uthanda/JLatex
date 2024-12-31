package jlatex.content.text;

import java.util.List;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCommandParameter;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexSimpleContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

/**
 * Represents a block of formatted text (such as bold, italic, underline)  It is rendered as
 * \\tag{LatexContentStream&lt;LatexContent&gt;}
 * 
 * @author Michael Oland
 *
 * @param <T> Subclass for builder paradigm
 */
public abstract class LatexTextFormatCommand<T> extends LatexCommand<LatexTextFormatCommand<T>>
{
	private LatexSimpleContentStream stream = new LatexSimpleContentStream();

	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(stream);

	/**
	 * Creates a new LatexTexFormat command
	 * 
	 * @param name Name of command
	 * @param parameters Optional additional parameters
	 */
	protected LatexTextFormatCommand(String name, LatexCommandParameter<?>... parameters)
	{
		super(name, parameters);
		super.addParameter(contentParameter);
	}

	/**
	 * Adds content to the format command
	 * 
	 * @param content Content to add
	 * @return This for chaining purposes.
	 */
	@SuppressWarnings("unchecked")
	public T addContent(LatexContent content)
	{
		stream.addContent(content);
		return (T) this;
	}

	/**
	 * Adds contents to the format command
	 * 
	 * @param contents Contents to add
	 * @return This for chaining purposes.
	 */
	@SuppressWarnings("unchecked")
	public T addContents(List<LatexContent> contents)
	{
		stream.addContents(contents);
		return (T) this;
	}

	/**
	 * Adds text to the command.  The same as passing a new {@link jlatex.content.LatexText LatexText} to the {@link #addContent(LatexContent)} method.
	 * 
	 * @param text Text to add
	 * @return This for chaining purposes.
	 */
	public T addText(String text)
	{
		return this.addContent(new LatexText().content(text));
	}
}