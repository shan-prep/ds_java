package xyz.shanmugavel.prep.interview.ds.map;

import java.util.StringJoiner;

public class Entry <K,V> {

  private K key;
  private V value;

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Entry.class.getSimpleName() + "[", "]")
        .add("key=" + key)
        .add("value=" + value)
        .toString();
  }
}
