
class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        int v1=0;
        int v2=0;
        int c=0;
        int a=0;
        if(l1!=null) v1=l1.val;
        if(l2!=null) v2=l2.val;
        
        a=(v1+v2)%10;
        c=(v1+v2)/10;
        
        if(l1==null) l1=new ListNode(a);
        else l1.val = a;
        if(c>0){
          if(l1.next == null) l1.next = new ListNode(c);
          else l1.next.val += c;  
        }
        
        if(l2==null) l1.next=addTwoNumbers(l1.next, l2);
        else l1.next=addTwoNumbers(l1.next, l2.next);
        return l1;
    }
    
}