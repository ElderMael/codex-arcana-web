package org.mael.blog.web.factorybean;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IntArrayCopyTestCase {

    @Test
    public void testCopyOfWerks() {
        int[] one = { 1, 2, 3, 4 };
        int[] two = { 1, 2, 3, 4, 5, 6 };

        int[] trimmed = Arrays.copyOf(two, one.length);

        assertTrue(Arrays.equals(one, trimmed));
    }

}
