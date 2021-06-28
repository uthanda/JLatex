package jlatex.table;

import jlatex.util.LatexEnumeration;

public enum LatexColumnLine implements LatexEnumeration
{
	SINGLE("|"),
	DOUBLE("||");
	
	private String latexContent;

	private LatexColumnLine(String latexContent) {
		this.latexContent = latexContent;
	}

	public String getLatexContent()
	{
		return latexContent;
	}
}