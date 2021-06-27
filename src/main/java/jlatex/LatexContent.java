package jlatex;

import java.io.PrintWriter;

public abstract class LatexContent
{
	public abstract void write(PrintWriter writer);
	
	public boolean isEmpty() {
		return false;
	}

	public String applyLatexEscapes(String text)
	{
		StringBuilder buffer = text.chars().collect(StringBuilder::new, this::mapLatexCharacter, StringBuilder::append);

		return buffer.toString();
	}

	private void mapLatexCharacter(StringBuilder target, int character)
	{
		switch (character)
		{
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
}
