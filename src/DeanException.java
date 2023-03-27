/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Recitation: 01
 */

/**
 * An Exception class which indicates that the user attempted to fill a full array should be created.
 */
public class DeanException extends Exception{
    public DeanException(){
        super("The lunch line is full.");
    }
}
