package handler;

import request.AnonymousRequest;
import request.AuthenticatedRequest;
import exception.AccessDeniedException;
import request.Request;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationHandler extends BaseHandler {
    private Map<String, String> users = new HashMap<>();
    {
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
