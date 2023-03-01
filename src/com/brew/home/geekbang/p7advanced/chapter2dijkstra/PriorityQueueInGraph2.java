package com.brew.home.geekbang.p7advanced.chapter2dijkstra;


/**
 * 带有update方法的小顶堆，供最短路径dijkstra算法使用
 */
public class PriorityQueueInGraph2 {

    /**
     * 最后一个元素的位置。如果队列里有一个元素，那么该值为1。
     * 对应的0角标不存储元素。
     */
    private int count;

    /**
     * 这里vertices的下标和每个vertex的id是一一对应着的。
     */
    private final Vertex[] vertices;

    public PriorityQueueInGraph2(int count) {
        this.count = 0;
        this.vertices = new Vertex[count];
    }

    public void add(Vertex v) {
        //0角标不存储元素
        vertices[++count] = v;
        //Vertex的id在add时初始化
        v.qIndex = count;
        heapifyDown2Top(count);
    }

    public Vertex poll() {
        Vertex topEl = vertices[1];
        vertices[1] = vertices[count];
        vertices[1].qIndex = 1;
        vertices[count] = null;
        count--;
        heapifyTop2Down(1);
        return topEl;
    }

    public void update(Vertex t) {
        //相较于学习堆时的"堆是不支持的查找的"
        //这里的update因为能拿到对应元素在堆里面位置，所以才可以update
        int upI = t.qIndex / 2;
        int downL = t.qIndex * 2;
        int downR = t.qIndex * 2 + 1;
        if (upI>=1 && t.dist < vertices[upI].dist) {
            //从当前节点开始，向上堆化
            heapifyDown2Top(t.qIndex);
        } else if (downL<=count && t.dist > vertices[downL].dist) {
            //从当前节点开始，向下堆化
            heapifyTop2Down(t.qIndex);
        } else if (downR <= count && t.dist > vertices[downR].dist) {
            //从当前节点开始，向下堆化
            heapifyTop2Down(t.qIndex);
        } else {
            System.out.println("nothing has done!");
        }
    }

    public boolean isEmpty() {
        return count<1;
    }

    public void heapifyDown2Top(int start) {
        //自下而上的堆化，只需要一直向上跟父节点比大小就可以了。
        int f = start/2;
        int cur = start;
        while (f >= 1) {
            if (vertices[cur].dist < vertices[f].dist) {
                swap(cur, f);
                cur = f;
                f = f/2;
            } else {
                break;
            }
        }
    }

    public void heapifyTop2Down(int start) {
        int cur = start;
        int downL = cur * 2;
        int downR = downL + 1;

        while (cur <= count) {
            if (downL <= count && vertices[cur].dist > vertices[downL].dist) {
                swap(cur, downL);
                cur = downL;
            } else if (downR <= count && vertices[cur].dist > vertices[downR].dist) {
                swap(cur, downR);
                cur = downR;
            } else {
                break;
            }
            downL = cur * 2;
            downR = downL + 1;
        }
    }

    private void swap(int l, int r) {
        //区分于普通的swap，这里vertices的下标和每个vertex的id是一一对应着的。
        //一定是先改变实例内部的id值，再互换两个实例再数组中的位置。
        vertices[l].qIndex = r;
        vertices[r].qIndex = l;

        Vertex tmp = vertices[l];
        vertices[l] = vertices[r];
        vertices[r] = tmp;

    }

    public static void main(String[] args) {
        //add vm options: -ea

        //实际放7个元素，草图自己画下
        PriorityQueueInGraph2 q = new PriorityQueueInGraph2(8);

        q.add(new Vertex( 1));
        q.add(new Vertex( 2));
        q.add(new Vertex( 3));
        q.add(new Vertex( 4));
        q.add(new Vertex( 5));
        q.add(new Vertex( 6));
        q.add(new Vertex( 7));

        Vertex poll = q.poll();

        assert poll.dist == 1;
        //Vertex的id与verities[]的下标一一对应
        assert q.vertices[1].dist == 2;
        assert q.vertices[1].qIndex == 1;

        assert q.vertices[3].dist == 3;
        assert q.vertices[3].qIndex == 3;

        Vertex v3 = q.vertices[3];
        v3.dist = 8;
        q.update(v3);

        assert q.vertices[6].dist == 8;
        assert q.vertices[6].qIndex == 6;
        assert q.vertices[3].dist == 6;
        assert q.vertices[3].qIndex == 3;

        v3 = q.vertices[3];
        v3.dist = 1;
        q.update(v3);
        assert q.vertices[1].dist == 1;
        assert q.vertices[1].qIndex == 1;
        assert q.vertices[3].dist == 2;
        assert q.vertices[3].qIndex == 3;

        System.out.println(1);
    }
}
