package jlatex.table;

import jlatex.util.LatexEnumeration;

public enum LatexColumnAlignment implements LatexEnumeration
{
	LEFT_JUSTIFIED("l"),
	CENTERED("c"),
	RIGHT_JUSTIFIED("r"),
	PARAGRAPH_TOP("p"),
	PARAGRAPH_MIDDLE("m"),
	PARAGRAPH_BOTTOM("b");
	
	private String latexContent;

	private LatexColumnAlignment(String latexContent) {
		this.latexContent = latexContent;
	}

	public String getLatexContent()
	{
		return latexContent;
	}
}