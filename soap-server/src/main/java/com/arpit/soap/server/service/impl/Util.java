package com.arpit.soap.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebParam;

public class Util
{
    public static <T> List<T> doPagination(String page, String quantity, List<T> collection) {
        int top;

        try {
            top = Integer.valueOf(quantity);
        } catch (Exception e) {
            top = 20;
        }

        if (page != null && !page.isEmpty()) {

            int p = Integer.parseInt(page) + 1;

            int skip;

            if (p == 1) {
                skip = 0;
            } else {
                skip = (p - 1) * top;
            }
            if (skip >= collection.size() - 1) {
                return new ArrayList<>();
            }

            int offset = skip + top;

            if (offset > collection.size() - 1) {
                offset = collection.size();
            }

            return collection.subList(skip, offset);
        }
        return collection;

    }
    }
