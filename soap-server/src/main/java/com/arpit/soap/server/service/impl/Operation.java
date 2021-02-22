package com.arpit.soap.server.service.impl;

import com.arpit.soap.server.model.OperationSoap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@WebService(serviceName = "Operation", targetNamespace = "http://example/")
public class Operation
{
    private static List<OperationSoap> dataOperation = new ArrayList<>();

    static {

        for (int i = 1; i <= 100; i++)
        {
            OperationSoap operation = new OperationSoap();
            operation.setOperationId(i);
            if (i%2==0) {
                operation.setName("OPERATION"+i);
                operation.setTypeOperation("TIPO II");
            } else {
                operation.setName("TEST"+i);
                operation.setTypeOperation("TIPO I");
            }

            dataOperation.add(operation);

        }

    }

    @WebMethod
    public List<OperationSoap> operationSoap(@WebParam(name = "page") String page,
                                             @WebParam(name = "quantity") String quantity,
                                             @WebParam(name = "id") Integer id)
    {


        List<OperationSoap> data = new ArrayList<>(dataOperation);

        if (id != null)
        {
//			return data.stream().filter(m -> m.getId().equals(id)).collect(Collectors.toList());
        }

        return Util.doPagination(page, quantity, data);
    }
    }