package exam.linked;

class LinkNode{
    int value;
    LinkNode next;
    LinkNode(int value){
        this.value = value;
    }

    LinkNode(int value,LinkNode next){
        this.value = value;
        this.next = next;
    }
}
