package com.minwoo.kang.xml.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Created on 2017. 5. 27..
 */
public class JacksonSerialization {

  private static final ObjectMapper xmlMapper = new XmlMapper()
      .enable(SerializationFeature.INDENT_OUTPUT);

  static String toXml(Object o) throws JsonProcessingException {

    return xmlMapper.writeValueAsString(o);
  }

  static String toXmlWithRoot(Object o, String root) throws JsonProcessingException {
    return xmlMapper.writer().withRootName(root).writeValueAsString(o);
  }
}
