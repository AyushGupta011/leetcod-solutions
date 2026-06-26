# INTERVIEW_GUIDE: Shortest Common Supersequence
## **Clarifying Questions to Ask**
Arre bhai, pehle humein clarify karna chahiye ki problem mein kya expected hai. Hum interviewer se following questions pooch sakte hain:
* Kya input strings mein duplicate characters allowed hain?
* Kya input strings empty ho sakti hain?
* Kya humein sirf length of shortest common supersequence chahiye ya phir actual string bhi construct karni hai?

## **Brute Force First**
Theek hai, ab hum brute force approach sochenge. Ismein hum sabhi possible strings generate karenge jo dono input strings ko cover karte hain, aur phir sabse chhoti string ko select karenge. Lekin, yeh approach bahut time-consuming hoga, kyunki humein sabhi possible strings generate karne hongi. Toh, hum is approach ko optimize karenge.

## **The Optimal Approach, Explained**
Optimal approach mein hum Dynamic Programming (DP) use karenge. Hum ek DP table banayenge jismein hum dono input strings ke prefixes ke liye shortest common supersequence ki length store karenge. Phir, hum DP table ko fill karne ke liye iteration karenge, aur har cell mein hum dono input strings ke current characters ko compare karenge. Agar characters match hote hain, toh hum us cell ki value ko previous diagonal cell ki value se 1 joda denge. Agar characters match nahi hote hain, toh hum us cell ki value ko minimum of top cell aur left cell ki value se 1 joda denge.

```c
int** dp = (int**)malloc((m + 1) * sizeof(int*));
for (int i = 0; i <= m; i++) {
    dp[i] = (int*)malloc((n + 1) * sizeof(int));
}
```

## **Complexity, Stated Out Loud**
Ab hum complexity calculate karenge. Time complexity O(m*n) hogi, kyunki hum DP table ko fill karne ke liye m*n iterations karenge. Space complexity bhi O(m*n) hogi, kyunki hum DP table ko store karne ke liye m*n space use karenge.

## **Likely Follow-up Questions**
Ab hum likely follow-up questions sochenge:
* Agar input strings mein duplicate characters allowed hain, toh kya humein shortest common supersequence ki length change karni hogi?
* Agar input strings empty hain, toh kya humein shortest common supersequence ki length 0 hogi?
* Agar humein actual shortest common supersequence string construct karni hai, toh kya hum DP table ko backtrack karke string construct kar sakte hain?

Arre bhai, yeh sab questions humein sochne ke liye milenge, aur humein unka answer dena hoga. Toh, hum taiyaar rahenge!