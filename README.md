# JLaTeX
A Java Library that allows interfacing with the LaTeX document preparation system.

## How To Use

Download the src/JLatex Folder. Put it in the same folder as your source code and you should be able to 
```java
import JLatex.*;
```
## Example

A simple use of the library could be:

```java
import java.util.ArrayList;
import java.util.Arrays;
import JLatex.*;
public class JLatexTest {
	public static void main(String[] args){
		@SuppressWarnings("unchecked")
		LatexDoc exm = new LatexDoc("exam","Foobar","May 2017","Aidan Sciortino",null,new ArrayList<String>(Arrays.asList("12pt","addpoints")));
		
		LatexSection intro = new LatexSection("Introduction");
		intro.addContents("Lorem Ipsum Dolor");
		examQuestion q1 = new examQuestion("What is the solution to $1x+2y=4$?", 10);
		examQuestion q2 = new examQuestion("What is the solution to $\\int_1^3(3x+2)dx$?",20);
		questionSet qs = new questionSet();
		qs.addQ(q1);
		qs.addQ(q2);
		exm.addContent(intro);
		exm.addContent(qs);
		System.out.print(exm.toLatexCode());
		exm.toLatexFile("test");
	}
}
class questionSet extends LatexContent{
	private ArrayList<examQuestion> questions = new ArrayList();
	public void addQ(examQuestion q){
		questions.add(q);
	}
	public String toLatexCode() {
		String out = "";
		out += "\\begin{questions}\n";
		for(examQuestion q : questions){
			out += q.toLatexCode();
		}
		out += "\\end{questions}";
		return out;
	}
	
}
class examQuestion extends LatexContent {
	private String question;
	private int points;
	public examQuestion(String question, int points){
		this.question = question;
		this.points = points;
	}
	public String toLatexCode() {
		String out = "";
		out += "\\question[" + points + "]" + question + "\n\n";
		return out;
	}
	
}
```

