import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;


public class mainLine {

	
	public static void main(String args[]) throws IOException
	{
		
		String str="";
		if(args==null)
		{
			str=args[0].toString();
		}
		else{//Scanner s = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String temp="";
		do{
			str=str+temp;
			temp=bf.readLine();
		}while(!temp.equalsIgnoreCase("stop"));
		
		}
		
		
		char arr[]=str.toCharArray();
		char arr2[]=new char[arr.length];
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]=='+'||arr[i]=='-'||arr[i]=='<'||arr[i]=='>'||arr[i]==','||arr[i]=='.'||arr[i]=='['||arr[i]==']')
			{
				arr2[j++]=arr[i];
			}
				
		}
		String finalStr=String.valueOf(arr2);
		finalStr=finalStr.trim();
		System.out.println(finalStr+"aka");
		
		//System.exit(0);
		BRAINFUCK_ENGINE b = new BRAINFUCK_ENGINE();
		b.start(finalStr);
		
		
		
	}
	
		
}
