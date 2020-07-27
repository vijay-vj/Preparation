package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findDistinct' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY names
     *  2. STRING prefix
     */

    public static List<String> findDistinct(List<String> names, String prefix) {
    	List<String> result = new ArrayList<String>();
    	for(int i =0; i<names.size(); i++) {
    		String name = names.get(i); 
    		if(name.startsWith(prefix)) {
    			result.add(name+" - "+uniqueCharacters(name));
    		}
    	}
    	System.out.println(result);
    	return result;
    }
    
    public static int uniqueCharacters(String test){
        String temp = "";
        HashMap<Character, Integer> unique = new HashMap<Character, Integer>();
        for(int i=0; i<test.length(); i++) {
        	if(unique.containsKey(test.charAt(i))){
        		
        	}else {
        		unique.put(test.charAt(i), 1);
        		temp = temp + test.charAt(i);
        	}
        }
        return temp.length(); 

    }
}

public class findDistinctCharsCountPaypal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int namesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = IntStream.range(0, namesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String prefix = bufferedReader.readLine();

        List<String> result = Result.findDistinct(names, prefix);
        
//        bufferedWriter.write(
//            result.stream()
//                .collect(joining("\n"))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
