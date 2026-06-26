# INTERVIEW_GUIDE for Trapping Rain Water
## **Clarifying Questions to Ask**
Kya humein yeh pata hai ki input array mein koi negative numbers hain ya nahi? Kya humein yeh bhi pata hai ki input array sorted hai ya nahi? Aur kya humein yeh bhi pata hai ki input array mein duplicate values hain ya nahi? Are there any constraints on the size of the input array?

## **Brute Force First**
Pehle hum brute force approach se sochenge, jisme hum har ek position par trapped water calculate karenge. Lekin yeh approach O(n^2) time complexity dega, jo ki efficient nahi hai. Isliye hum is approach ko optimize karenge.

## **The Optimal Approach, Explained**
Hum optimal approach mein two pointers technique use karenge. Hum do arrays banayenge, leftMax aur rightMax, jisme hum left aur right pointers ki maximum heights store karenge. Phir hum do pointers, left aur right, ko initialize karenge, jo ki array ke starting aur ending points par honge. Hum phir left aur right pointers ko traverse karenge, aur har ek position par trapped water calculate karenge. Agar left pointer par height chota hai, toh hum leftMax aur height ki difference ko total water mein add karenge. Agar right pointer par height chota hai, toh hum rightMax aur height ki difference ko total water mein add karenge. Hum phir left aur right pointers ko move karenge, aur jo pointer chota hai, usko aage badhayenge.

## **Complexity, Stated Out Loud**
Is approach ki time complexity O(n) hai, kyunki hum array ko sirf ek baar traverse karte hain. Aur space complexity bhi O(n) hai, kyunki hum do arrays banate hain, leftMax aur rightMax. Lekin hum optimized solution mein sirf do pointers use karte hain, toh space complexity O(1) ho jati hai.

## **Likely Follow-up Questions**
Kya humein yeh pata hai ki input array mein koi holes hain ya nahi? Agar haan, toh humein kya karna hoga? 
- Hum phir bhi same approach use karenge, lekin humein holes ko handle karna hoga.
Kya humein yeh pata hai ki input array 2D hai ya nahi? Agar haan, toh humein kya karna hoga? 
- Hum phir bhi same approach use karenge, lekin humein 2D array ko handle karna hoga.
Kya humein yeh pata hai ki input array mein koi duplicate values hain ya nahi? Agar haan, toh humein kya karna hoga? 
- Hum phir bhi same approach use karenge, lekin humein duplicate values ko handle karna hoga.