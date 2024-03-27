package Hackethon;

import java.util.Set;
import java.util.stream.Collectors;

public class TwoString {

    public static String twoStrings(String s1, String s2) {
        Set<Character> ss1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Set<Character> ss2 = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        for (char s : ss1) {
            if (ss2.contains(s)) {
                return "YES";
            }
        }
        
        return "NO";
    }

    // Solution 2:
    /*  
    HashSet<char> h1 = new HashSet<char>(s1);
    HashSet<char> h2 = new HashSet<char>(s2);
    h1.IntersectWith(h2);
    return h1.Any() ? "YES" : "NO"; 
    */
    
    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
