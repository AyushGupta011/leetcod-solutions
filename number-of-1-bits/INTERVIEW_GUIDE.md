# INTERVIEW_GUIDE: Number of 1 Bits
Kya hai yeh problem, aur kaise hum isko solve karenge? Let's break it down step by step.

## **Clarifying Questions to Ask**
Pehle, humein kuch sawal puchhne chahiye interviewer se. Jaise:
* Kya input number always positive hoga?
* Kya input number ka range kya hai?
* Kya humein apne solution mein koi specific constraints follow karni hai?
* Kya humein apne solution ki time aur space complexity optimize karni hai?

## **Brute Force First**
Ab, hum brute force approach ko sochte hain. Hum input number ko binary mein convert kar sakte hain, aur phir har bit ko check kar sakte hain ki wo set hai ya nahi. Lekin yeh approach thoda inefficient hoga, kyunki humein har bit ko individually check karna hoga. Isliye, hum yeh approach sirf sochne ke liye use karte hain, aur phir optimize karte hain.

## **The Optimal Approach, Explained**
Ab, hum optimal approach ko dekhte hain. Hum `n` ko `n-1` se AND operation karte hain, jo ki least significant set bit ko clear kar deta hai. Phir, hum `count` ko increment karte hain. Hum yeh process repeat karte hain jab tak `n` zero na ho jaye. Yeh approach efficient hai kyunki humein har bit ko individually check nahi karna padta.

```c
int hammingWeight(int n) {
    int count = 0;
    while (n) {
        n &= (n - 1);
        count++;
    }
    return count;
}
```

## **Complexity, Stated Out Loud**
Ab, hum complexity ko dekhte hain. Time complexity hai O(log n), kyunki humein `n` ke bits ko process karna padta hai, jo ki log(n) ke order mein hai. Space complexity hai O(1), kyunki humein sirf ek constant amount of space chahiye `count` ko store karne ke liye.

## **Likely Follow-up Questions**
Ab, hum kuch follow-up questions ko dekhte hain:
* Kya humein yeh solution ko optimize karna hai agar input number bahut bada ho? - Haan, humein yeh solution ko optimize karna hai agar input number bahut bada ho, kyunki humein har bit ko individually process karna padta hai.
* Kya humein yeh solution ko modify karna hai agar input number negative ho sakta hai? - Haan, humein yeh solution ko modify karna hai agar input number negative ho sakta hai, kyunki humein absolute value ko consider karna padta hai.
* Kya humein yeh solution ko use karna hai agar humein kai input numbers ko process karna hai? - Haan, humein yeh solution ko use karna hai agar humein kai input numbers ko process karna hai, kyunki humein har number ko individually process karna padta hai.