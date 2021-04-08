import java.util.*;
import java.io.*;
public class LetterCombinationsOfNumber
{
	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public static void main(String...args)
	{
		String digits = getInputDigits();
		
		ArrayList<String> empty = new ArrayList<String>();
		Map_Setter();
        if(digits.length() == 0)
            System.out.println(empty);
        
        else if(digits.length() == 1)
            System.out.println(map.get(digits));
		
		else
		{
			ArrayList<String> combinations = Get_Combinations(0, digits.length() - 1, digits);
			System.out.println(combinations);
		}
	}
	
	public static String getInputDigits()
	{
		String input = "";
		try {
				File file = new File("C:\\Users\\yash\\Desktop\\Internships\\NodeJS_HTTP_Request_Handling\\input.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String st;
				while ((st = br.readLine()) != null)
				{
					input = input + st;
				}
			}
			
		catch(IOException e) 
		{
			  e.printStackTrace();
		}
		
		return input;
	}
	
	public static ArrayList<String> Get_Combinations(int start, int end, String digits)
    {
        if(start == end)
            return map.get(Character.toString(digits.charAt(start)));
            
        int mid = (start + end) / 2;
        
        if(!map.containsKey(digits.substring(start, mid + 1)))
            map.put(digits.substring(start, mid + 1), Get_Combinations(start, mid, digits));
        
        if(!map.containsKey(digits.substring(mid + 1, end + 1)))
            map.put(digits.substring(mid + 1, end + 1), Get_Combinations(mid + 1, end, digits));
        
        return (ArrayList<String>)Combination(map.get(digits.substring(start, mid + 1)), map.get(digits.substring(mid + 1, end + 1)));
        
    }
    
    public static List<String> Combination(List<String> Prefix, List<String> Suffix)
    {
        ArrayList<String> permutations = new ArrayList<String>();
        for(String prefix : Prefix)
        {
            for(String suffix : Suffix)
                permutations.add(prefix + suffix);
        }
        
        return permutations;
    }
	
	public static void Map_Setter()
    {
        ArrayList<String> two = new ArrayList<String>();
        two.add("a"); two.add("b"); two.add("c");
        map.put("2", two);
        
        ArrayList<String> three = new ArrayList<String>();
        three.add("d"); three.add("e"); three.add("f");
        map.put("3", three);
        
        ArrayList<String> four = new ArrayList<String>();
        four.add("g"); four.add("h"); four.add("i");
        map.put("4", four);
        
        ArrayList<String> five = new ArrayList<String>();
        five.add("j"); five.add("k"); five.add("l");
        map.put("5", five);
        
        ArrayList<String> six = new ArrayList<String>();
        six.add("m"); six.add("n"); six.add("o");
        map.put("6", six);
        
        ArrayList<String> seven = new ArrayList<String>();
        seven.add("p"); seven.add("q"); seven.add("r"); seven.add("s");
        map.put("7", seven);
        
        ArrayList<String> eight = new ArrayList<String>();
        eight.add("t"); eight.add("u"); eight.add("v");
        map.put("8", eight);
        
        ArrayList<String> nine = new ArrayList<String>();
        nine.add("w"); nine.add("x"); nine.add("y"); nine.add("z");
        map.put("9", nine);
    }
}