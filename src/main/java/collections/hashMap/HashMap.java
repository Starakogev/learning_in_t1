package collections.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    int defaultArrayLength = 0;
    CustomNode[] arrayNode = new CustomNode[10];
    private int size = 0;

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        for (CustomNode customNode : arrayNode) {
            if (customNode != null) {
                return false;
            }
        }
        return true;
    }


    public boolean containsKey(Object key) {
        for (Object currentKey : keySet()) {
            K castedCurrentKey = (K) currentKey;
            if (key == castedCurrentKey) {
                return true;
            }
        }
        return false;
    }


    public boolean containsValue(Object value) {
        for (Object currentValue : values()) {
            K castedCurrentValue = (K) currentValue;
            if (value == castedCurrentValue) {
                return true;
            }
        }
        return false;
    }


    public V get(Object key) {
        int index = getHashMapArrayIndex(key);
        CustomNode<K, V> currentNode = arrayNode[index];
        if (currentNode == null) {
            return null;
        } else {
            if (equalKey(key, currentNode)) {
                return currentNode.getValue();
            } else if (currentNode.getNextNode() != null) {
                do {
                    currentNode = currentNode.getNextNode();
                    if (currentNode.getKey().equals(key)) {
                        return currentNode.getValue();
                    }
                } while (currentNode.getNextNode() != null);
            }
        }
        return null;

    }


    public V put(K key, V value) {

        int index = getHashMapArrayIndex(key);
        CustomNode<K, V> currentNode = arrayNode[index];
        if (currentNode == null) {
            arrayNode[index] = new CustomNode<>(key, value, null);
            size++;
            resizeIfHashMapArraySmall();
        } else {
            while (true) {
                if (equalKey(key, currentNode)) {
                    return currentNode.setValue(value);
                } else if (currentNode.getNextNode() != null) {
                    currentNode = currentNode.getNextNode();
                } else {
                    currentNode.setNextNode(new CustomNode<>(key, value, null));
                    size++;
                    resizeIfHashMapArraySmall();
                    return null;
                }
            }
        }
        return null;
    }

    private boolean equalKey(Object key, CustomNode<K, V> currentNode) {
        if (currentNode.getKey() != null) {
            return currentNode.getKey().equals(key);
        } else {
            return key == null;
        }
    }

    private int getHashMapArrayIndex(Object key) {
        int index;
        if (key != null) {
            index = Math.abs(key.hashCode() % arrayNode.length);
        } else {
            index = 0;
        }
        return index;
    }

    private void resizeIfHashMapArraySmall() {
        if (((double) size / arrayNode.length) > 0.75) {
            resizeHashMapArray();
        }
    }

    private void resizeHashMapArray() {

        defaultArrayLength = arrayNode.length * 2;
        List<CustomNode<K, V>> collectionOfAllNodes;
        CustomNode[] arrayNode2 = new CustomNode[defaultArrayLength];
        collectionOfAllNodes = getAllNodes();
        int index2;
        for (int i = 0; i < collectionOfAllNodes.size(); i++) {
            index2 = Math.abs(collectionOfAllNodes.get(i).getKey().hashCode() % arrayNode2.length);
            CustomNode<K, V> oldNode = arrayNode2[index2];
            collectionOfAllNodes.get(i).setNextNode(oldNode);
            arrayNode2[index2] = collectionOfAllNodes.get(i);
        }
        arrayNode = arrayNode2;
    }

    private List<CustomNode<K, V>> getAllNodes(int index) {
        List<CustomNode<K, V>> collectNodes = new ArrayList<>();
        CustomNode<K, V> currentNode = arrayNode[index];
        while (currentNode != null) {
            CustomNode<K, V> currentNodeCopy = new CustomNode<>(currentNode.getKey(), currentNode.getValue(), null);
            collectNodes.add(currentNodeCopy);
            currentNode = currentNode.getNextNode();
        }
        return collectNodes;
    }

    private List<CustomNode<K, V>> getAllNodes() {
        List<CustomNode<K, V>> collectNodes = new ArrayList<>();
        for (int i = 0; i < arrayNode.length; i++) {
            collectNodes.addAll(getAllNodes(i));
        }
        return collectNodes;
    }


    public V remove(Object key) {

        int index = getHashMapArrayIndex(key);
        CustomNode<K, V> currentNode = arrayNode[index];
        if (currentNode == null) {
            return null;
        }
        if (equalKey(key, currentNode) && currentNode.getNextNode() == null) {
            V oldValue = currentNode.getValue();
            arrayNode[index] = null;
            size--;
            return oldValue;
        } else if (equalKey(key, currentNode)) {
            V oldValue = currentNode.getValue();
            arrayNode[index] = currentNode.getNextNode();
            size--;
            return oldValue;
        } else if (currentNode.getNextNode() != null) {
            CustomNode<K, V> previevNode = arrayNode[index];
            do {
                currentNode = currentNode.getNextNode();
                if (equalKey(key, currentNode)) {
                    V oldValue = currentNode.getValue();
                    previevNode.setNextNode(currentNode.getNextNode());
                    size--;
                    return oldValue;
                }
                previevNode = previevNode.getNextNode();
            } while (currentNode.getNextNode() != null);
        }

        return null;
    }


    public void putAll(Map m) {
        for (Object currentEntry : m.entrySet()) {
            Entry<K, V> castedCurrentEntry = (Entry) currentEntry;
            this.put(castedCurrentEntry.getKey(), castedCurrentEntry.getValue());
        }
    }


    public void clear() {
        Arrays.fill(arrayNode, null);
        size = 0;
    }


    public Set keySet() {
        Set<K> keys = new HashSet<>();
        for (CustomNode<K, V> currentNode : getAllNodes()) {
            keys.add(currentNode.getKey());
        }
        return keys;
    }


    public Collection values() {
        List<V> values = new ArrayList<>();
        for (CustomNode<K, V> currentNode : getAllNodes()) {
            values.add(currentNode.getValue());
        }
        return values;
    }


    public Set<Map.Entry<K, V>> entrySet() {
        return new HashSet<>(getAllNodes());
    }

    @Override
    public String toString() {
        List<String> strings = new ArrayList<>();
        for (CustomNode<K, V> currentNode : getAllNodes()) {
            strings.add("(" + currentNode.getKey() + "=" + currentNode.getValue() + ")");
        }
        return String.join(",", strings);
    }
}