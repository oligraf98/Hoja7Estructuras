public class Association<K, V> {
    protected K key;
    protected V value;

    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Association{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
