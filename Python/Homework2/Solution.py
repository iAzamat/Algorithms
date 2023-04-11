from Node import Node
import random

"""
 * Метод разворота односвязного списка
 *
 * @param head
 * @return
"""


def reverse_list(head):
    prev = None
    curr = head
    while curr:
        next_temp = curr.next
        curr.next = prev
        prev = curr
        curr = next_temp
    return prev


"""
 * Метод печати списка
 *
 * @param node
 """


def print_list(node):
    s = ""
    while node:
        s += str(node.value) + " => "
        node = node.next
    print(s[0:-4])


"""
 * Метод добавления Node в список
 *
 * @param head
 * @param node
 * @return
"""


def add_node(head, node):
    head.next = node
    return head.next


"""
 * Метод генерации Node
 *
 * @param node  передается Node
 * @param count указывается количество Node, которые нужно сгенерировать
"""


def gen_list(node, count):
    a = 0
    b = 100
    temp_node = Node(0)

    for i in range(count):
        x = random.randint(a, b)
        if i == 0:
            temp_node = add_node(node, Node(x))
        else:
            temp_node = add_node(temp_node, Node(x))
