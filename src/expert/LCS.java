package expert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LCS 
{
    public static void getLongestSubsequenceLength(String str1, String str2) { 
        int[][] lengths = new int[str1.length()+1][str2.length()+1]; 
          
        // special case of zero length for null strings 
        for(int i=0; i < str1.length(); i++) { 
            lengths[i][0] = 0; 
        } 
        for(int j=0; j < str2.length(); j++) { 
            lengths[0][j] = 0; 
        } 
          
        // calculate longest length by dynamic programming 
        for(int i=1; i <= str1.length(); i++) 
        { 
            for(int j=1; j <= str2.length(); j++) 
            { 
                if(str1.charAt(i-1) == str2.charAt(j-1)) 
                { 
                    lengths[i][j] = 1 + lengths[i-1][j-1]; 
                } 
                else 
                { 
                    lengths[i][j] = Math.max(lengths[i][j-1], lengths[i-1][j]); 
                } 
            } 
        } 
          
        int s1position = str1.length(), s2position = str2.length();
        List<Character> result = new LinkedList<Character>();
 
        while (s1position != 0 && s2position != 0)
        {
                if (str1.charAt(s1position - 1) == (str2.charAt(s2position - 1)))
                {
                        result.add(str1.charAt(s1position - 1));
                        s1position--;
                        s2position--;
                }
                else if (lengths[s1position][s2position - 1] >= lengths[s1position][s2position])
                {
                        s2position--;
                }
                else
                {
                        s1position--;
                }
        }
        Collections.reverse(result);
        for(Character ch : result)
        {
        	System.out.print(ch);
        }
        System.out.println("");
    } 
      
    public static void main (String[] args) throws IOException 
    {
    	File file = new File(args[0]);
    	BufferedReader in = new BufferedReader(new FileReader(file));
    	String line;
    	while ((line = in.readLine()) != null) 
    	{
    		String[] lineArray = line.split(";");
    		if (lineArray.length > 0) 
    		{
    			getLongestSubsequenceLength(lineArray[0], lineArray[1]);
    		}
    	}
  }
}
