package com.msquared;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

/**
 * Created by S on 12/5/15.
 */
public interface HouseService {

    @GET
    @ResponseBody
    public Response serveMe() throws Exception;
}
