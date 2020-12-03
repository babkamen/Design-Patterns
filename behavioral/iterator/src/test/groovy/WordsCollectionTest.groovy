import spock.lang.Specification

class WordsCollectionTest extends Specification {
    def "test iterators"() {
        given:
        def items = ["1", "2", "3"]

        when: 'verify that iterator works correctly when elements are in natural order'
        def wordsCollection = new WordsCollection();
        items.each { wordsCollection.addItem(it) }
        def iterator = wordsCollection.iterator
        items.each {
            assert iterator.hasNext()
            assert iterator.next() == it
        }

        and: 'and when elements are in reverse order'
        def reverseItems = items.reverse()
        def reverseIterator = wordsCollection.reverseIterator
        reverseItems.each {
            assert reverseIterator.hasNext()
            assert reverseIterator.next() == it
        }
        then:
        true
    }
}
