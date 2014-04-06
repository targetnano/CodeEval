package expert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations 
{

	public static void main (String[] args) throws IOException 
	{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) 
		{
			if (line.length() > 0) 
			{
				List<String> permutations = new ArrayList<String>();
			
		        char[] chars = line.toCharArray();
		        Arrays.sort(chars);
		        String sortedString = new String(chars);

				permute(sortedString, permutations);
				System.out.print(permutations.remove(0));
				for(String str : permutations)
				{
					System.out.print("," + str);
				}
			}
			System.out.println("");
		}
	}

    private static void permute(String s, List<String> permutations) 
    { 
        permute("", s, permutations); 
    } 
      
    private static void permute(String soFar, String rest, List<String> permutations) 
    { 
        if(rest.length() == 0) 
        { 
            permutations.add(soFar);
        } 
        else 
        { 
            for(int i=0; i < rest.length(); i++) 
            { 
                String next = soFar + String.valueOf(rest.charAt(i)); 
                String remaining = rest.substring(0,i) + rest.substring(i+1); 
                permute(next, remaining, permutations); 
            } 
        } 
    } 
}
