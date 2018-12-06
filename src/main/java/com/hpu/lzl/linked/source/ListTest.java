package com.hpu.lzl.linked.source;

import com.hpu.lzl.linked.source.model.Animal;
import com.hpu.lzl.linked.source.model.Cat;
import com.hpu.lzl.linked.source.model.Garfield;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
*   
* @author:awo  
* @time:2018/11/30  上午10:01 
* @Description: info
**/  
public class ListTest {
    public static void main(String[] args) {
//        arrayListDemo();
//        listDemo();
//        listEquals();
//        copyOnWriteList();
        arrayListDemo();
    }

    public static void arrayListDemo(){
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        strings.add("i");
        strings.add("j");
        strings.add("k");

        //抛出 java.util.ConcurrentModificationException异常
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterator = strings.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        });
        thread.start();
        strings.remove(3);
        strings.remove(2);
        strings.remove(1);

//        String r = strings.remove(1);
//        System.out.println("remove " + r);

//        List<String> subString = strings.subList(0,1);
//        subString.add("g");
//
//        //是否存在交集
//        boolean b = subString.retainAll(strings);
//        System.out.println("retainAll " + b +" 大小:"+subString.size()+" ===" + subString);

//        Iterator<String> it = strings.iterator();
//        while (it.hasNext()){
//            String s = it.next();
//            if ("fdgdg".contains(s)){
//                System.out.println("====");
//                it.remove();
//            }
//            System.out.println(s);
//        }
    }

    public static void vectorDemo(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);
        vector.add(11);
    }

    public static void listEquals(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");

        System.out.println(arrayList.equals(linkedList));

    }

    public static void copyOnWriteList(){
        //读写分离的结合，保证写的安全
        final List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("a");
        copyOnWriteList.add("b");
        copyOnWriteList.add("c");
        copyOnWriteList.add("d");
        copyOnWriteList.add("e");
        copyOnWriteList.add("f");
        copyOnWriteList.add("g");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterator = copyOnWriteList.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        });
        thread.start();
        copyOnWriteList.remove(1);
        copyOnWriteList.remove(1);
        copyOnWriteList.remove(1);
        copyOnWriteList.remove(1);
        System.out.println(copyOnWriteList);

    }

    public static void listDemo(){
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        List<Garfield> garfieldList = new ArrayList<>();
        garfieldList.add(new Garfield());
        List<? extends Cat> extendsCatList = new ArrayList<>();
        List<? super Cat> supperCatList = new ArrayList<>();

        extendsCatList = catList;
        System.out.println(extendsCatList.get(0));
        extendsCatList = garfieldList;
        System.out.println(extendsCatList.get(0));
//        extendsCatList.add(new Cat());
//        extendsCatList.add(new Garfield());

        supperCatList.add(new Cat());
//        supperCatList.add(new Animal());
    }
}
