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