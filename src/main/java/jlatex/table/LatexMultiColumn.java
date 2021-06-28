package jlatex.table;

import java.util.List;

import jlatex.LatexContent;
import jlatex.command.LatexCommand;
import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.content.LatexContentStream;
import jlatex.content.LatexInteger;

public class LatexMultiColumn extends LatexColumn
{
	private LatexInteger columns = new LatexInteger();
	
	private LatexCurlyBraceCommandParameter columnsParameter = new LatexCurlyBraceCommandParameter(columns);

	private LatexColumnSpecification columnSpecification = new LatexColumnSpecification();
	
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications().addColumnSpecification(columnSpecification );
	
	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);
	
	private LatexContentStream content = new LatexContentStream();
	
	private LatexCurlyBraceCommandParameter contentParameter = new LatexCurlyBraceCommandParameter(content);
	
	public LatexMultiColumn()
	{
		super.addContent(new LatexCommand("multicolumn", columnsParameter, columnSpecificationsParameter, contentParameter));
	}

	public Integer getColumns() {
		return columns.getValue();
	}
	
	public void setColumns(Integer columns) {
		this.columns.setValue(columns);
	}
	
	public LatexMultiColumn columns(Integer columns) {
		this.setColumns(columns);
		return this;
	}
	
	public LatexMultiColumn addContent(LatexContent content) {
		this.content.addContent(content);
		return this;
	}
	
	public LatexMultiColumn addContents(List<LatexContent> contents) {
		this.content.addContents(contents);
		return this;
	}

	public LatexColumnAlignment getAlignment()
	{
		return columnSpecification.getAlignment();
	}

	public void setAlignment(LatexColumnAlignment alignment)
	{
		this.columnSpecification.setAlignment(alignment);
	}

	public LatexMultiColumn alignment(LatexColumnAlignment alignment)
	{
		this.columnSpecification.setAlignment(alignment);
		return this;
	}

	public Integer getWidth()
	{
		return this.columnSpecification.getWidth();
	}

	public void setWidth(Integer width)
	{
		this.columnSpecification.setWidth(width);
	}
	
	public LatexMultiColumn width(Integer width)
	{
		this.columnSpecification.setWidth(width);
		return this;
	}

	public LatexColumnLine getBefore()
	{
		return this.columnSpecification.getBefore();
	}

	public void setBefore(LatexColumnLine before)
	{
		this.columnSpecification.setBefore(before);
	}
	
	public LatexMultiColumn before(LatexColumnLine before)
	{
		this.columnSpecification.setBefore(before);
		return this;
	}

	public LatexColumnLine getAfter()
	{
		return this.columnSpecification.getAfter();
	}

	public void setAfter(LatexColumnLine after)
	{
		this.columnSpecification.setAfter(after);
	}
	
	public LatexMultiColumn after(LatexColumnLine after)
	{
		this.columnSpecification.setAfter(after);
		return this;
	}
}
