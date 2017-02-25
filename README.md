# MultiThreadingdsdsd
Join method can be used to pause the current thread execution untill and unless the specified thread is dead.By using the join it can ensured that main() is the last thread to finish in java.

Wait Vs Sleep
1. wait() is from object and sleep() is the static method of the thread.
2.wait() releases the lock while sleep doesn't releases the lock while waiting.
3.context : wait() method can only be called from synchronized context i.e. by using synchronized block or synchronized method. sleep() method can be called from any context.
4. wait() : A waiting thread can be awaked by notify() or notifyall() . A sleep thread can be awaked by interrupt or when the time expires.

Daemon Thread:
---------------
A Daemon thread is a thread that doesn't prevent the JVM from exiting when the program finishes but the thread is still runnning. An example of daemon thread in garbage collector.
setDaemon(boolean) can be used to change the thread daemon properties before the thread start.

Thread Dump
------------
Thread dump is list of all the threads active in the JVM, thread dumps are very helpful in analyzing bottlenecks in the application and analyzing deadlock situations. There are many ways using which we can generate Thread dump – Using Profiler, Kill -3 command, jstack tool etc

ThreadLocal:
-------------
The ThreadLocal class in Java enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables.or like the class or object scope this variable will have the scope of the Thread.
