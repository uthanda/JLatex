package jlatex.table;

import java.util.ArrayList;
import java.util.List;

import jlatex.command.LatexCurlyBraceCommandParameter;
import jlatex.util.LatexBlock;

public class LatexTabular extends LatexBlock<LatexTabular, LatexRow>
{
	private LatexColumnSpecifications columnSpecifications = new LatexColumnSpecifications();

	private LatexCurlyBraceCommandParameter columnSpecificationsParameter = new LatexCurlyBraceCommandParameter(columnSpecifications);

	private List<LatexRow> rows = new ArrayList<>();

	protected LatexTabular()
	{
		super("tabular");
		addBeginParameter(columnSpecificationsParameter);
	}

	public List<LatexColumnSpecification> getColumnSpecifications()
	{
		return columnSpecifications.getColumnSpecifications();
	}

	public void setColumnSpecifications(List<LatexColumnSpecification> columnSpecifications)
	{
		this.columnSpecifications.setColumnSpecifications(columnSpecifications);
	}

	public LatexTabular addColumnSpecification(LatexColumnSpecification specification)
	{
		this.columnSpecifications.addColumnSpecification(specification);
		return this;
	}

	public LatexTabular addColumnSpecifications(List<LatexColumnSpecification> specifications)
	{
		this.columnSpecifications.addColumnSpecifications(specifications);
		return this;
	}

	public LatexTabular addRow(LatexRow row)
	{
		this.rows.add(row);
		return this;
	}

	public LatexTabular addRows(List<LatexRow> rows)
	{
		this.rows.addAll(rows);
		return this;
	}

	@Override
	protected Iterable<LatexRow> getContents()
	{
		return rows;
	}
}
