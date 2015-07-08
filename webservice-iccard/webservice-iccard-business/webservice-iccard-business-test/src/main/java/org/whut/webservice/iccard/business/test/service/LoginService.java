package org.whut.webservice.iccard.business.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.whut.webservice.common.security.UserContext;
import org.whut.webservice.iccard.business.test.api.ILoginService;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-8
 * Time: 上午2:00
 * To change this template use File | Settings | File Templates.
 */
public class LoginService implements ILoginService {
    private static final Logger logger =
            LoggerFactory.getLogger(LoginService.class);

    @Override
    public String currentUser() {
        String userName = UserContext.currentUser().getUserName();
        logger.info("currentUser: {}", userName);

        return userName;
    }
}
