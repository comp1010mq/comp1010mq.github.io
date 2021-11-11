---
layout: standard
title: Modern Concurrency
within: practice_of_programming
---

<details class="prereq" markdown="1"><summary>Assumed Knowledge</summary>

  * <a href="/practice_of_programming/concurrency_concepts.html">Concepts of Concurrency</a>
  * <a href="/practice_of_programming/concurrency_objectlocks.html">Object Locks</a>
</details>

<details class="outcomes" markdown="1"><summary>Learning Outcomes</summary>

  * Use modern concurrency techniques to solve the problems we discovered earlier

</details>


{: .readings}
[Pages 91 - 111 of "The Well-Grounded Java Developer"](https://manning-content.s3.amazonaws.com/download/e/15b9513-9763-41e7-9178-5cded4d02996/TWGJD_sample_ch04.pdf) by Evans and Verburg.

<div class="task" markdown="1">
We have provided for you a _non thread-safe_ producer-consumer implementation:

  * <a href="src/prodcons_advlocks/Main.java">`Main.java`</a>
  * <a href="src/prodcons_advlocks/BoundedBuffer.java">`BoundedBuffer.java`</a>
  * <a href="src/prodcons_advlocks/Producer.java">`Producer.java`</a>
  * <a href="src/prodcons_advlocks/Consumer.java">`Consumer.java`</a>

This implementation is not thread-safe because the bounded buffer could be put in an inconsistent state.  This inconsistent state will occur if _either_ `put` or `get` are interrupted in the middle of execution.  In particular, if either method is interrupted between adding/removing the new value to array and updating `mNext` then the buffer will lose or repeat values.

Use one of the techniques you have learned about in the above readings to make this producer-consumer thread-safe without locking it up.

Note, it is quite hard to get the bounded buffer in in inconsistent state - bragging rights go to anyone that can make a program that _always_ and _demonstrably_ gets into an inconsistent state.
<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>
</div>

<div class="task" markdown="1">
Imagine you want to add motion blur to an image.  Such an algorithm would replace any pixel value with some combination of the pixel values "to the right" of that pixel.  So you can experiment with the speed you can get for this type of algorithm so we have provided a [`Main.java`](src/countdown/Main.java) that performs just such a computation.  

The code will time itself and report how long it took to run. Your job is to make a multi-threaded version of this code that is faster than the reference implementation above.  

Use one of the modern concurrency techniques described in "The Well-Grounded Java Developer" to achieve this as simply as possible.

There are a number of possible solutions.  You can consider a countdown latch or you might try an executor service.
<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>

</div>
