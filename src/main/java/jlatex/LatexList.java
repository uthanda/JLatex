package jlatex;

import java.util.ArrayList;
import java.util.List;

public abstract class LatexList<T> extends LatexBlock<T,LatexItem>
{
	private List<LatexItem> items = new ArrayList<>();
	
	protected LatexList(String type)
	{
		super(type);
	}
	
	@SuppressWarnings("unchecked")
	public T addItem(LatexItem item) {
		items.add(item);
		return (T) this;
	}
	
	@SuppressWarnings("unchecked")
	public T addItems(List<LatexItem> items) {
		items.addAll(items);
		return (T) this;
	}

	@Override
	protected Iterable<LatexItem> getContents()
	{
		return items;
	}
}
