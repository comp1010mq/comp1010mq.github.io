---
layout: standard
title: Object Locks
within: practice_of_programming
---

<details class="prereq" markdown="1"><summary>Assumed Knowledge</summary>

  * [Concepts of Concurrency](./concurrency_concepts.html)
</details>

<details class="outcomes" markdown="1"><summary>Learning Outcomes</summary>

  * Understand the effect of the `synchronized` keyword.
  * Trace and predict the effects of object locks on a running program.
  * Explain the safety and liveness tradeoffs that occur using object locks.

</details>

{: .readings}
[Pages 83 - 91 of "The Well-Grounded Java Developer"](https://manning-content.s3.amazonaws.com/download/e/15b9513-9763-41e7-9178-5cded4d02996/TWGJD_sample_ch04.pdf) by Evans and Verburg.

<div class="task" markdown="1">
A [class is provided to you that can get into an inconsistent state](./src/ConsistentStateQ.java).  The included `main` method demonstrates that the inconsistency _can_ happen.  Modify this class using only the `syncronized` keyword to ensure it can never become inconsistent.  What is the fewest number of `synchronized` keywords required?
<details markdown="1"><summary>Solution</summary>
The solution is provided in [this attached java file](./src/ConsistentState.java).  The minimum number of `synchronized` keywords required is 2.
	
</details>
</div>

<div class="task" markdown="1">
You have been provided with [some Java code that demonstrates the different states a `Thread` might be in](./src/ThreadState.java).  Download this code and run it to see what it does.

You should see that it starts up 10 threads all trying to read the time from a webservice.  The webservice doesn't like DOS attacks, so it rejects requests if they come too fast.  For that reason the method that tries to get the time will wait some (random) amount of time before asking.  As the program runs, it will show you the state of each of the 10 threads.  Inspect the source code to see what each code means.

You should experiment with the effect that the `synchronized` keyword will have.  What happens if you synchronize the `getTime` method?  Did the program output show you what you expected?

<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>
</div>

<div class="task" markdown="1">
The [Official Java Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html) has an example of how you can create a deadlock using object locks.  Inspect this example, run it, and work out which thread has ownership of each lock at the point where the program locks up.  Is there a way to unlock the program?  Can you unlock it _without touching the `synchronized` keywords"

<details markdown="1"><summary>Solution</summary>
stay tuned...
</details>
</div>