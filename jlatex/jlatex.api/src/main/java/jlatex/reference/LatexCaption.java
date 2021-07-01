package jlatex.reference;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexText;
import jlatex.util.LatexContent;

public class LatexCaption extends LatexCommand<LatexCaption>
{
	private LatexContentStream<LatexContent> longText = new LatexContentStream<>();
	private LatexText shortText = new LatexText();

	private LatexCurlyBraceCommandParameter longParameter = new LatexCurlyBraceCommandParameter(longText);
	private LatexSquareBracketCommandParameter shortParameter = new LatexSquareBracketCommandParameter(shortText).optional(true);

	public LatexCaption()
	{
		super("caption");
		addParameter(longParameter);
		addParameter(shortParameter);
	}

	public String getShortText()
	{
		return shortText.getContent();
	}

	public void setShortText(String text)
	{
		shortText.setContent(text);
	}

	public LatexCaption shortText(String text)
	{
		shortText.setContent(text);
		return this;
	}

	public LatexContentStream<LatexContent> getLongText()
	{
		return longText;
	}

	public LatexCaption addLongTextContent(LatexContent content)
	{
		this.longText.addContent(content);
		return this;
	}
}
