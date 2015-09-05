import java.util.ArrayList;
import java.util.HashMap;

public class CombinationsOfPhoneNumber {
	private HashMap<Character, String> dict = new HashMap<Character, String>();    
    private ArrayList<String> res = new ArrayList<String>();  
    public void init() 
    {       
        dict.put('2', "abc");     
        dict.put('3', "def");   
        dict.put('4', "ghi");   
        dict.put('5', "jkl"); 
        dict.put('6', "mno");   
        dict.put('7', "pqrs");  
        dict.put('8', "tuv");  
        dict.put('9', "wxyz");    
    }  
    public void dfs(int dep, int maxDep, String s, String ans) 
    {        
        if (dep == maxDep) 
        {           
            res.add(ans);      
            return;        
            
        }       
        for (int i = 0; i < dict.get(s.charAt(dep)).length(); i++)
        {           
            dfs(dep + 1, maxDep, s, ans + dict.get(s.charAt(dep)).charAt(i));    
        }  
    }    
    public ArrayList<String> letterCombinations(String digits) 
    {        
        if (digits.length() == 0)     
        return res;     
        init();     
        dfs(0, digits.length(), digits, "");  
        return res;    
        
    }
}
