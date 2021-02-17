package jlatex;

public abstract class LatexContent
{
	public abstract String toLatexCode();

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
				target.append("\\");

			default:
				target.append((char) character);
		}
	}
}
