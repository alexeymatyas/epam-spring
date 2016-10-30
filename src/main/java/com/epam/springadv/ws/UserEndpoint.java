package com.epam.springadv.ws;

import com.epam.springadv.model.services.UserService;
import com.epam.springadv.ws.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Alexey on 29.10.2016.
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://com.epam.springadv";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    public GetUsersResponse getUsers(@RequestPayload GetUsersRequest request) {
        GetUsersResponse response = new GetUsersResponse();
        response.setUsers(userService.getAllUsers());

        return response;
    }
}
