import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 */
public class SubStringConcatenation {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(S == null || L==null)
			return result;
		else if(S.length()==0  || L.length == 0)
			return result;
		Map<String,Integer> words = new HashMap<String,Integer>();
		int wordLen = L[0].length();

		for(String s : L)
		{
			if(words.containsKey(s))
				words.put(s, words.get(s)+1);
			else
				words.put(s, 1);
		}

		int totalLen = L[0].length() * L.length;

		for(int i=0;i+totalLen<=S.length();i++)
		{
			String subStr = S.substring(i,i+totalLen);
			if(i==12)
				System.out.println();
			if(isStr(subStr,words,wordLen))
				result.add(i);
		}
		return result;
	}
	public boolean isStr(String subStr,Map<String,Integer> words, int wordLen)
	{
		Map<String,Integer> tmp = new HashMap<String,Integer>();

		for(Map.Entry<String, Integer> entrywords:words.entrySet())
		{
			String key = entrywords.getKey();
			Integer value = entrywords.getValue();
			tmp.put(key, value);
		}
		for(int i = 0; i + wordLen<=subStr.length(); i=i+wordLen)
		{
			String sub = subStr.substring(i,i+wordLen);
			if(!tmp.containsKey(sub)) // not include
			return false;
			else
			{
				tmp.put(sub, tmp.get(sub)-1);
			}
			if(tmp.get(sub)==0)
				tmp.remove(sub);
		}
		if(tmp.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{
		SubStringConcatenation test = new SubStringConcatenation();
		String src = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		List<Integer> result = test.findSubstring(src, words);
		for(int res : result)
			System.out.println(res);
	}
}
