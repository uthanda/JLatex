package jlatex.table.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jlatex.content.LatexText;
import jlatex.table.LatexColumn;
import jlatex.table.LatexContentRow;
import jlatex.table.LatexHline;
import jlatex.table.LatexRow;

public class RowsBuilder
{
	private List<LatexRow> rows = new ArrayList<>();

	public RowsBuilder addLine()
	{
		rows.add(new LatexHline());
		return this;
	}
	
	public RowsBuilder addRow(LatexRow row)
	{
		rows.add(row);
		return this;
	}
	
	public RowsBuilder addRow(String... row)
	{
		LatexContentRow lcr = new LatexContentRow();
		
		Arrays.asList(row).forEach(c -> lcr.addColumn(new LatexColumn().addContent(new LatexText(c))));
		
		return addRow(lcr);
	}
	
	public List<LatexRow> build()
	{
		return rows;
	}
}