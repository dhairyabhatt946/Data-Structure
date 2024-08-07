// Vowel Anxiety
// Utkarsh has recently started taking English-language classes to improve his reading and writing skills. However, he is still struggling to learn English. His teacher gave him the following problem to improve his vowel-identification skills:

// There is a string 
// 𝑆
// S of length 
// 𝑁
// N consisting of lowercase English letters only. Utkarsh has to start from the first letter of the string.
// Each time he encounters a vowel (i.e. a character from the set 
// {
// 𝑎
// ,
// 𝑒
// ,
// 𝑖
// ,
// 𝑜
// ,
// 𝑢
// }
// {a,e,i,o,u}) he has to reverse the entire substring that came before the vowel.

// Utkarsh needs help verifying his answer. Can you print the final string after performing all the operations for him?

// Input Format
// First line will contain 
// 𝑇
// T, number of test cases. Then 
// 𝑇
// T test cases follow.
// The first line of each test case contains 
// 𝑁
// N, the length of the string.
// The second line contains 
// 𝑆
// S, the string itself.
// Output Format
// For each test case, output in a single line the final string after traversing 
// 𝑆
// S from left to right and performing the necessary reversals.


import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Stack;

public class Lab7_44 {
    

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            String str = sc.next();

            Stack<Character> s = new Stack<>();

            String ans = "";
            for(int i = 0 ; i < str.length() ; i++){
                if("aeiou".indexOf(str.charAt(i)) > -1){
                    ans = "";
                    while(!s.isEmpty()){
                        ans += s.pop();
                    }
                    ans += str.charAt(i);
                    for(char c : ans.toCharArray()){
                        s.push(c);
                    }
                }
                else{
                    s.push(str.charAt(i));
                }
            }

            StringBuilder temp = new StringBuilder();
            while(!s.isEmpty() && "aeiou".indexOf(s.peek()) < 0){
                temp.append(s.pop());
            }

            ans += temp.reverse().toString();
            System.out.println(ans);
            t--;
        }

	}
}