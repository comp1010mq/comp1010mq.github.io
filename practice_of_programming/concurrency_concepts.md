---
layout: standard
title: Concepts of Concurrency
within: practice_of_programming
---

<details class="prereq" markdown="1"><summary>Assumed Knowledge</summary>

  * Inheritance and Overloading
  * Generics
  * Exceptions
  * Lambda Expressions
</details>

<details class="outcomes" markdown="1"><summary>Learning Outcomes</summary>

  * Know how to create a `Thread`
  * Know the states a thread might be in
  * Know the problems that might appear in threaded code.

</details>

We start very gently by looking at a game that introduces the concepts of concurrency - [7 Billion Humans](https://tomorrowcorporation.com/7billionhumans)

<iframe width="560" height="315" src="https://www.youtube.com/embed/QcHvaExo8Kk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

There are two other game-play videos that follow up from this one:
  * [Part 2](https://youtu.be/gJSs0UyLdKg)
  * [Part 3](https://youtu.be/0z9TVV_zBmQ)

{: .readings}
[Pages 77 - 82 of "The Well-Grounded Java Developer"](https://manning-content.s3.amazonaws.com/download/e/15b9513-9763-41e7-9178-5cded4d02996/TWGJD_sample_ch04.pdf) by Evans and Verburg.

<div class="task" markdown="1">
You have been provided with [some simple Java code that demonstrates threading](./src/Interleaving.java).  It is clear from the output of this program that the code does not run "from top-to-bottom" as we are used to.  Give an account of what is going on here, including a description of what _state_ each thread is in at any point in the program.  If you experiment with breakpoints you will see some very strange behavour - can you explain it?

<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>
</div>

<div class="task" markdown="1">
You have been provided with [some Java code that demonstrates the different states a `Thread` might be in](./src/ThreadState.java).  Download this code and run it to see what it does.

You should see that it starts up 10 threads all trying to read the time from a webservice.  The webservice doesn't like DOS attacks, so it rejects requests if they come too fast.  For that reason the method that tries to get the time will wait some (random) amount of time before asking.  As the program runs, it will show you the state of each of the 10 threads.  Inspect the source code to see what each code means.  You should convince yourself that you understand what state transitions are happening and why.

<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>

</div>
