package data_structure.list.java;

/**
 * 链表面试题
 */
class Node{
    public Node next;
    public Object data;

    public Node(Node next, Object data) {
        this.next = next;
        this.data = data;
    }
}

public class ListTest {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     * @param head
     * @return
     */
    public Node detectCycle(Node head) {
        if(head == null){
            return null;
        }
        Node quick = head;
        Node slow = head;
        while(slow.next != null && quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(quick == slow){
                Node temp = head;
                while(slow != temp){
                    temp = temp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 找到两个单链表相交的起始节点
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        Node tempA = headA;
        while(tempA.next != null){
            tempA = tempA.next;
        }
        tempA.next = headB;
        Node nodeA = headA;
        Node nodeB = headA;
        while(nodeB.next != null && nodeB.next.next != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next.next;
            if(nodeA == nodeB){
                Node nodeC = headA;
                while(nodeA != nodeC){
                    nodeA = nodeA.next;
                    nodeC = nodeC.next;
                }
                tempA.next = null;
                return nodeA;
            }
        }
        tempA.next = null;
        return null;
    }

}