package jlatex.table;

public enum LatexColumnLine implements LatexEnum
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