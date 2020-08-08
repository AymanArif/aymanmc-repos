package ayman.java.features.java8.forEachIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class forEachIterable {

    public static void main(String[] args){

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<10; ++i) myList.add(i);

        Iterator<Integer> iterator = myList.iterator();

        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println("Iterator value:"+ i);
        }

        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("forEach anonymous class values:"+ t);
            }
        });

        // Traversing Consumer Interface
        MyConsumer action = new MyConsumer();
        myList.forEach(action);


    }

    //Consumer implementation that can be reused
    private static class MyConsumer implements Consumer<Integer>{

        @Override
        public void accept(Integer t){
            System.out.println("Consumer impl value:" + t);
        }
    }
}
