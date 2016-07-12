package com.lofitskyi.client;

import com.lofitskyi.remote.User;
import com.lofitskyi.remote.UserResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.only;

@RunWith(MockitoJUnitRunner.class)
public class UserClientTest {

    private static final Long ID = 100_100L;
    private static final String LOGIN = "SOME_STRING";
    private static final String EMAIL = LOGIN;

    private UserClient client;

    @Mock
    UserResource resource;

    @Mock
    User user;

    @Before
    public void setUp() throws Exception {
        client = new UserClient(resource);
    }

    @Test
    public void findAll() throws Exception {
        client.findAll();

        Mockito.verify(resource, only()).findAll();
    }

    @Test
    public void findById() throws Exception {
        client.findById(ID);

        Mockito.verify(resource, only()).findById(ID);
    }

    @Test
    public void findByLogin() throws Exception {
        client.findByLogin(LOGIN);

        Mockito.verify(resource, only()).findByLogin(LOGIN);
    }

    @Test
    public void findByEmail() throws Exception {
        client.findByEmail(EMAIL);

        Mockito.verify(resource, only()).findByEmail(EMAIL);
    }

    @Test
    public void create() throws Exception {
        client.create(user);

        Mockito.verify(resource, only()).create(user);
    }

    @Test
    public void update() throws Exception {
        client.update(user);

        Mockito.verify(resource, only()).update(user);
    }

    @Test
    public void remove() throws Exception {
        client.remove(user);

        Mockito.verify(resource, only()).remove(user);
    }
}