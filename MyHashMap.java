
class MyHashMap {
class Node
{
    int key;
    int value;
    Node next;
    public Node(int key,int value)
    {
    this.key=key;
    this.value=value;
    }
}
int bucket_size;
Node[]storage;
    public MyHashMap() {
        this.bucket_size=10000;
        storage = new Node[this.bucket_size];
    }

int getbindex(int key){
    return Integer.hashCode(key)%this.bucket_size;
}

Node find(Node dummy,int key){
    Node prev = dummy;
    Node curr = dummy.next;

    while(curr!=null && curr.key!=key){
        prev = curr;
        curr = curr.next;
    }
    return prev;
}

    public void put(int key, int value) {
        int a = getbindex(key);
        if(storage[a]==null){
           storage[a]=new Node(-1,-1);
        }

        Node b = find(storage[a],key);
        if(b.next==null){ 
               b.next = new Node(key,value);
        }
        else{
            b.next.value = value;
        }

    }

    public int get(int key) {
         int a = getbindex(key);
         if(storage[a]==null)
         {
          return -1;
        }

        Node f = find(storage[a],key);
        if(f.next!=null){
            return f.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int a = getbindex(key);
         if(storage[a]==null)
         {
          return;
        }

        Node f = find(storage[a],key);

        if(f.next==null){
        return;
        }
        else{
            f.next=f.next.next;
        }
    }
}
