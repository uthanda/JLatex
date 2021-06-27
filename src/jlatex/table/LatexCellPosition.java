package jlatex.table;

public enum LatexCellPosition implements LatexEnum
{
	BOTTOM("b"),
	CENTER("c"),
	TOP("t");
	
	private String latexContent;

	private LatexCellPosition(String latexContent) {
		this.latexContent = latexContent;
	}

	public String getLatexContent()
	{
		return latexContent;
	}
}