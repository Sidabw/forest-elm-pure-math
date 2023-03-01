package com.brew.home.geekbang.p7advanced.chapter2dijkstra;


// 下面这个类是为了dijkstra实现用的
public class Vertex {

    /**
     * <p> 顶点编号ID，也就是在堆里的下标。
     * <p> id表示当前节点，但是其值是在小顶堆里add的时候初始化上的。
     * <p> 不要考虑当前实例是否代表当前节点。
     * <p> 具体swap的代码可以看到，位置互换的时候，是把两个Vertex实例的id和dist都互换。
     * <p> 所以这个叫id就很不合适.... 叫i多亲切。
     */
    public int id; //

    public int qIndex;

    public int dist; // 从起始顶点到这个顶点的距离
    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public Vertex(int dist) {
        //给测试用的
        this.id = -1;
        this.dist = dist;
    }
}