package moderate;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

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