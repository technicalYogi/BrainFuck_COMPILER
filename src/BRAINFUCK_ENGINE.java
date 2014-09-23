import java.util.Scanner;
import java.util.Stack;


public class BRAINFUCK_ENGINE {

	byte arr[]=new byte[10000000];
	int index=arr.length/2;
	Scanner s = new Scanner(System.in); 
	
	public boolean BrackedParser(String str)
	{
		Stack<Character> s = new Stack<Character>();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='[')
			s.push('[');
			else
			{
				if(str.charAt(i)==']')
				{
					if(s.peek()=='[')
					s.pop();
					else
					return false;	
				}
			}
			
			
		}
		
		if(s.isEmpty())
		return false;
		
		return true;
	}
	
	
	public void start(String str)
	{
		if(BrackedParser(str)==false)
		{	
			try {
				throw new Exception("UnResolved Compilation Error");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		
		this.interpret(str);
		
	}
	
	
	public void interpret(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!='[')
			this.EvaluateWhileLoop(i,str);
			else if(str.charAt(i)==',')
			arr[index]=s.nextByte();
			else if(str.charAt(i)=='.')
			System.out.println(arr[index]);
			else
			this.performOperation(str.charAt(i));	
		}
		
	}
	
	public  void performOperation(char ch)
	{
		if(ch=='<')
		this.index--;
		else if(ch=='>')
		this.index++;
		else if(ch=='+')
		arr[index]++;
		else if(ch=='-')
		arr[index]--;
	}
	
	
	public void EvaluateWhileLoop(int i,String str)
	{
		
		
		
	}
}
