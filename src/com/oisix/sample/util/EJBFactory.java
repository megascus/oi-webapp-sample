/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author megascus
 */
public final class EJBFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getEJB(Class<T> clazz) {
        Context ctx;
        try {
            ctx = new InitialContext();
            return (T) ctx.lookup("java:module/" + clazz.getSimpleName());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
