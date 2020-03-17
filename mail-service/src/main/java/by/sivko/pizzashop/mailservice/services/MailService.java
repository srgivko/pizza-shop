package by.sivko.pizzashop.mailservice.services;

import by.sivko.pizzashop.mailservice.entities.EMail;

public interface MailService {
    void sendSimpleMessage(EMail mail);
}
