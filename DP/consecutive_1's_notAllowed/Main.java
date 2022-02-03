
// Link of Question ::---->   https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1/#


// // User function Template for Java

class Solution {
    static int mod = (int)1e9+7;
    long countStrings(int n) {
        long oldCountZero = 1;
        long oldCountOne = 1;
        for(int i=2;i<=n;i++){
            long newCountZero = (oldCountZero + oldCountOne)%mod;
            long newCountOne = oldCountZero;
            
            oldCountZero = newCountZero;
            oldCountOne  = newCountOne;
        }
        return ((oldCountZero + oldCountOne)%mod);
    }
}