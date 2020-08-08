# Syntax:

`myList.forEach(new Consumer<? super <type-of-myList>> action)`

# Implementation:

## a. Inline Consumer implementation
    
    myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                
            }
    });

## b. External Consumer implementation

    MyConsumer action = new MyConsumer();
    myList.forEach(action);
    ...
    //Consumer implementation that can be reused
    private static class MyConsumer implements Consumer<Integer>{
        @Override
        public void accept(Integer t){
            System.out.println("Consumer impl value:" + t);
        }
    }
    
Number of lines is more, but this helps in having decouple logic for **Iteration** and **Business Logic**. (Higher seperation of code and cleaner code)

