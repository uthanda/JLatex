package jlatex;

public class LatexCitation extends LatexContent
{
	private String citeKey;

	public LatexCitation(String citeKey)
	{
		this.citeKey = citeKey;
	}

	@Override
	public String toLatexCode()
	{
		return String.format("\\cite{%s}", citeKey);
	}
}
