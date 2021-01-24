def reverse_linked_list(head: LinkNone) -> LinkNode:
    node, prev = head, None

    while node:
        next, node.next = node.next, prev
        node, prev = next, node

    return prev