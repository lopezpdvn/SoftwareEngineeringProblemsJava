package com.pedroivanlopez.sweng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import static java.lang.System.out;
import static java.lang.Math.pow;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {
  @Test
  public void evaluatesExpression() {
    int sum = 6;
    assertEquals(6, sum);
  }

  @Test
  public void testDynamicArray() {
    ArrayList<String> darr0 = new ArrayList<String>();
    darr0.add("one");
    darr0.add("three");
    darr0.add(0, "zero");
    darr0.add(2, "two");
    darr0.add("four");
    assertEquals(darr0.size(), 5);
    assertTrue(darr0.contains("one"));
    assertEquals(darr0.remove(1), "one");
    assertTrue(!darr0.contains("one"));
    assertEquals(darr0.get(1), "two");
    assertEquals(darr0.indexOf("three"), 2);
    assertEquals(darr0.size(), 4);
    String[] ans = new String[] {"zero", "two", "three", "four"};
    int i = 0;
    for(String s : darr0) {
      assertEquals(ans[i++], s);
    }
    darr0.set(1, "dos");
    ans = new String[] {"zero", "dos", "three", "four"};
    i = 0;
    for(String s : darr0) {
      assertEquals(ans[i++], s);
    }
  }

  @Test
  public void testLinkedList() {
    LinkedList<String> ll = new LinkedList<String>();
    ll.add("one");
    ll.addFirst("zero");
    ll.add(2, "three");
    ll.add(2, "two");
    ll.addLast("four");

    String[] ans = new String[] {"zero", "one", "two", "three", "four"};
    int i = 0;
    for(String s : ll) {
      assertEquals(s, ans[i++]);
    }

    assertEquals(5, ll.size());
    assertEquals(ll.getFirst(), "zero");
    assertEquals(ll.getLast(), "four");
    assertEquals(ll.indexOf("three"), 3);
  }

  @Test
  public void testHashMap() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("zero", "cero");
    map.put("one", "uno");
    map.put("two", "dos");
    assertEquals(map.size(), 3);
    assertEquals("uno", map.get("one"));
    assertEquals(null, map.get("ONE"));
    map.replace("one", "UNO");
    assertEquals(map.size(), 3);
    assertEquals("UNO", map.get("one"));
    assertEquals("dos", map.remove("two"));
    assertEquals(map.size(), 2);
    assertEquals(null, map.remove("two"));
    assertEquals(map.size(), 2);
    assertEquals("default", map.getOrDefault("two", "default"));
  }

  @Test
  public void testHashMapIteration() {
    HashSet<String> ansKeys = new HashSet<String>();
    ansKeys.add("one");
    ansKeys.add("zero");
    ansKeys.add("three");
    ansKeys.add("two");
    HashSet<Integer> ansValues = new HashSet<Integer>();
    ansValues.add(0);
    ansValues.add(1);
    ansValues.add(2);
    ansValues.add(3);
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    map.put("one", 1);
    map.put("zero", 0);
    map.put("three", 3);
    map.put("two", 2);

    for(String k : map.keySet()) {
      assertTrue(ansKeys.contains(k));
    }
    for(Integer v : map.values()) {
      assertTrue(ansValues.contains(v));
    }
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      assertTrue(ansKeys.contains(entry.getKey()));
      assertTrue(ansValues.contains(entry.getValue()));
    }

    map.put("two", 23);
  }

  @Test
  public void mathMisc() {
    int a = 5, b = 2, c = -7, d = -3;
    assertTrue(a/b == 2);
    assertTrue(c/b == -3);

    assertTrue(pow(3, 4) == 81);
    int[] arr = new int[0];
    //b = arr[0];
  }

  @Test
  public void textMisc() {
    assertEquals("ABCD", "A" + 'B' + 'C' + "D");
    char[] ansChars = {'a', 'b', 'c', 'd'};
    String str = "abcd";
    int j = 0;
    for(int i = 0; i < str.length(); i++) {
      assertEquals(ansChars[j++], str.charAt(i));
    }
    j = 0;
    for(char c : str.toCharArray()) {
      assertEquals(ansChars[j++], c);
    }
    assertEquals("emptiness".substring(9), "");
  }
}
