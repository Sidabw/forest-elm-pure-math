package com.brew.home.geekbang.sortAsearch.sort.z_others.s9_1pseudo;

/**
 * @author shaogz
 */
public class PseudoSortDemo2 {

    public static void main(String[] args) {
        pseudoSort();
    }

    /**
     * <p> 接 {@link PseudoSortDemo1}
     * <p> 题目：如果字符串中存储的不仅有大小写字母，还有数字。要将小写字母的放到前面，大写字母放在最后，数字放在中间，不用排序算法，又该怎么解决呢？
     * <p>
     * <p> 方法一：
     * <p> 跟上面的一样，只不过“已排序区间”变成了2个，指针变成了3个。
     * <p> 指针a、b都是从0开始，指针c从最后开始。
     * <p> 指针a之前的表示小写字母。
     * <p> 指针c以后的表示大些字母。
     * <p> b往前走，遇到小写了a++，遇到大写了b--。
     * <p> 不需要动的自然就是中间的、数字了。
     * <p>
     * <p> 方法二：
     * <p> 桶排。
     * <p> 我们用LinkedList1表示小写字母【基于ASCII】
     * <p> 用LinkedList2表示大写字母
     * <p> LinkedList3表示数字
     * <p> 遍历一遍原始数组....  就完成了啊....
     */
    private static void pseudoSort() {
    }
}
