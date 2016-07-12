package com.lofitskyi.client;

import com.lofitskyi.remote.*;

public class UserClient {

    UserResource resource;

    public UserClient() {
    }

    public UserClient(UserResource resource) {
        this.resource = resource;
    }

    public UserArray findAll() throws PersistentException_Exception {
        return resource.findAll();
    }

    public User findById(Long id) throws PersistentException_Exception {
        return resource.findById(id);
    }

    public User findByLogin(String login) throws PersistentException_Exception {
        return resource.findByLogin(login);
    }

    public User findByEmail(String email) throws PersistentException_Exception {
        return resource.findByEmail(email);
    }

    public void create(User user) throws PersistentException_Exception, SQLException_Exception {
        resource.create(user);
    }

    public void update(User user) throws PersistentException_Exception, SQLException_Exception {
        resource.update(user);
    }

    public void remove(User user) throws PersistentException_Exception, SQLException_Exception {
        resource.remove(user);
    }
}
