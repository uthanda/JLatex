package jlatex;

public class LatexImport extends LatexContent
{
	private String basePath;
	private String fileName;

	public LatexImport(String basePath, String fileName)
	{
		this.basePath = basePath;
		this.fileName = fileName;
	}

	public String getBasePath()
	{
		return basePath;
	}

	public void setBasePath(String basePath)
	{
		this.basePath = basePath;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public String toLatexCode()
	{
		return String.format("\\import{%s}{%s}%n", basePath, fileName);
	}
}
