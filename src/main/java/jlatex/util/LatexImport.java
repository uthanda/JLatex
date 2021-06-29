package jlatex.util;

import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexText;

public class LatexImport extends LatexCommand<LatexImport>
{
	private LatexText basePath = new LatexText();
	private LatexText fileName = new LatexText();
	
	private LatexCurlyBraceCommandParameter basePathParam = new LatexCurlyBraceCommandParameter(basePath);
	private LatexCurlyBraceCommandParameter fileNameParam = new LatexCurlyBraceCommandParameter(fileName);

	public LatexImport()
	{
		super("import");
		addParameter(basePathParam);
		addParameter(fileNameParam);
	}

	public String getBasePath()
	{
		return basePath.getContent();
	}

	public void setBasePath(String basePath)
	{
		this.basePath.setContent(basePath);
	}
	
	public LatexImport basePath(String basePath)
	{
		this.basePath.setContent(basePath);
		return this;
	}

	public String getFileName()
	{
		return fileName.getContent();
	}

	public void setFileName(String fileName)
	{
		this.fileName.setContent(fileName);
	}
	
	public LatexImport fileName(String fileName)
	{
		this.fileName.setContent(fileName);
		return this;
	}
}
