package handler;

import request.Request;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StatisticsHandler extends BaseHandler {
    private List<String> usedUrls = new ArrayList<>();

    @Override
    public void execute(Request request) {
        usedUrls.add(request.getUrl());
        super.execute(request);
    }
}
