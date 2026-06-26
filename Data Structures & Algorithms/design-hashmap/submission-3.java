class MyHashMap {

    Node[] buckets;
    int capacity;

    public MyHashMap() {
        capacity = 1000;
        buckets = new Node[capacity];
    }
    
    public void put(int key, int value) {
        int idx = key % capacity;
        if(buckets[idx] == null){
            buckets[idx] = new Node(key, value);
            return;
        }else{
            Node head = buckets[idx];
            Node prev = null;
            while(head != null){
                if(head.key == key){
                    head.value = value;
                    return;
                }
                prev = head;
                head = head.next;
            }

            prev.next = new Node(key, value);
        
        }
    }
    
    public int get(int key) {
        if(buckets[key % capacity] == null){
            return -1;
        }else{
            Node head = buckets[key % capacity];
            while(head != null){
                if(head.key == key){
                    return head.value;
                }
                head = head.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        if(buckets[key % capacity] == null){
            return;
        }else{
            int idx = key % capacity;
            Node head = buckets[idx];
            Node prev = null;

            if(head.key == key){
                buckets[idx] = head.next;
                return;
            }

            while(head != null){
                prev = head;
                head = head.next;
                if(head.key == key && prev == null){
                    prev.next = head.next;
                }
            }
        }
        
    }
}

class Node{
    int key;
    int value;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */