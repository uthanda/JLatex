package jlatex.content;

import java.io.PrintWriter;

import jlatex.LatexContent;

public class LatexText extends LatexContent
{
	private String text = "";
	private boolean escapeCharacters = true;
	
	public LatexText()
	{
	}
	
	@Override
	public boolean isEmpty()
	{
		return text.isEmpty();
	}
	
	public String getContent()
	{
		return text;
	}

	public void setContent(String text)
	{
		this.text = text;
	}

	public LatexText content(String text)
	{
		this.text = text;
		return this;
	}
	
	@Override
	public void write(PrintWriter writer)
	{
		writer.print(this.applyLatexEscapes(text));
	}

	private String applyLatexEscapes(String text)
	{
		if(text == null) {
			return "";
		}
		
		if(!escapeCharacters) {
			return text;
		}
		
		StringBuilder buffer = text.chars().collect(StringBuilder::new, this::mapLatexCharacter, StringBuilder::append);

		return buffer.toString();
	}

	private void mapLatexCharacter(StringBuilder target, int character)
	{
		switch (character)
		{
			case 'Ş':
			{
				target.append("\\c{S}");
				break;
			}
			
			case 'ș':
			{
				target.append("\\c{S}");
				break;
			}
			
			case '&':
			case '%':
			case '$':
			case '#':
			case '_':
			case '{':
			case '}':
			{
				target.append("\\");
			}

			default:
			{
				target.append((char) character);
			}
		}
	}

	public LatexText escapeCharacters(boolean escape)
	{
		this.escapeCharacters = escape;
		return this;
	}
}
