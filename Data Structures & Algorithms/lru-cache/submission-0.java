class LRUCache {
    DDL tail;
    DDL head;
    Map<Integer, DDL> map;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        head = new DDL(-1, -1, null, null);
        tail = new DDL(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DDL node = map.get(key);
            
            // delete node
            DDL prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;

            // put in front
            DDL next = head.next;
            node.next = next;
            next.prev = node;
            node.prev = head;
            head.next = node;

            return map.get(key).val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DDL node = map.get(key);
            node.val = value;
            //delete
            DDL next = node.next;
            DDL prev = node.prev;
            next.prev = prev;
            prev.next = next;

            //add it to head
            next = head.next;
            node.next = next;
            next.prev = node;
            head.next = node;
            node.prev = head;

        }else if(map.size() == cap){

            //delete last node before tail
            DDL lru = tail.prev;
            lru.prev.next = tail;
            tail.prev = lru.prev;

            DDL node = addToHead(key,value);
            map.remove(lru.key);
            map.put(key, node);

        } else{
            DDL node = addToHead(key, value);
            map.put(key, node);
        }
    }


    private DDL addToHead(int key, int value){
        DDL node = new DDL(key, value, null, null);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        return node;
    }
}

class DDL{
    int val;
    int key;
    DDL prev;
    DDL next;

    DDL(int key, int val, DDL prev, DDL next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
