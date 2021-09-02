package collections.hashMap;

import java.util.Map;

public class CustomNode<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    private CustomNode<K, V> nextNode;

    public CustomNode(K key, V value, CustomNode<K, V> nextNode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public CustomNode<K, V> getNextNode() {
        return nextNode;
    }

    public void setKey(K newKey) {
        key = newKey;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public void setNextNode(CustomNode<K, V> newNextNode) {
        nextNode = newNextNode;
    }

}
