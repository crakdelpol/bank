package it.crakdelpol.bank.utils;

/**
 Utility methods for common argument validations.

 <P>Replaces <tt>if</tt> statements at the start of a method with
 more compact method calls.

 <P>Example use case.
 <P>Instead of :
 <PRE>
 public void doThis(String aText){
 if (!Util.textHasContent(aText)){
 throw new IllegalArgumentException();
 }
 //..main body elided
 }
 </PRE>
 <P>One may instead write :
 <PRE>
 public void doThis(String aText){
 Args.checkForContent(aText);
 //..main body elided
 }
 </PRE>
 */
public final class Args {

    /**
     If <tt>aNumber</tt> is less than <tt>1</tt>, then throw an
     <tt>IllegalArgumentException</tt>.
     */
    public static void checkForPositive(int aNumber) {
        if (aNumber < 1) {
            throw new IllegalArgumentException(aNumber + " is less than 1");
        }
    }

    // PRIVATE
    private Args(){
        //empty - prevent construction
    }
}
