package com.fasoo.syn;

import java.util.Collection;

/**
 * PRIVATE_COLLECTION Test case

 * Private 배열 검출 여부 검사
 * @author jwyoon
 */
public class PrivateCollection {
    private String[] privateArray;
    public String[] publicArray;

    private String[] getArrayPrivate() {
        return this.privateArray;
    }

    public String[] getArray(int x) {
        if(x > 10)
            return this.privateArray; /* BUG */
        else
            return this.publicArray; // Not bug
    }

    public String[] getArray2(int x) {
        return getArrayPrivate(); /* BUG */
    }

    public boolean isSame() {
        return this.privateArray == this.publicArray; // Not bug
    }
}
