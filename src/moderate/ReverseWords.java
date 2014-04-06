package moderate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fstream = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		
		while((line = br.readLine()) != null)
		{
			if(line.length() == 0)
				continue;
			String pieces[] = line.split(" ");
			for(int i = pieces.length - 1; i > 0; i--)
			{
				System.out.print(pieces[i] + " ");
			}
			System.out.println(pieces[0]);
		}
	}
}
