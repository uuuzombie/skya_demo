package com.sky.demo.unit.web_mock;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Test(expected = DuplicateUserException.class)
    public void test_throw_exception_given_user_name() throws DuplicateUserException {
        UserDAO userDAO = mock(UserDAO.class);
        when(userDAO.getUser("admin")).thenReturn(new User());

        UserService userService = new UserService(userDAO);
        userService.register("admin", "123");
    }
}

