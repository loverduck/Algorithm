# 팰린드롬
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def is_palindrome(head: ListNode) -> bool:
    rev = None
    slow = fast = head
    
    while fast and fast.next:
        fast = fast.next.next
        rev, rev.next, slow = slow, rev, slow.next
    
    if fast:
        slow = slow.next

    while rev and rev.val == slow.val:
        slow, rev = slow.next, rev.next

    return not rev