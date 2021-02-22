package com.arpit.soap.server.service;

import com.arpit.soap.server.model.ApplicationCredentials;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface OperationSoapService {

    @WebMethod(operationName = "helloWorld", action = "https://aggarwalarpit.wordpress.com/hello-world/helloWorld")
    String helloWorld(final String name,
            @WebParam(header = true) final ApplicationCredentials credential);

}
