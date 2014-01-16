package com.nigelsmall.geoff.reader;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * @author mh
 * @since 16.01.14
 */
public class GeoffReaderTest {
    @Test
    public void testReadInvalidData() throws Exception {
        try {
            new GeoffReader(new StringReader("(A {b})")).readSubgraph();
        } catch(GeoffReaderException gre) {
            assertEquals("Unexpected character at line 0 column 5",gre.getMessage());
        }
    }
    @Test
    public void testReadInvalidDataOnSecondLine() throws Exception {
        try {
            new GeoffReader(new StringReader("(A {\"b\":123})\n(A {")).readSubgraph();
        } catch(GeoffReaderException gre) {
            assertEquals("Unexpected character at line 1 column 4",gre.getMessage());
        }
    }
}
