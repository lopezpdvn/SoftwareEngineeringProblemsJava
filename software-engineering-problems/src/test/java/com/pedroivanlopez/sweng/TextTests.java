package com.pedroivanlopez.sweng;

import org.junit.Test;

public class TextTests {
    @Test(expected = IndexOutOfBoundsException.class)
    public void SubstringException0() {
      "emptiness".substring(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void SubstringException1() {
      "emptiness".substring(2, 10);
    }
}
