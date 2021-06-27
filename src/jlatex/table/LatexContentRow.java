package jlatex.table;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LatexContentRow extends LatexRow
{
	private List<LatexColumn> columns = new ArrayList<>();
	
	public List<LatexColumn> getColumns()
	{
		return columns;
	}

	public void setColumns(List<LatexColumn> columns)
	{
		this.columns = columns;
	}

	public LatexContentRow addColumn(LatexColumn column)
	{
		this.columns.add(column);
		return this;
	}

	@Override
	public void write(PrintWriter writer)
	{
		columns.forEach(column -> column.write(writer));
		writer.println(" \\\\\n");
	}
}
