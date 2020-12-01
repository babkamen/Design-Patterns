package request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthenticatedRequest extends Request {
    private String username, password;

    @Builder
    public AuthenticatedRequest(final String url, final String username, final String password) {
        super(url);
        this.username = username;
        this.password = password;
    }

}
