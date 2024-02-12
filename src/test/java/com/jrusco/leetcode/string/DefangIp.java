package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangIp {
    
    @Test
    public void test(){
        assertEquals("128[.]0[.]0[.]1", defangIPaddr("128.0.0.1"));
    }

    public String defangIPaddr(String address) {
        return address != null? address.replace(".", "[.]") : null;
    }
}
