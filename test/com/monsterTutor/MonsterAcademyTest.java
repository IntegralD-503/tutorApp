package com.monsterTutor;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

class MonsterAcademyTest {

    private MonsterAcademy monsterAcademy;

    @Before
    public void setUp() {
        monsterAcademy = new MonsterAcademy();
    }

    @Test
    public void testRun() throws IOException {
        monsterAcademy.run();
//        assertEquals();
    }


}
