# 1. 数组
## 1.1. 特性
* 连续内存
	* 可知任意元素的地址 -> 查询O(1)
	* 数组中间位置进行 增/删 操作需要移动其它元素 -> 增/删O(n)

## 1.2. 实现
[ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

# 2. 链表

## 2.1. 特性

* 不连续内存
	* 查询需要遍历节点 -> 查询O(n)
	* 可在任意位置 增/删 节点 -> 增/删O(1)

## 2.2. 分类

1. 单向链表
	* 链表的链接方向是单向的
	* 每个节点都有指针成员变量指向列表中的下一个节点
2. 双向链表
	* 每个节点中都有两个指针，分别指向直接后继和直接前驱

## 2.3. 实现
[双向链表 LinkedList]()

# 3. 跳表 skip list

## 3.1. 产生原因

为加速链表的查询速度

## 3.2. 特点

*	只能用于元素有序的情况
*	增/删/查 时间复杂度都为O(log n)
*	空间复杂度O(n)

## 3.3. 优势

1. 原理简单
2. 容易实现
3. 方便扩展
4. 效率更高（查询效率高于链表）

## 3.4. 思想

* 一维的数据结构要加速，经常采用的方式是升级到二维
* 空间换时间

## 3.5. 实现

* Redis
* LevelDB

# 4. 栈 Stack

## 4.1. 特点

* 后进先出 -> 增/删 O(1)
* 元素无序 -> 查询O(n)

# 5. 队列 Queue

## 5.1. 特点

* 先进先出 -> 增删 O(1)
* 元素无序 -> 查询 O(n)

## 5.2. Queue.java

### 5.2.1. 说明

* 是个接口
* 继承自 Collection

	> public interface Queue<E\> extends Collection<E\>

### 5.2.2. API

* boolean add(E e);
	> 添加元素到队列尾部。成功返回true，失败抛出IllegalStateException异常。
* boolean offer(E e);
	> 添加元素到队列尾部。成功返回true，失败返回false。
* E remove();
	> 从队列头部删除元素。成功返回头部元素，队列为空时抛出NoSuchElementException异常。
* E poll();
	> 从队列头部删除元素。成功返回头部元素，队列为空时返回null。
* E element();
	> 检索队列头部元素（不删除）。成功返回头部元素，队列为空时抛出NoSuchElementException异常。
* E peek(); 
	> 检索队列头部元素（不删除）。成功返回头部元素，队列为空时返回null。

# 6. 双端队列 Deque

## 6.1. 特点

* 头尾两端均可 增/删 元素

# 7. 优先队列 Priority Queue

## 7.1. 特点

* 根据优先级出队
* 查询O(log n)
* 增/删O(1)

## 7.2. PriorityQueue.java

### 7.2.1. 说明

* 是个具体类
* 继承 AbstractQueue

	> public class PriorityQueue<E\> extends AbstractQueue<E\> implements java.io.Serializable

### 7.2.2. 成员变量

* queue
	> transient Object[] queue; //数据结构为数组
* size
	> private int size = 0; //队列中元素的个数
* comparator
	> private final Comparator<? super E> comparator; //比较器。默认为自然顺序
* modCount
	> transient int modCount = 0; //队列被修改的次数

### 7.2.3. API

* boolean add(E e)
	* 直接调用 offer 接口
* boolean offer(E e) 
	* 添加元素
	* 增加修改次数 modCount
	* 判断是否扩容
	* 根据优先级插入数据（有序队列）

