package jlatex.table;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jlatex.util.LatexContent;

public class LatexColumnSpecifications implements LatexContent
{
	private List<LatexColumnSpecification> columnSpecifications = new ArrayList<>();

	@Override
	public void write(PrintWriter writer)
	{
		columnSpecifications.forEach(def -> def.write(writer));
	}

	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications;
	}

	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications = columnSpecifications;
	}

	public LatexColumnSpecifications columnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications = columnSpecifications;
		return this;
	}

	public LatexColumnSpecifications addColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.addAll(columnSpecifications);
		return this;
	}

	public LatexColumnSpecifications addColumnSpecification(LatexColumnSpecification columnSpecification)
	{
		this.columnSpecifications.add(columnSpecification);
		return this;
	}
}
