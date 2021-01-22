# 두 정렬 리스트의 병합

def merge_list(l1, l2):
    if (not l1) and (l2 and l1.val > l2.val):
        l1, l2 = l2, l1

    if l1:
        l1.next = merge_list(l1.next, l2)
    return l1