from Node import Node
from Solution import *

head = Node(15)
gen_list(head, 5)

print_list(head)

head = reverse_list(head)

print_list(head)
