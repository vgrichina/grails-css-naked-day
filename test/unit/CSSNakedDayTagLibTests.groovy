import grails.test.*

class CSSNakedDayTagLibTests extends TagLibUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIsCssNakedDay() {
        def output = tagLib.isCssNakedDay().toString()
        println "output = $output"
    }
}
