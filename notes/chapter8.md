# 第8章 多语言与多范式

> 现代编程语言常常是多范式的，支持多种多样的编程范式，如面向对象、元编程、函数式、过程式，等等。

## 8.3 多范式语言的后顾之忧

> 多范式语言虽然强大，但也要求开发者更注重纪律，才能驾驭好大型的项目。依靠工程纪律来保证所有的开发者都朝着同一个方向努力，是解决协调问题的一种途径。

## 8.5 函数式金字塔
参考[Fractal Programming | Ola Bini: Programming Language Synchronicity](https://olabini.se/blog/2008/06/fractal-programming/)
<img src="http://bp3.blogger.com/_1lBEb_G23HM/SEW3m2ohcVI/AAAAAAAAABs/o2gyeThdb6g/s320/polyglot+layers+-+simple.png"><img src="http://bp0.blogger.com/_1lBEb_G23HM/SEW4Y7H6-PI/AAAAAAAAAB8/e2595lPPbjM/s320/polyglot+layers+-+clojure,+scala+and+javascript.png">
> 使用静态语言来构建把可靠性排在第一位的最底层。在高一级应用层上，他的建议是使用更动态一些的语言，以利用其较为友好、简单的语法来完成用户界面等方面的构建。最后在模型最上方的是DSL层，开发者构造简洁的语言来封装重要的领域知识和工作流。DSL一般采用动态语言来实现，因为它们的一些特性对实现工作较为有利。

> 假如包括数据访问、集成等重要职责在内的所有核心API，都能以值不变性为前提来设计的话，那么所有代码都会大幅度地简化。当然，在这种思路下，数据库和其他基础设施的构建方式也要随之发生变化，但我们知道最后结果一定会表现出由内而外的稳定性。
