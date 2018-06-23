1. 性能考虑，数组首选
2. 数组扩容，可以使用Arrays.copyOf，但是要注意该拷贝是浅拷贝；集合扩容使用的就是Arrays.copyOf，因为不使用拷贝前数据，所以浅拷贝也没影响
3. 明确场景下，为集合指定初始容量
4. 获取最值，数组性能高（自己写算法），集合使用简单：先排序后取值可以很方便的获得最大值，第二大值，最小值或第二小值（最大不一定就比第二大大，有可能相等）
5. 基本数据类型转列表问题：注意基本类型不能泛型化，使用Arrays.asList转换基本类型数组得到长度为1的列表，如果转换引用类型数据，得到的便是长度为数组长度的列表
6. Arrays.asList得到的ArrayList对象不能修改；因为Arrays.asList返回的是自己内部类的ArrayList对象，不是java.util.ArrayList类
7. 不同列表选择不同遍历方法：ArrayList使用for循环下标方式遍历比foreach（或for冒号）快，由于ArrayList实现了RandomAccess接口（随机存取接口），所以支持使用迭代器取数，但是在使用迭代器取数时要先创建一个迭代器容器，来让上下元素之间产生关系，这样就比直接通过下标取数慢了；LinkedList使用双向链表方式存取数据，原生上下元素间就存在关系，所以LinkedList适合使用foreach取数，代码示例
    <pre>
    //······
    if(list instanceOf RandomAccess){
        //可以随机存取，则使用下标遍历
        for(int i=0;i&lt;list.length;i++){
            //······
        }
    }else{
        //有序存取，使用foreach方式
        for(Object obj:list){
            //······      
        }
    }
    //······
    </pre>
8. 频繁插入和删除时使用LinkedLIst：ArrayList插入和删除是通过本地方法System.arraycopy来每次扩容和缩容实现，虽然本地方法效率高，但频繁插入和删除，每次都拷贝，效率就低了；而LinkedList是双向链表，只需修改next和previous引用；如果都是普通新增（尾部插入）效率相当；修改操作的话，ArrayList比LinkedList效率高，因为ArrayList只需根据索引修改，而LinkedList要遍历查找到要修改的对象位置，再修改。
9. 列表做equals比较，比较的是容器内元素（注意和添加顺序也有关）：示例代码
    <pre>
    ArrayList<String> strList=new ArrayList<>();
    strList.add("AAA");
    Vector<String> strVec=new Vector<>();
    strVec.add("AAA");
    System.out.println(strList.equals(strVec));//输出true
    </pre>
ArrayList和Vector都实现List接口，并继承AbstractList抽象类，其equals方法是AbstractList中的，其实现就是先判断是否实现List，然后迭代器遍历其中元素分别比较（迭代过程顺序不同导致比较的值不同也返回false）
10. 子列表只是原列表的一个视图：使用list.subList获取的是基于原list的SubList类对象，通过源码可知该子列表是通过改变原列表索引得到的新视图数据，所以对子列表的处理也会影响原列表
    <pre>
    List<String> strList=new ArrayList<>();
    strList.add("A");
    strList.add("B");
    strList.add("C");
    List subList=strList.subList(0,2);
    System.out.println(StringUtils.join(subList));//[A, B]
    //注意不要通过strList添加，会抛出ConcurrentModificationException异常，下面解释
    subList.add("D");
    System.out.println(StringUtils.join(subList));//[A, B, D]
    System.out.println(strList);//[A, B, D, C]
    </pre>
