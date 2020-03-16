package by.sivko.pizzashop.loginservice.services;

import by.sivko.pizzashop.loginservice.entitites.User;
import by.sivko.pizzashop.loginservice.exceptions.BadCredentionalsException;
import by.sivko.pizzashop.loginservice.exceptions.NotActivatedException;
import by.sivko.pizzashop.loginservice.exceptions.NotFoundException;

public interface UserService {

    User findUserByEmailAndCheckPassword(String email, String password) throws BadCredentionalsException, NotActivatedException;

    boolean isExists(String email);

    User createUserWithUserRole(User user) throws NotFoundException;

    User activateUser(String activationCode) throws NotFoundException;
}
