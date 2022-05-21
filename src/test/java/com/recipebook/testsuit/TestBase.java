package com.recipebook.testsuit;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBase {

    @Test
    public void testParallel() {
        Results results = Runner.parallel(getClass(), 1);

        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

}


