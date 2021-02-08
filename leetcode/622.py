# 원형 큐 디자인
class MyCirCularQueue():
    def __init__(self, s : int):
        self.q = [None] * s
        self.maxlen = s
        self.p1 = 0
        self.p2 = 0

    def enQueue(self, value: int) -> bool:
        if self.q[self.p2] is None:
            self.q[self.p2] = value
            self.p2 = (self.p2 + 1) % self.maxlen
            return True
        else:
            return False

    def Rear(self) -> int:
        return -1 if self.q[self.p2 - 1] is None else self.q[self.p2 - 1]

    def deQueue(self) -> bool:
        if self.q[self.p1] is not None:
            self.q[self.p1] = None
            self.p1 = (self.p1 + 1) % self.maxlen
            return True
        else:
            return False

    def Front(self) -> int:
        return -1 if self.q[self.p1] is None else self.q[self.p1]


    def isFull(self) -> bool:
        return self.p2 == self.p1 and self.q[self.p1] is not None

    def isEmpty(self) -> bool:
        return self.p1 == self.p2 and self.q[self.p1] is None
