package example1
import example1.WordsCollection
import spock.lang.Specification

class WordsCollectionTest extends Specification {
    def "verify that iterator works correctly when elements are in natural order"() {
        given:
        def items = ["1", "2", "3"]
        when: ''
        def wordsCollection = new WordsCollection();
        items.each { wordsCollection.addItem(it) }
        then:
        def iterator = wordsCollection.iterator
        items.each {
            assert iterator.hasNext()
            assert iterator.next() == it
        }

    }

    def "verify that iterator works correctly when elements are in reverse order"() {
        given:
        def items = ["1", "2", "3"]

        when:
        def wordsCollection = new WordsCollection();
        items.each {
            wordsCollection.addItem(it)
        }

        then:
        def reverseItems = items.reverse()
        def reverseIterator = wordsCollection.reverseIterator
        reverseItems.each {
            assert reverseIterator.hasNext()
            assert reverseIterator.next() == it
        }
    }
}
