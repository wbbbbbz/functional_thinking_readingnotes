# 第4章 用巧不用蛮

> 很多函数式编程构造的目的只有一个：从频繁出现的场景中消灭掉烦人的实现细节。

## 4.1 记忆
> “memoization”这个词是英国的人工智能研究者Donald Michie生造出来的，指的是在函数级别上对需要多次使用的值进行缓存的机制。

> 这种缓存函数计算结果的做法，是计算机科学里一种典型的折衷方案：用更多的内存（我们一般不缺内存）去换取长期来说更高的效率。

> 只有纯（pure）函数才可以适用缓存技术。纯函数是没有副作用的函数：它不引用其他值可变的类字段，除返回值之外不设置其他的变量，其结果完全由输入参数决定。java.lang.Math类里面的方法都是纯函数的绝好例子。很显然，只有在函数对同样一组参数总是返回相同结果的前提下，我们才可以放心地使用缓存起来的结果

### 4.1.1 缓存

> 缓存效果好，但也会付出了代价。类中的缓存就代表类有了状态，所有与缓存打交道的方法都不可以是静态的，于是产生了更多的连锁效应。我们可以安排Singleton模式来解决一部分影响，但这样做本身就提高了复杂性，还会带来一箩筐的测试问题。由于是我们自己来操控缓存，那就有责任保障其正确性（比如做一些单元测试）。缓存可以提高性能，但缓存有代价：它提高了代码的非本质复杂性和维护负担。

- 缓存除了代码的正确性，执行环境也需要考虑。比如缓存的量会不会溢出等等。状态必须精心维护

### 4.1.2 引入“记忆”
- 很多现代语言支持记忆特性，不需要记录状态，直接调用提供的记忆方法即可。
  - 命令式编程在控制缓存的时候十分复杂。直接利用提供的记忆方法，可以指定缓存的大小等等，减轻维护成本。
- 开发者的优化很难比语言设计者的优化更高效，因为语言设计者可以触碰底层设施。所以将缓存等问题交给语言，这样效率更高，也能在更高的抽象层次上思考问题

- Scala中没有直接提供记忆机制，但是可以使用getOrElseUpdate()和维护map来进行memiozation。
  ```scala
  def memoize[A, B](f: A => B) = new (A => B) {
    val cache = scala.collection.mutable.Map[A, B]()
    def apply(x: A): B = cache.getOrElseUpdate(x, f(x))
  }
  def nameHash = memoize(hash)
  ```

- 使用记忆技巧时保证函数：
  - 没有副作用
  - 不依赖外部信息
  - 值不可变

## 4.2 缓求值
> 缓求值（lazy evaluation）是函数式编程语言常见的一种特性，指尽可能地推迟求解表达式。缓求值的集合不会预先算好所有的元素，而是在用到的时候才落实下来，这样做有几个好处。第一，昂贵的运算只有到了绝对必要的时候才执行。第二，我们可以建立无限大的集合，只要一直接到请求，就一直送出元素。第三，按缓求值的方式来使用映射、筛选等函数式概念，可以产生更高效的代码。

```scala
print length([2+1, 3*2, 1/0, 5-4])
```
> 这段代码会得到怎样的执行结果，取决于所用编程语言的一项性质：它是严格求值（strict）的，还是非严格求值（non-strict）的（也叫缓求值，lazy）。在严格求值的编程语言里，执行（甚至编译）这段代码，会因为列表中的第三个元素而发生“被零除”异常。而在非严格求值的语言里，它会得出4的结果，准确地报告列表元素的数目。

### 4.2.5 缓求值的好处

1. 可以用它创建无限长度的序列。
2. 减少占用的存储空间。
3. 缓求值集合有利于运行时产生更高效率的代码

### 4.2.6 缓求值的字段初始化
- Scala只要在val声明前面加上“lazy”字样，就可以令字段从严格求值变成按需要求值