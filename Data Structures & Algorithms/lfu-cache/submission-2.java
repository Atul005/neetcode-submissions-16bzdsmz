class LFUCache {

    Map<Integer, DDL> cache;
    Map<Integer, List<DDL>> freqMap;
    DDL head;
    DDL tail;
    final int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        head = new DDL(-1, -1, null, null);
        tail = new DDL(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
        minFreq = 0;
    }
    
    public int get(int key) {
        DDL node = cache.get(key);
        if(node != null){
            updateNode(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DDL node = cache.get(key);
        if(node != null){
            node.value = value;
            // removeNode(node);
            // addToHead(node);
            updateNode(node);
            return;
        } else if(cache.size() == capacity){
            List<DDL> lists = freqMap.get(minFreq);
            if(lists != null){
                DDL deletedNode = lists.removeLast();
                cache.remove(deletedNode.key);
                if(lists.size() == 0){
                    minFreq++;
                }
            }
        }

        DDL newNode = new DDL(key, value, null, null);
        cache.put(key, newNode);
        List<DDL> list = freqMap.get(newNode.freq);
        if(list == null){
            list = new LinkedList<>();
        }
        minFreq = newNode.freq;
        list.addFirst(newNode);
        freqMap.put(newNode.freq, list);
    }

    // private void removeNode(DDL node){
    //     DDL prev = node.prev;
    //     DDL next = node.next;
    //     prev.next = next;
    //     next.prev = prev;
    // }

    // private void addToHead(DDL node){
    //     DDL nextNode = head.next;
    //     node.next = nextNode;
    //     nextNode.prev = node;
    //     head.next = node;
    //     node.prev = head;
    // }

    private void updateNode(DDL node){
        int nodeFreq = node.freq;
        List<DDL> nodes = freqMap.get(nodeFreq);
        if(nodes != null){
            nodes.remove(node);
        }
        if(nodeFreq == minFreq && nodes.size() == 0){
            minFreq++; 
        }
        nodeFreq++;
        node.freq++;
        List<DDL> list = freqMap.get(nodeFreq);
        if(list == null){
            list = new LinkedList<>();
        }
        list.addFirst(node);
        freqMap.put(nodeFreq, list);
    }

}

class DDL{
    int key;
    int value;
    DDL prev;
    DDL next;
    int freq;

    DDL(int key, int value, DDL prev, DDL next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
        freq = 1;
    }

}

class Pair{
    DDL node;
    int freq;

    public Pair(DDL node, int freq){
        this.node = node;
        this.freq = freq;
    }

}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */