#volatile

对一个volatile变量的单个读/写操作,与对一个普通变量的读/写操作使用同一个锁来同步,他们之间的执行效果相同

即使是64位的long型或double型变量,只要是volatile的,对该变量读写也是原子的.
但是多个volatile操作或者是volatile++这种复合操作,整体上不具有原子性.

volatile变量的特性:

* 可见性
* 原子性(限于对单个volatile变量的读/写)

##volatile变量的写-读 可以实现线程间通信


