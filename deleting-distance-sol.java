/*
The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:

By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.
Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance between them. Explain how your function works, and analyze its time and space complexities.

Examples:

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0
Constraints:

[input] string str1
[input] string str2
[output] integer

*/

import java.io.*;
import java.util.*;

class Solution {

 
  static int lcs(String s1, String s2){
    //String lcsString="";
    //code for lcs here 
    int len1=s1.length();
    int len2=s2.length();
    int[][] dp=new int[len1+1][len2+1];
    for(int i=0;i<=len1;i++){
      for(int j=0;j<=len2;j++){
          if(i==0 || j==0)
          {
            dp[i][j]=0;
          }
          if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1]+1;
          }else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
          }
      }
    }
    
    
    
    return dp[len1][len2];
  }
  
  static int deletionDistance(String str1, String str2) {
    // s1= teah s2=hit
    //s1 = teah s2=ateh
    int lcs=lcs(str1,str2);
    return (str1.length()-lcs))+(str2.length()-lcs;
      
    
    
   
  }

  public static void main(String[] args) {

  }

}
