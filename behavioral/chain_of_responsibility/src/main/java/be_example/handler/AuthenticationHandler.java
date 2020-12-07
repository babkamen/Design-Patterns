package be_example.handler;

import be_example.request.AnonymousRequest;
import be_example.request.AuthenticatedRequest;
import be_example.exception.AccessDeniedException;
import be_example.request.Request;

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
