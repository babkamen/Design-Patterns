package com.babkamen.tree_example

import spock.lang.Specification

class PreOrderIteratorTest extends Specification {
    def "happy path case scenario"() {
        //   1
        //  / \
        // 2   3
        //4  5 6 7
        given:
        Node<Integer> root = new Node<>(1,
                new Node<>(2, new Node<>(4), new Node<>(5)),
                new Node<>(3, new Node<>(6), new Node<>(7)))
        when:
        Iterator<Node<Integer>> it = root.preOrder()
        def result = []
        while (it.hasNext()) {
            result.add(it.next())
        }
        then:
        result.toString()[1, 2, 4, 5, 3, 6, 7].toString()

    }
}
