package expert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringList 
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
			
				String pieces[] = line.split(",");
				int n = Integer.parseInt(pieces[0]);
		        char[] chars = pieces[1].toCharArray();
		        Arrays.sort(chars);
		        String sortedString = new String(chars);

				permute(sortedString, permutations, n);
				System.out.print(permutations.remove(0));
				for(String str : permutations)
				{
					System.out.print("," + str);
				}
				System.out.println("");
			}
		}
	}

    private static void permute(String s, List<String> permutations, int n) 
    { 
        permute(new ArrayList<Character>(), s, permutations, n); 
    } 
      
    private static void permute(List<Character> soFar, String str, List<String> permutations, int n) 
    { 
        if(n == soFar.size()) 
        { 
        	StringBuilder sb = new StringBuilder();
        	for(Character ch : soFar)
        	{
        		sb.append(ch);
        	}
        	if(permutations.contains(sb.toString()))
        	{
        		return;
        	}
            permutations.add(sb.toString());
        } 
        else 
        { 
            for(int i=0; i < str.length(); i++) 
            { 
            	soFar.add(str.charAt(i));
                permute(soFar, str, permutations, n);
                soFar.remove(soFar.size() - 1);
            } 
        } 
    } 
}
