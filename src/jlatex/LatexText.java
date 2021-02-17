package jlatex;

public class LatexText extends LatexContent
{
	private String content;
	
	public LatexText(String content)
	{
		this.content = content;
	}
	
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	@Override
	public String toLatexCode()
	{
		return super.applyLatexEscapes(content);
	}
}
