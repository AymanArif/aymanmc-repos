# Fitnesse



`|Following codecasts is presented for U|`
resulted in :

    |then presentation user will be U|

Scenario:

    |scenario|then presentation user will be _|user|
    |check|presentation user|@user|

## Fitnesse Fixture 


# List of Exceptions

## NULLPointerException

## java.util.ConcurrentModificationException

    /* 
    You are iterating codecast and deleting the same ArrayList concurrently. 
    Hence, the exception.
    */ 
    List<Codecast> codecasts = Context.gateway.findAllCodeCasts(); 
    for (Codecast codecast : codecasts){
         Context.gateway.deleteOne(codecast);
    }
    
 **Solution:**
    
    for (Codecast codecast : new ArrayList<Codecast>(codecasts)){
          Context.gateway.deleteOne(codecast);
    }
 

