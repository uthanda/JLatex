package jlatex;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSquareBracketCommandParameter;

public class LatexCaption extends LatexCommand
{
	private LatexParagraph longText = new LatexParagraph();
	private LatexText shortText = new LatexText();
	
	private LatexCurlyBraceCommandParameter longParameter = new LatexCurlyBraceCommandParameter(longText);
	private LatexSquareBracketCommandParameter shortParameter = new LatexSquareBracketCommandParameter(shortText);
	
	public LatexCaption()
	{
		super("citation");
		addParameter(longParameter);
		addParameter(shortParameter);
	}
	
	public String getShortText() {
		return shortText.getContent();
	}
	
	public void setShortText(String text) {
		shortText.setContent(text);
	}
	
	public LatexCaption shortText(String text) {
		shortText.setContent(text);
		return this;
	}
	
	public LatexParagraph getLongText() {
		return longText;
	}
	
	public LatexCaption addLongTextContent(LatexContent content) {
		this.longText.addContent(content);
		return this;
	}
}
