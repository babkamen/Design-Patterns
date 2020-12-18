package com.babkamen.game_example.be_example.handler;

import com.babkamen.game_example.be_example.exception.AccessDeniedException;
import com.babkamen.game_example.be_example.request.AnonymousRequest;
import com.babkamen.game_example.be_example.request.AuthenticatedRequest;
import com.babkamen.game_example.be_example.request.Request;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationHandler extends BaseHandler {

    private Map<String, String> users = new HashMap<>();

    public AuthenticationHandler() {
        users.put("admin", "password");
    }

    @Override
    public void execute(final Request request) {
        if (request instanceof AnonymousRequest) {
            throw new AccessDeniedException();
        }
        AuthenticatedRequest authenticatedRequest = (AuthenticatedRequest) request;
        if (!authenticatedRequest.getPassword().equals(users.get(authenticatedRequest.getUsername()))) {
            throw new AccessDeniedException();
        }
        super.execute(request);
    }
}
