package com.lofitskyi.client;

import com.lofitskyi.IntegrationTest;
import com.lofitskyi.remote.User;
import com.lofitskyi.remote.UserArray;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

/**
 * Before running this test, you need start remote web-service
 */
@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/application-context.xml")
public class RemoteIntegrationTest {

    @Autowired
    UserClient client;

    @Before
    public void setUp() throws Exception {
        assumeThat(client, is(notNullValue()));
        assumeThat(client.resource, is(notNullValue()));
    }

    @Test
    public void integrationChecking() throws Exception {
        final UserArray all = client.findAll();

        assertNotNull(all);
        assertThat(all.getItem(), is(not(Matchers.<User>empty())));
    }
}
