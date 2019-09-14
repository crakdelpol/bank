# Bank
<h4> Instructions</h4> 

Write a class named Account that implements the following public interface:

```
public interface AccountService
{
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
```
<h4> Rules </h4>
You cannot change the public interface of this class.

<h4> Desidered Behaviour </h4>
Here's the specification for an acceptance test that expresses the desired behaviour for this

_Given_ a client makes a deposit of 1000 on 10-01-2012  
_And_ a deposit of 2000 on 13-01-2012  
_And_ a withdrawal of 500 on 14-01-2012  
_When_ they print their bank statement  
_Then_ they would see:

```
Date       || Amount || Balance
14/01/2012 || -500   || 2500
13/01/2012 || 2000   || 3000
10/01/2012 || 1000   || 1000
```

<h4> Notes </h4>

* We're using ints for the money amounts to keep the auxiliaries as simple as possible. In a real system, we would always use a datatype with guaranteed arbitrary precision, but doing so here would distract from the main purpose of the exercise.   

* Don't worry about spacing and indentation in the statement output. (You could instruct your acceptance test to ignore whitespace if you wanted to.)  

* Use the acceptance test to guide your progress towards the solution. Sandro does this by making all unimplemented methods throw an exception, so that he can immediately see what remains to be implemented when he runs the acceptance test.

* When in doubt, go for the simplest solution!

See more about this exercice: https://katalyst.codurance.com/bank