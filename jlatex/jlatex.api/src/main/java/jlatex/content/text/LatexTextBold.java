package jlatex.content.text;

import jlatex.content.LatexText;

/**
 * Represents text that is bold faced.  (\\textbf{content})
 * 
 * @author Michael Oland
 *
 */
public class LatexTextBold extends LatexTextFormatCommand<LatexTextBold>
{
	/**
	 * Creates a bold face text block
	 */
	public LatexTextBold()
	{
		super("textbf");
	}

	/**
	 * Creates a bold face text block with the provided content as a LatexText block.
	 * 
	 * @param content Content to add
	 */
	public LatexTextBold(String content)
	{
		this();
		addContent(new LatexText(content));
	}
}
