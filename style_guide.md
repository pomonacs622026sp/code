# CS62 - Style Guide

## General Information

Like English prose, computer programs can be presented clearly and elegantly. Part of the course is to develop your stylistic judgment and teach you how to write clean, crisp, and correct code. The guidelines here, although by no means complete or authoritative, give you a place to start.

A program is not merely a set of instructions to the computer. It is also a means of communication among people. In real life--as opposed to Computer Science courses--programs are written by many people over months or even years. It is critically important that others can easily understand your work. The overall format, comments, and the choice of names all contribute to the clarity of your work and deserve close attention.

## General Structure

* Be consistent. You may experiment with different formats at different times, but do not do it in a single file.
* Pay attention to style from the time you begin to write, and use it as an aid in structuring your code. Contrary to your feelings as time runs short, it is *never* expedient to write sloppy code and "fix it" later.
* Review your work before you submit it. Be certain that it is *both* correct and well-presented.

## Blank Lines and Indentation

* Use blank lines to separate logically separate parts of a program. For example, methods should be separated by a blank line. Also, long blocks of code should be broken into logical "paragraphs" with blank lines. On the other hand, do not insert blank lines where they would separate closely related parts of your code.
* Use indentation consistently. 
* Give each declaration and statement its own line. Or, equivalently, start a new line after a semicolon.
* Don't make lines too long (< 80 characters is a good rule) as they may get truncated or wrapped when printing - making the code unreadable in either case. You can break a statement over multiple lines and often make it more readable.

## Braces

- Use { } braces around the statements of all if, while, do, and ‘for’ statements.

- Place a } brace on the same line as a following else, finally, or catch, as in
```
if (x > 0) {
   y = -x;
} else {
   y = x;
}
```
- Put the { that opens a block at the end of a line. Generally, it goes at the end of the if, for, while, switch, do, method header, or class header that contains it. If line length forces it to the next line, do not indent it, and put it alone on the line.


## Whitespace


Do NOT put whitespace:

- Around the < and > within a generic type designation (List<Integer>, not List <Integer>, or List< Integer >).
- After the prefix operators !, --, ++, unary -, or unary +.
- Before the tokens ; or the suffix operators -- and ++.
- After ( or before ).
- After .

DO put whitespace:

- After ;, ,, or type casts (e.g., (String) x, not (String)x).
- Around binary operators (e.g., *, +) and comparison operators.
- Around assignment operators (e.g., =, +=).
- Around ? and : in the ternary conditional operator (x > 0 ? x : -x).
- Around the keywords assert, catch, do, else, finally, for, if, return, try, and while.





## Comments

1. Each part of your program should be introduced by a comment that indicates its purpose, semantics, and use. Early in the course, we will explore the JavaDoc system that promotes this kind of documentation.
* A class (or program) is normally in a separate file, unless it is an "inner class." It should begin with a comment that states who wrote the code, when, and why. This is the place to advertise any special features of your code. Be sure to use the `@author` javadoc tag.
* Each method should be preceded with a comment that tells what the method does, what each parameter signifies, and what value (if any) is returned. Use `@param`, `@return`, and `@throws` as appropriate.
* Pre and post-conditions should be included in the comments for a method. The `@return` tag will normally include the postcondition in cases where the method returns a value. Preconditions for public methods should be checked at the beginning of a method, with an appropriate exception thrown if the precondition fails. Preconditions for private methods can be checked using an `assert` statement as their failure indicates an error by the programmer of the class, making it hard to recover from the error dynamically.Post-conditions are typically also checked via an assert statement, whether the method is public or private. If evaluating the assert statement is too expensive (e.g., essentially involves re-executing the method) then the assert statement may be omitted.
* Each variable, or block of closely related variables, should have a comment indicating the purpose of the variable.
 
2. Avoid over-commenting. If there are sufficient general comments, as discussed above, then line-by-line comments will often be unnecessary. In particular, avoid useless comments like the one below.
```
n = n + 1 // add one to n
```

3. Comments should go above the code or, in the case of very short comments, to the right. Always put a blank line before a comment. Indent comments by the same amount as the code.

4. As you are developing and testing a program, it is often useful to "comment out" blocks of code. But the code you submit should have no such comments.

5. Comments on variables and methods should be entered when the code is first typed in. This will make it much easier for you and the instructor or TA to figure out what your program is actually doing versus what you think it may be doing.

## Variables and Names

* Instance variables should be used sparingly, and they should never be `public`. When necessary, provide methods to allow the user of a class to access or modify internal data.
* Use descriptive names. If you are working on a program that simulates a bank account, `balance` is a good name (if the quantity is actually a balance!), while `b` or `boris` are not. For the most part, one-character names are appropriate only when they are used locally within a very small block of code.
* The convention in Java is to use all lowercase for variable and method names. Class names begin with an uppercase letter, and names of static final constants must be in all capitals (e.g., RED, DEFAULT_NAME).
* When a name is a "compound word," the second and subsequent words begin with an uppercase letter (i.e. camelcase). Examples: `ArrayList`, `binarySearch`, `hashCode`.
* Names of packages must start with a lower-case letter.
* Names of instance variables and non-final class (static) variables must start with either a lower-case letter or `_`.

## Importing

- Do not import the same class or static member twice.
- Do not import classes or members that you do not use.

## Assorted Java Style Conventions

- Write array types with the [] after the element-type name, not after the declarator. Write `String[] names`, not `String names[]`.

- Write any modifiers for methods, classes, or fields in the following order:
    - public, protected, or private.
    - abstract or static.
    - final

- Do not explicitly modify methods, fields, or classes where the modification is redundant:
    - Do not label methods in interfaces or annotations as “public” or “abstract”.
    - Do not label fields in interfaces or annotations as “static”, “public”, or “final”.
    - Do not label methods in final classes as “final”.
    - Do not label nested interfaces “static”.

- Avoid “magic numbers” in code and instead give them symbolic names, as in

`public static final int MAX_SIZE = 100;`


- Do not try to catch the exceptions Exception, RuntimeError, or Error.

- Write “b” rather than “b == true” and “!b” rather than “b == false”.

- Replace
```
if (condition) {
   return true;
} else {
   return false;
}
```
with just
```
return condition;
```
- Only static final fields of classes may be public. Other fields must be private or protected. This applies to nested classes as well.

- Classes that have only static methods and fields must not have a public (or defaulted) constructor.

- Classes that have only private constructors must be declared “final”.

- Do not compare String literals with “==”. Write

`if (x.equals("something"))`

and not

`if (x == "something")`

## Limits

- No file may be longer than 2000 lines.

- No line may be longer than 120 characters.

- No method may be longer than 80 lines.

- No method may have more than 8 parameters.

- Every file must contain exactly one outer class (nested classes are OK).


## Additional Resources

For a more comprehensive handout, checkout the [official handout of Java code conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf).