package com.roachfu.solar.common.util;

import com.roachfu.solar.common.util.id.IDCardUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by roach on 06/08/2017.
 */
public class IDCardUtilsTest {

    @Test
    public void testVerifyIdCard() {
        assertEquals(false, IDCardUtils.verifyIdCard("320301198502169143"));
        assertEquals(false, IDCardUtils.verifyIdCard("32030119850216914"));
        assertEquals(false, IDCardUtils.verifyIdCard("3203011985021691428"));
        assertEquals(false, IDCardUtils.verifyIdCard("32030119850216914a"));
        assertEquals(false, IDCardUtils.verifyIdCard("180301198502169142"));
        assertEquals(true, IDCardUtils.verifyIdCard("110108199209188378"));
        assertEquals(true, IDCardUtils.verifyIdCard("120105199206030172"));
        assertEquals(true, IDCardUtils.verifyIdCard("130825199105138665"));
        assertEquals(true, IDCardUtils.verifyIdCard("141102198906264202"));
        assertEquals(true, IDCardUtils.verifyIdCard("150923197202268311"));
        assertEquals(true, IDCardUtils.verifyIdCard("210204197008045252"));
        assertEquals(true, IDCardUtils.verifyIdCard("222402198806161860"));
        assertEquals(true, IDCardUtils.verifyIdCard("231085198701249460"));
        assertEquals(true, IDCardUtils.verifyIdCard("310116198405188394"));
        assertEquals(true, IDCardUtils.verifyIdCard("320301198502169142"));
        assertEquals(true, IDCardUtils.verifyIdCard("330224196702265835"));
        assertEquals(true, IDCardUtils.verifyIdCard("341503197503139133"));
        assertEquals(true, IDCardUtils.verifyIdCard("350982197103165971"));
        assertEquals(true, IDCardUtils.verifyIdCard("361024197711255436"));
        assertEquals(true, IDCardUtils.verifyIdCard("370882197811107818"));
        assertEquals(true, IDCardUtils.verifyIdCard("411222197708257097"));
        assertEquals(true, IDCardUtils.verifyIdCard("421001198301097785"));
        assertEquals(true, IDCardUtils.verifyIdCard("432503197505028819"));
        assertEquals(true, IDCardUtils.verifyIdCard("445381198504154175"));
        assertEquals(true, IDCardUtils.verifyIdCard("45032619840627183x"));
        assertEquals(true, IDCardUtils.verifyIdCard("469002197604279742"));
        assertEquals(true, IDCardUtils.verifyIdCard("500233198402225361"));
        assertEquals(true, IDCardUtils.verifyIdCard("510623197307181694"));
        assertEquals(true, IDCardUtils.verifyIdCard("522230198107049509"));
        assertEquals(true, IDCardUtils.verifyIdCard("533527198909210238"));
        assertEquals(true, IDCardUtils.verifyIdCard("540122197904143276"));
        assertEquals(true, IDCardUtils.verifyIdCard("610103198005221895"));
        assertEquals(true, IDCardUtils.verifyIdCard("620421199208081752"));
        assertEquals(true, IDCardUtils.verifyIdCard("632322197305101538"));
        assertEquals(true, IDCardUtils.verifyIdCard("640502198912100190"));
        assertEquals(true, IDCardUtils.verifyIdCard("650101198604183434"));
    }
}
