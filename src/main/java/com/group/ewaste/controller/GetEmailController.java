package com.group.ewaste.controller;

import com.group.ewaste.domain.Email;
import com.group.ewaste.domain.UserBean;
import com.group.ewaste.service.GetEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class GetEmailController {

    @Autowired
    private GetEmailService getEmailService;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public Email getEmail(String username) {
        return getEmailService.getEmail(username);
    }

}
