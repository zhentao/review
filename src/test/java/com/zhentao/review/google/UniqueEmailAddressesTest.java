package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UniqueEmailAddressesTest {
    UniqueEmailAddresses emailAddresses;

    @Before
    public void setup() {
        emailAddresses = new UniqueEmailAddresses();
    }

    @Test
    public void test() {
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        assertThat(emailAddresses.numUniqueEmails(emails), is(2));
    }
}
