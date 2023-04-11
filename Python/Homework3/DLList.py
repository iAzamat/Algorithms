import random
from Node import Node


class DLList:
    def __init__(self):
        self.start = None
        self.end = None

    def print_dllist(self):
        temp = self.start
        s = ""
        while temp != None:
            s += str(temp.x) + " <=> "
            temp = temp.nextNode
        print(s[0:-5])

    def push_front(self, x: int):
        t = Node(x)
        if self.start == None:
            self.start = t
            self.end = t
            return
        t.nextNode = self.start
        self.start.prevNode = t
        self.start = t

    def insert(self, v: Node, x: int):
        t = Node(x)
        next_el = v.nextNode
        if next_el == None:
            t.nextNode = None
            v.nextNode = t
            t.prevNode = v
            self.end = t
            return
        next_el.prevNode = t
        t.nextNode = next_el
        v.nextNode = t
        t.prevNode = v

    def push_back(self, x: int):
        if self.end == None:
            t = Node(x)
            self.start = t
            self.end = t
            return
        DLList.insert(self, self.end, x)

    def delete(self, v: Node):
        prev = v.prevNode
        nextt = v.nextNode
        if prev != None:
            prev.nextNode = nextt
        if nextt != None:
            nextt.prevNode = prev
        v.nextNode = None
        v.prevNode = None
        if v == self.start:
            self.start = nextt
        if v == self.end:
            self.end = prev

    def pop_front(self):
        DLList.delete(self, self.start)

    def pop_back(self):
        DLList.delete(self, self.end)

    def revert(self):
        if (self.start == None):
            return
        a = self.start
        b = self.start.nextNode
        a.nextNode = None
        if b == None:
            return
        c = b.nextNode
        while b != None:
            b.nextNode = a
            a.prevNode = b
            a = b
            b = c
            if c != None:
                c = c.nextNode
        a.prevNode = None
        t = self.start
        self.start = self.end
        self.end = t

    def gen_list(self, count: int):
        a = 0
        b = 100

        for _ in range(count):
            value = random.randint(a, b)
            DLList.push_back(self, value)
