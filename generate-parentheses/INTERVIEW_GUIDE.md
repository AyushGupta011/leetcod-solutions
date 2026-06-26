# INTERVIEW_GUIDE for Generate Parentheses Problem
## **Clarifying Questions to Ask**
Arre, pehle humein clarify karna chahiye ki problem mein kya expected hai. Hum interviewer se following questions puch sakte hain:
* Kya input `n` hamesha positive integer hoga?
* Kya humein empty list return karni chahiye agar `n` 0 hai?
* Kya humein unique combinations hi return karne hain, ya duplicates bhi allow hain?
* Kya humein specific order mein combinations return karne hain, jaise ki lexicographical order?

## **Brute Force First**
Ab hum brute force approach ke baare mein sochte hain. Hum sabhi possible combinations generate kar sakte hain aur phir unhein check kar sakte hain ki woh well-formed hain ya nahi. Lekin yeh approach bahut inefficient hoga, kyunki humein `2^(2n)` combinations generate karne honge. Toh hum yeh approach try kar sakte hain, lekin humein pata hai ki yeh optimal solution nahi hai.

## **The Optimal Approach, Explained**
Ab hum optimal approach ke baare mein sochte hain. Hum backtracking algorithm use kar sakte hain, jismein hum recursively open aur close parentheses add karte hain. Hum `open` aur `close` counters maintain karte hain, jo humein batate hain ki kitne open aur close parentheses ab tak add hue hain. Hum agar `open` counter `n` se kam hai, toh hum open parenthesis add kar sakte hain. Agar `close` counter `open` se kam hai, toh hum close parenthesis add kar sakte hain. Hum yeh process recursively repeat karte hain, jab tak hum `2n` length ki combination nahi banate.

```java
private void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {
    // Base case: if the length of the current combination is equal to 2n, add it to the result list
    if (sb.length() == 2 * n) {
        result.add(sb.toString());
        return;
    }

    // If the number of open parentheses is less than n, add an open parenthesis to the current combination
    if (open < n) {
        sb.append("(");
        backtrack(result, sb, open + 1, close, n);
        sb.deleteCharAt(sb.length() - 1); // backtrack by removing the last character
    }

    // If the number of close parentheses is less than the number of open parentheses, add a close parenthesis to the current combination
    if (close < open) {
        sb.append(")");
        backtrack(result, sb, open, close + 1, n);
        sb.deleteCharAt(sb.length() - 1); // backtrack by removing the last character
    }
}
```

## **Complexity, Stated Out Loud**
Ab hum complexity ke baare mein sochte hain. Humara algorithm ka time complexity `O(4^n / n^(3/2))` hai, kyunki humein `n` pairs ke liye `4^n / n^(3/2)` combinations generate karne honge. Humara space complexity bhi `O(4^n / n^(3/2))` hai, kyunki humein `4^n / n^(3/2)` combinations store karne honge.

## **Likely Follow-up Questions**
Ab hum follow-up questions ke baare mein sochte hain. Interviewer humse following questions puch sakte hain:
* Agar humein `n` pairs ke liye combinations generate karne hain, lekin humein unique combinations hi return karne hain, toh hum kya kar sakte hain?
* Agar humein `n` pairs ke liye combinations generate karne hain, lekin humein specific order mein combinations return karne hain, toh hum kya kar sakte hain?
* Agar humein `n` pairs ke liye combinations generate karne hain, lekin humein duplicates allow nahi hain, toh hum kya kar sakte hain?

Hum in questions ke liye taiyaar ho sakte hain, aur humein pata hai ki humein kya karna hoga. Hum optimal solution ke saath-saath, time aur space complexity ke baare mein bhi sochenge.