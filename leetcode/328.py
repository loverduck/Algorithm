def odd_even(self, head: ListNode) -> ListNode:
    odd = head
    even = head.next

    while even and even.next:
        odd.next = odd.next.next
        even.next = even.next.next
        odd, even = odd.next, even.next
   
    odd.next = even_head

    return head