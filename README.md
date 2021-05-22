Develop a program called ATM. It allows customers to deposit and withdraw currency in these denominations: 20, 10, 5, and 1.

Deposit: Customer inputs the number of currency notes in each denomination

Deposit 1) If any input values are negative, print "Incorrect deposit amount".
Deposit 2) If all the input values are zero, print "Deposit amount cannot be zero".
Deposit 3) If the input values are valid, increment the balances of corresponding currency notes and print the available new balances in each denomination and the total balance.

Withdraw: Customer input the amount to withdraw. ATM dispenses the 20, 10, 5, and 1 INR bills as needed. 

Withdraw 1) If the input amount is zero, negative, or over the current balance, print "Incorrect or insufficient funds".
Withdraw 2) If the input amount is in valid range, print the number of current notes dispensed in each denomination. Use the available higher denomination first. Also, print the available new balances in each denomination and the total balance.
Withdraw 3) If any denomination is not available to cover the withdrawal amount, do not reduce the balances. Instead, print "Requested withdraw amount is not dispensable". See Withdraw 3 scenario below.


For example, 

Deposit 1: 10s: 8, 5s: 20
---------------------------------
Balance: 20s=0, 10s=8, 5s=20, 1s=0, Total=180

Deposit 2: 20s: 3, 5s: 18, 1s: 4
-----------------------------------------
Balance: 20s=3, 10s=8, 5s=38, 1s=4, Total=334

Withdraw 1: 75
---------------------
Dispensed: 20s=3, 10s=1, 5s=1
Balance: 20s=0, 10s=7, 5s=37, 1s=4, Total=259

Withdraw 2: 122
----------------------
Dispensed: 10s=7, 5s=10, 1s=2
Balance: 20s=0, 10s=0, 5s=27, 1s=2, Total=137

Withdraw 3: 63
----------------------
Output: "Requested withdraw amount is not dispensable"

Note: At this stage, the ATM has only two 1s currency. So, the withdrawal amount cannot be dispensed.

Withdraw 3: 253
----------------------
Output: "Incorrect or insufficient funds"

Withdraw 4: 0
-------------------
Output: "Incorrect or insufficient funds"

Withdraw 5: -25
----------------------
Output: "Incorrect or insufficient funds"


Tips: This program should be expandable to support 50s and 100s in future. Please allow the program to support any currency denominations with little or no code change.

public class ATM {
   public void deposit(...) {
   }

   public void withdraw(...) {
   }
}


Ensure the following
* Use single class. Include a main method to so that program is runnable.
* Use the java.util.Scanner to receive and process inputs.
* Send the completed exercise as .java file. Cover all the boundary conditions. Exercise will also be evaluated for the coding style.
