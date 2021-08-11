# CheckMainThreadAndMainProcess
检测当前线程是否是主线程和当前进程是否是主进程

#### 检测是否是主线程

三种思路，分别是：

1. 主线程looper对象和当前looper对象比较，相等则为主线程；
2. 通过主线程looper拿到的主线程和当前looper对象拿到的线程对象比较，相等则为主线程；
3. 通过主线程looper拿到主线程，进而拿到线程id，与当前looper对象拿到的线程的id比较，相等则为主线程；

#### 检测是否为主进程

1. 通过PackageManager拿到主进程的进程名称；通过Process.myPid()方法拿到当前进程的进程id；

2. 通过ActivityManager拿到app所有的进程集合；

3. 遍该集合，匹配当前进程的id，如果匹配上了，再去匹配当前进程的名称是否和主进程名称相等；

   如果相等，则表示是主进程，反之则不是。

####　参考

1. https://www.jianshu.com/p/ff501fdae476
2. https://blog.csdn.net/zhe_ge_sha_shou/article/details/74333408
3. https://www.cnblogs.com/sudawei/p/3527058.html