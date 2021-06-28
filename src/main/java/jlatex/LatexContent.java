package jlatex;

import java.io.PrintWriter;

public abstract class LatexContent
{
	public abstract void write(PrintWriter writer);
	
	public boolean isEmpty() {
		return false;
	}
}
