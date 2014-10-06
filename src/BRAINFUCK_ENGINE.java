import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BRAINFUCK_ENGINE {

	byte arr[]=new byte[10000000];
	int index=arr.length/2;
	int leftIndex=index;
	int rightIndex=index;
	
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
					if(s.isEmpty())
					return false;	
					
					if(s.peek()=='[')
					s.pop();	
					else
					s.push(']');	
					
				}
			}
			
			
		}
		
		if(s.isEmpty())
		return true;
		
		return false;
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
		
		System.out.println((str));
		
		this.interpret(str);
		
	}
	
	
	public void interpret(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='[')
			str=this.EvaluateWhileLoop(i,str);
			else if(str.charAt(i)==',')
			arr[index]=s.nextByte();
			else if(str.charAt(i)=='.')
			System.out.println(arr[index]);
			else
			this.performOperation(str.charAt(i));	
		}
		
		this.printByteArray();
		
	}
	
	public  void performOperation(char ch)
	{
		
		
		if(ch=='<')
		{
			this.index--;
			if(index<leftIndex)
			leftIndex=index;	
		}
		else if(ch=='>')
		{
			this.index++;
			if(index>rightIndex)
			rightIndex=index;	
		}
		else if(ch=='+')
		arr[index]++;
		else if(ch=='-')
		arr[index]--;
	}
	
	
	public String EvaluateWhileLoop(int i,String str)
	{
		
		Queue<Character> q = new LinkedList<Character>();
		int j=0;
		
		for(j=i+1;j<str.length()&&str.charAt(j)!=']';j++)
		{
			
			if(str.charAt(j)=='[')
			{
				str=EvaluateWhileLoop(j, str);
				j--;
				continue;
			}
				
				
			q.add(str.charAt(j));
		}
		
		int size=q.size();
		
		while(arr[index]!=0)
		{
			for(int k=0;k<size;k++)
			{	
					char ch=q.remove();
					this.performOperation(ch);
					q.add(ch);
			}
		}
		
		
		return str.substring(0,i)+str.substring(j+1,str.length());
		
	}
	
	
	public void printByteArray()
	{
		for(int i=leftIndex;i<=rightIndex;i++)
		{
			
			System.out.println("index="+(i-arr.length/2)+" value="+arr[i]);
		}
		
	}
}