11. 生成子列表后不要再操作原列表：生成子列表后，如果再操作原列表增删数据，在使用子列表时就会抛出ConcurrentModificationException异常，主要是触发了checkForComodification方法，去校验subList中expectedModCount和生成子列表时的修改次数modCount，不一致便会抛出异常（注意：list.set修改操作没事）
12. 让实体类实现Comparable泛型接口进行排序，使用Collections.sort(list)，临时反排序使用Collections.reverse(list);<br/>如果不想使用实体类的排序，可以自己通过新写一个泛型接口Comparator实现类来实现，方式如Collections.sort(list,new XXXComparetor())，临时反排序使用Collections.sort(list,Collections.reverseOrder(new XXXComparator()))；<br/>如果一个实体类想通过多个字段按照优先级排序，则实体类中compareTo方法可以如下方式写,先按name排序再按age排序
    <pre>
      @Override
        public int compareTo(Person o) {
            return new CompareToBuilder().append(name,o.name).append(age,o.age).toComparison();
        }
    </pre>
13. 集合中的元素必须做到comparaTo和equals同步：在集合中查找元素时使用到的indexOf是通过equals方法来查找，而binarySearch是要先排序后查找，依据compareTo，如果返回0则表示找到
14. 集合运算：1）、并集：lista.addAll(listb)；2）、交集：lista.retainAll(listb)；3）、差集：lista.removeAll(listb)；3）、无重复的并集：listb.removeAll(lista);lista.addAll(listb)。
15. 使用shuffle打乱列表：Collections.shuffle(list)
16. 减少HashMap中元素数量：HashMap比ArrayList多了一层Entry的底层对象封装，多占用了内存，并且它的扩容策略是2倍长度的递增
17. 集合中的Hash码不要重复：HashMap底层是通过数组存储元素的，HashMap根据hashcode通过hash方法和indexFor方法把哈希码转换为数组下标，这样就能很快获取到数据。但是如果在插入元素时，计算hash值冲突，那么HashMap就会以链表形式存储Entry。所以如果哈希码相同，HashMap的查找效率和ArrayList就没有什么区别了
18. <b>集合分类：</b><p>1）、List：实现List接口的集合有ArrayList、LinkedList、Vector、Stack，其中ArrayList是一个动态数组，LinkedList是一个双向链表，Vector是一个线程安全的动态数组，Stack是一个对象栈，遵循先进后出的原则</p><p>2）、Set：不包含重复元素，主要实现类有EnumSet、HashSet、TreeSet，其中EnumSet是枚举类型专用Set，所有元素都是枚举类型；HashSet是哈希码决定其位置的Set，其原理与HashMap相似，提供快速的插入和查找方法；TreeSet是自动排序Set，它实现了SortedSet接口</p><p>3）、Map：分为排序Map和非排序Map，排序Map主要是TreeMap，他根据Key自动排序；非排序Map主要有HashMap、HashTable、Properties、EnumMap等，其中Properties是HashTable的子类，主要用户是从Property文件中加载数据并提供读写操作，EnumMap要求Key必须是枚举类型；还有个WeakHashMap，是采用弱键方式实现的Map类，这个Map好处是不用担心内存溢出，GC会自动删除不用的键值对，但也存在一个问题就是不知道GC何时回收</p><p>4）、Queue：分为阻塞式队列和非阻塞式队列。阻塞队列，队列满了后再插入就会抛出异常，主要有ArrayBlockingQueue、PriorityBlockingQueue、LinkedBlockingQueue，其中ArrayBlockingQueue是一个以数组方式实现的有界阻塞队列，PriorityBlockingQueue是依照优先级组建的队列，LinkedBlockingQueue是通过链表实现的阻塞队列；非阻塞队列无边界，只要内存够用，可以继续追加，常用的是PriorityQueue；还有一种是双端队列，支持在头尾两端插入和移除元素，主要实现类有ArrayDeque、LinkedBlockingDeque、LinkedList</p><p>5）、数组：所有集合底层存储都是数组，数组能容纳基本类型，而集合不能</p><p>6）、工具类：数组工具类有java.util.Arrays和java.lang.reflect.Array；集合工具类有java.util.Collections</p><p>7）、扩展类：Apache的commons-collections扩展包和Google的google-collections包</p>
