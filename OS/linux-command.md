#常用命令

##ps

ps 命令列出了系统中运行的当前进程的快照

ps -A 显示所有进程信息

ps -u root 显示指定用户的进程

ps -ef 显示所有进程信息,包括多个终端连接系统时的所有进程

ps -aux 列出目前所有正在内存中的程序

多与grep,more搭配使用

##top

常用的性能分析工具,用于实时监控系统中各个进程的资源占用状况.

显示的信息包括:

* 日期和时间
* 当前登录的用户数
* 进程总数,各种状态的进程数
* CPU,内存,交换空间的用量
* 按活跃程度列出所有进程的实时监控列表

```bash
top - 11:33:13 up 20:12,  4 users,  load average: 0.09, 0.13, 0.13
Tasks: 218 total,   1 running, 217 sleeping,   0 stopped,   0 zombie
%Cpu(s):  0.5 us,  0.3 sy,  0.0 ni, 99.2 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem:  16303576 total,  3988988 used, 12314588 free,   210344 buffers
KiB Swap:  8200188 total,        0 used,  8200188 free,  1990904 cached

  PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND     
15437 waiting   20   0  743204  42192  31552 S   0.7  0.3   0:12.43 gnome-term+ 
 1526 root      20   0  323228  58500  37936 S   0.3  0.4   7:26.54 Xorg        
    1 root      20   0   50892   8496   5524 S   0.0  0.1   0:02.02 systemd     
    2 root      20   0       0      0      0 S   0.0  0.0   0:00.01 kthreadd    
    3 root      20   0       0      0      0 S   0.0  0.0   0:00.17 ksoftirqd/0 
    5 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/0:+ 
    7 root      20   0       0      0      0 S   0.0  0.0   0:28.19 rcu_sched   

```

##uptime

```bash
[waiting@localhost ~]$ uptime
 11:34:26 up 20:13,  4 users,  load average: 0.03, 0.10, 0.12
```
当前时间是11:34:26 ,系统已经运行了20小时13分钟,当前有4个用户登入,系统负荷情况

load average:系统负荷,3个数字分别代表1分钟,5分钟,15分钟内系统的平均负荷,数字范围0-1

使用`w`命令也可以得到系统负荷情况

##pstree

当前所有运行中的进程的树形结构

##df

显示磁盘各个分区的使用情况(容量,已用,可用,已用百分比),统计时包含了文件的元信息,如inode,间接块,超级块等

##du

显示某个目录下文件空间使用情况.统计时不包括文件元信息,一般会比df查出来的已使用的空间小一些
