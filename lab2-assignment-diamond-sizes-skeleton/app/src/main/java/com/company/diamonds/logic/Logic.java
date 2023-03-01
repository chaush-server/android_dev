package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        for (int i = 0; i <= size; i++) {// TOP
            if (i == 0) {
                mOut.print("+");
                mOut.print(new String(new char[size * 2]).replace("\0", "-"));
                mOut.println("+");
            }
        }
        for (int i = 0; i < size; i++){
            if(i == 0 && size > 1){//TOP
                mOut.print("|");
                mOut.print(new String(new char[size-1]).replace("\0", " "));
                mOut.print("/\\");
                mOut.print(new String(new char[size-1]).replace("\0", " "));
                mOut.println("|");
            }
            else if(i == size-1){//mid
                mOut.print("|");
                mOut.print("<");
                if(i%2==0){
                    mOut.print(new String(new char[size*2-2]).replace("\0", "="));
                }
                if(i%2!=0){
                    mOut.print(new String(new char[size*2-2]).replace("\0", "-"));
                }
                mOut.print(">");
                mOut.println("|");
            }else {
                mOut.print("|");
                mOut.print(new String(new char[size-i-1]).replace("\0", " "));
                mOut.print("/");
                if(i%2==0) {
                    mOut.print(new String(new char[i * 2]).replace("\0", "="));
                }else{
                    mOut.print(new String(new char[i*2]).replace("\0", "-"));
                }
                mOut.print("\\");
                mOut.print(new String(new char[size-i-1]).replace("\0", " "));
                mOut.println("|");
            }

        }
        for (int i = 1; i<size; i++){
            mOut.print("|");
            mOut.print(new String(new char[i]).replace("\0", " "));
            mOut.print("\\");
            if((size-i)%2==0){
                mOut.print(new String(new char[(size-i-1)*2]).replace("\0", "-"));
            }else{
                mOut.print(new String(new char[(size-i-1)*2]).replace("\0", "="));
            }
            mOut.print("/");
            mOut.print(new String(new char[i]).replace("\0", " "));
            mOut.println("|");
        }
        for (int i = 0; i <= size; i++) {//BOT
            if (i == size) {
                mOut.print("+");
                mOut.print(new String(new char[size * 2]).replace("\0", "-"));
                mOut.println("+");
            }
        }

    }

}
