---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
title: Tech Talk Notes
description: Notes I take during tech talks with the teacher
permalink: /ttnotes/
---

{% include navigation.md %}

Each week during our Tech Talk meeting with the teacher and crossover group, I will be taking notes here on important concepts talked about. Then, come study time, I can look at these bullet points and study stuff efficiently.

## [TT0 - Data Structures](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-0---Data-Structures)
Important Notes and Takeaways:
* A data structure is a method of organizing data. Think of a variable holding a single integer value(ex: int n=4;) or sequences of numbers(ex: int[] numbers=new int[]{ 1,2,3 };) or tables of data, or databases: these are all well-defined data structures.
* Data Structures and organizing data will require students to become more algorithmic in coding.
* Non-Primitive are Arrays, Lists (different types: linear, non-linear, stacks, graphs, queues, trees), Tuple, Dictionary, Set, File
* Imperative programming uses statements to change a program's states
* Objected Oriented Programming uses classes and objects to create objects and instances of them -> constructors, encapsulation, abstraction, polymorphism

Tasks
* Create a dynamic menu perhaps using hashmap or arraylist. Rather than hard coding "case" statements.
* Swap challenge
* Matrix challenge - practicing 2D array manipulation and for loops
* All of these challenges will be encapsulated in an abstract class that makes the menu dynamic.
 
# [TT1 - Linked Lists](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-1:-Linked-Lists-Part-2)
Important Notes and Takeaways:
* Link lists are an advanced type of array that has many child classes most notably stacks and queues. These datastructures are specifically tailored to have a single purpose
* Stacks, as the name suggests, follow the Last in First Out (LIFO) when inputting and retreiving data
* Queues, on the other hand, follow the First in First Out (FIFO) when inputting and retreiving. Kind of like a line at the store where the first person in line is spoken to first.

Tasks
* Practice using queues while having a console interface that allows a user to add to the queue, remove from the queue (dequeue) and printed the size and content of it. Will likely incorporate poll(), remove(), element() functions
* Practice merging sorted queues into a combined sorted queue. Use poll() instead of element() to make it more efficient
* Convert a queue to a stack using iteration and understanding how each data structure works FIFO vs LIFO

# [TT2 - Stacks, ArrayLists](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-2:-Calculator)
Important Notes and Takeaways:
* Reverse Polish Notation (RPN) is typically how computers evaluate mathematical expressions
* They do not involve paranthesis or order of operations but rather follow a simple postfix method. A method that makes it very easy for an algorithm to iterate over a post-fix string rather than store too much memory using the general order of operations methods.
* Algorithms for these can be implemented using a combination of arrayLists and Stacks to "peek" the current value in the expression and hold previous popped values in memory

Tasks
* Using boilerplate given - implement the final function to do the following: 
1. Build a calculator to process expressions and ultimately change RPN to a calculation.
2. Build in Power of operator ^: 2 ^ 1 = 2, 2 ^ 2 = 4, 2 ^ 3 = 8
3. Extra credit. Build variable assignment and evaluation into your expressions (a = 2; a + 1).
4. Extra credit. Investigate Wikipedia article and pseudo code and try adding a SQRT(). Try building Pythagoras expression.

# [TT3 - Sorting Algorithms](https://github.com/nighthawkcoders/nighthawk_csa/wiki/Tri-3:-Tech-Talk-3:-Sorts)
Important Notes and Takeaways
* Sorting is one of the most important concepts in computer science and is used in nearly all types of operations where it be a menial task of sorting an array of number to sorting complex objects by a certain criteria. As a result, the speed and memory necessary to complete these actions are very important and many algorithms have been developed to solve this problem of sorting in the fastest, most memory-efficient way.

Specific Algorithm ANALYSIS
* Bubble sort - compares each element with each other one in the array until placing it in the correct place. Does this for each element. This is done with a double for loop and thus the time complexity is O(n^2). It is O(n) if the array is already sorted
* Selection sort - creates a sorted array by placing a new element one by one in its earliest position. This requires an additional array to be made which is additional memory however the time complexity is also O(n^2) because of the double for loop
* Insertion sort - Inserts elements into the array where it is smaller than the most previous one. This also needs extra memory but is stil O(n^2) time complexity (though its slightly lower when broken down)
* Merge sort - this is the best sort algorithm studied thus far because it takes on a binary-search approach to sorting an array by splitting it in half numerous times to a single comparison and then combining those after. It's time complexity is O(n*logn)