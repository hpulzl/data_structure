package com.hpu.lzl.linked.geekbang;

/**
*   
* @author:awo  
* @time:2018/10/10  下午8:05 
* @Description: info
**/  
public class CircularQueue {

    private String[] strArray;
    //尾节点
    private int tail;
    //头节点
    private int head;
    //队列的容量大小
    private int n;

    public CircularQueue(int num){
        strArray = new String[num];
        n = num;
    }
    /**
     * 出队
     */
    public String dequeue(){
        //判断队空
        if (head == tail)
            return null;
        String s = strArray[head];
        //出栈后清空该资源
        strArray[head] =null;
        head = (head+1) % n;
        return s;
    }

    public String[] getQueue(){
        return strArray;
    }

    /**
     * 入队
     * @param s
     * @return
     */
    public boolean enqueue(String s) throws Exception {
        //循环队列判断队列满
        if ((tail+1) % n == head)
            return false;
        strArray[tail] = s;
        //计算tail的位置
        tail = (tail+1) % n;
      return true;
    }


    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        try {
            queue.enqueue("a");
            queue.enqueue("b");
            queue.enqueue("c");
            queue.enqueue("c");
            queue.enqueue("c");
            queue.enqueue("c");

            String[] strs = queue.getQueue();
            System.out.println("入队结束,队列中的数据...");
            for (String s : strs){
                System.out.println(s+",");
            }

            String a = queue.dequeue();
            System.out.println("出队," + a);
            String b = queue.dequeue();
            System.out.println("出队," + b);

            String c = queue.dequeue();
            System.out.println("出队," + c);

            String d = queue.dequeue();
            System.out.println("出队," + d);

            String e = queue.dequeue();
            System.out.println("出队," + e);

            String f = queue.dequeue();
            System.out.println("出队," + f);

            strs = queue.getQueue();

            System.out.println("队列中的数据...");
            for (String s : strs){
                System.out.println(s+",");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
