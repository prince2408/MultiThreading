# MultiThreadingdsdsd
Join method can be used to pause the current thread execution untill and unless the specified thread is dead.By using the join it can ensured that main() is the last thread to finish in java.

Wait Vs Sleep
1. wait() is from object and sleep() is the static method of the thread.
2.wait() releases the lock while sleep doesn't releases the lock while waiting.
3.context : wait() method can only be called from synchronized context i.e. by using synchronized block or synchronized method. sleep() method can be called from any context.
4. wait() : A waiting thread can be awaked by notify() or notifyall() . A sleep thread can be awaked by interrupt or when the time expires.
