package com.arpit.soap.server.service.impl;



import javax.xml.bind.annotation.XmlElement;

public class EntityWithDots
{
//    @XmlElement(name="neoID")
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getYourField()
    {
        return yourField;
    }

    public void setYourField(String yourField)
    {
        this.yourField = yourField;
    }

//    @XmlElement(name="FilterXX")
    public String getFilter001() {
        return filter001;
    }

    public void setFilter001(String filter001) {
        this.filter001 = filter001;
    }

    private Long id;
    private String yourField;
    private String filter001;

}
