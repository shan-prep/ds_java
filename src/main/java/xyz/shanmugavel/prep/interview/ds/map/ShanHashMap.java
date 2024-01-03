package xyz.shanmugavel.prep.interview.ds.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShanHashMap<K,V> {

  private static int NO_OF_BAGS = 10;
  private final List<List<Entry<K,V>>> bag = new ArrayList<>(NO_OF_BAGS);

  private int size;

  public ShanHashMap() {
    for (int i = 0; i < NO_OF_BAGS; i++) {
      bag.add(new LinkedList<>());
    }
  }

  public void put(K key, V value) {
    int bagIndex = computeHash(key);
    List<Entry<K, V>> entries = bag.get(bagIndex);
    int elemPresentAtIndex = -1;
    int lc = 0;
    Entry<K, V> elemToBeAdded;

    for (Entry<K, V> entry : entries) {
      if( entry.getKey().equals(key) ) {
        elemPresentAtIndex = lc;
        break;
      }
      lc++;
    }

    if (elemPresentAtIndex != -1) {
      elemToBeAdded = entries.get(elemPresentAtIndex);
      elemToBeAdded.setValue(value);
      entries.set(elemPresentAtIndex, elemToBeAdded);
    } else {
      elemToBeAdded = new Entry<>();
      elemToBeAdded.setValue(value);
      elemToBeAdded.setKey(key);
      entries.add(elemToBeAdded);
      size++;
    }

    bag.set(bagIndex, entries);
  }

  public void delete(K key) {
    int bagIndex = computeHash(key);
    List<Entry<K, V>> entries = bag.get(bagIndex);
    Entry<K, V> entryToBeDeleted = null;

    for (Entry<K, V> entry : entries) {
      if( entry.getKey().equals(key) ) {
        entryToBeDeleted = entry;
        break;
      }
    }

    if (null != entryToBeDeleted) {
      entries.remove(entryToBeDeleted);
      size--;
    }

  }

  public V get(K key) {
    int bagIndex = computeHash(key);
    List<Entry<K, V>> entries = bag.get(bagIndex);
    return entries.stream()
        .filter(entry -> entry.getKey().equals(key))
        .findAny()
        .map(entry -> entry.getValue())
        .orElse(null);
  }

  public List<K> getKeys() {
    return bag.stream()
        .flatMap(entry -> entry.stream())
        .map(kevValue -> kevValue.getKey())
        .collect(Collectors.toList());
  }

  public List<Entry<K, V>> getEntries() {
    return bag.stream()
        .flatMap(entry -> entry.stream())
        .collect(Collectors.toList());
  }

  private int computeHash(K key) {
    return key.hashCode()%NO_OF_BAGS;
  }

  public void print() {
    for (int lc = 0; lc < NO_OF_BAGS; lc++) {
      System.out.printf("Bag[%d] size=%d %n", lc, bag.get(lc) == null ? 0: bag.get(lc).size());
    }
  }

  public int getSize() {
    return size;
  }
}

