package jlatex.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.command.LatexSimpleCommand;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexText;

public class LatexPreamble implements LatexContent
{
	private LatexDocumentClassCommand documentClass = new LatexDocumentClassCommand();

	private LatexContentStream<LatexContent> title = new LatexContentStream<>();

	private LatexCurlyBraceCommandParameter titleParameter = new LatexCurlyBraceCommandParameter(title);

	private LatexSimpleCommand titleCommand = new LatexSimpleCommand("title", true, titleParameter);

	private LatexContentStream<LatexContent> authorContent = new LatexContentStream<>();

	private LatexCurlyBraceCommandParameter authorParameter = new LatexCurlyBraceCommandParameter(authorContent);

	private LatexSimpleCommand authorCommand = new LatexSimpleCommand("author", true, authorParameter);

	private LatexText date = new LatexText().escapeCharacters(false);

	private LatexCurlyBraceCommandParameter dateParameter = new LatexCurlyBraceCommandParameter(date);

	private LatexSimpleCommand dateCommand = new LatexSimpleCommand("date", true, dateParameter);

	private List<LatexPackage> packages = new ArrayList<>();

	public LatexPreamble addContent(LatexContent content)
	{
		this.authorContent.addContent(content);
		return this;
	}

	public LatexPreamble addContents(List<LatexContent> contents)
	{
		this.authorContent.addContents(contents);
		return this;
	}

	public List<LatexContent> getTitleContent()
	{
		return title.getContents();
	}

	public void setTitleContent(List<LatexContent> title)
	{
		this.title.setContents(title);
	}

	public LatexPreamble titleContent(List<LatexContent> title)
	{
		this.title.setContents(title);
		return this;
	}

	public LatexPreamble addTitleContents(List<LatexContent> contents)
	{
		this.title.addContents(contents);
		return this;
	}

	public LatexPreamble addTitleContent(LatexContent content)
	{
		this.title.addContent(content);
		return this;
	}

	public String getDate()
	{
		return date.getContent();
	}

	public void setDate(String date)
	{
		this.date.setContent(date);
	}

	public LatexPreamble date(String date)
	{
		this.setDate(date);
		return this;
	}

	public List<LatexPackage> getPackages()
	{
		return packages;
	}

	public LatexPreamble addPackages(List<LatexPackage> packages)
	{
		this.packages.addAll(packages);
		return this;
	}

	public LatexPreamble addPackage(LatexPackage lp)
	{
		this.packages.add(lp);
		return this;
	}

	public LatexPreamble addDocumentClassOptions(List<String> options)
	{
		this.documentClass.addOptions(options);
		return this;
	}

	public LatexPreamble addDocumentClassOption(String options)
	{
		this.documentClass.addOption(options);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		documentClass.write(writer);

		if (packages != null)
		{
			for (LatexPackage l : packages)
			{
				l.write(writer);
			}
		}

		titleCommand.write(writer);
		authorCommand.write(writer);

		if (!date.isEmpty())
		{
			dateCommand.write(writer);
		}
	}
}
