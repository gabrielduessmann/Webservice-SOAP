package com.arpit.soap.server.model;

import javax.xml.bind.annotation.XmlElement;

public class OperationSoap {

    @XmlElement(name="operationId")
    private Integer operationId;
    private String typeOperation;
    private String name;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
