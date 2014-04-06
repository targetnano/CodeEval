package moderate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*CHALLENGE DESCRIPTION:

Write a program to read a multiple line text file and write the 'N' longest lines to stdout. 
Where the file to be read is specified on the command line.

INPUT SAMPLE:

Your program should read an input file (the first argument to your program will be a path to a filename). 
The first line contains the value of the number 'N' followed by multiple lines. You may assume that the 
input file is formatted correctly and the number on the first line i.e. 'N' is a valid positive integer. E.g.

2
Hello World
CodeEval
Quick Fox
A
San Francisco

OUTPUT SAMPLE:

The 'N' longest lines, newline delimited. Ignore all empty lines in the input. 
Ensure that there are no trailing empty spaces on each line you print. Also ensure that 
the lines are printed out in decreasing order of length i.e. the output should be sorted based on their length. E.g.

San Francisco
Hello World
*/

/**
 * A Comparator for the Priority queue where
 * string length is the priority
 * 
 * @author Kavi
 *
 */
class AscendingComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    {
        if (x.length() < y.length())
        {
            return -1;
        }
        if (x.length() > y.length())
        {
            return 1;
        }
        return 0;
    }
}

class DescendingComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    {
        if (x.length() < y.length())
        {
            return 1;
        }
        if (x.length() > y.length())
        {
            return -1;
        }
        return 0;
    }
}

public class NLongestLines 
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fstream = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String firstLine = br.readLine();
		if(firstLine == null || firstLine.length() == 0)
		{
			return;
		}
		int n = Integer.parseInt(firstLine);
		String line;
		
		/* Using a minHeap to store N Longest strings at any point */
        PriorityQueue<String> minHeap = new PriorityQueue<String>(n, new AscendingComparator());
        
        /* Using a maxHeap to push all nodes from minHeap to get strings of descending length */
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(n, new DescendingComparator());
        
		//Read File Line By Line
		while ((line = br.readLine()) != null)   
		{
			if(minHeap.size() < n)
				minHeap.add(line);
			else
			{
				int leastLength = minHeap.peek().length();
				if(line.length() > leastLength)
				{
					minHeap.remove();
					minHeap.add(line);
				}
			}
		}
		
		while(minHeap.size() != 0)
		{
			maxHeap.add(minHeap.remove());
		}
		while(maxHeap.size() != 0)
		{
			System.out.println(maxHeap.remove());
		}
	}
}