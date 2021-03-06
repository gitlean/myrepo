package com.hsoft;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 *
 * @author yibo.liu
 */
public class JacksonMapper {
    /**
     * can reuse, share globally
     */
    private static final ObjectMapper object = new ObjectMapper();

    /**
     * can reuse, share globally
     */
    private static final XmlMapper xml = new XmlMapper();

    /**
     * private constructor
     */
    private JacksonMapper() {
    }

    /**
     * return a ObjectMapper that is singleton
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return object;
    }

    /**
     * return a XmlMapper that is singleton
     * @return
     */
    public static XmlMapper getXmlMapper() {
        return xml;
    }
}