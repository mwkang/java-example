package com.minwoo.kang.xml.serialize.jackson.custom;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature;

/**
 * Created on 2017. 5. 28..
 */
class CustomJacksonSerialization {

  /*
  Not support SerializationFeature.INDENT_OUTPUT.
  But If I want to indent output, Using IndentingXMLStreamWriter.
   */
  private static final ObjectMapper xmlMapper;

  static {
    XmlFactory xmlFactory = new XmlFactory(new InputFactoryImpl(), new CustomOutputFactory());
    xmlFactory.configure(Feature.WRITE_XML_1_1, true);
    xmlMapper = new XmlMapper(xmlFactory);
  }

  static String toXml(Object o) throws JsonProcessingException {

    return xmlMapper.writeValueAsString(o);
  }

  static String toXmlWithRoot(Object o, String root) throws JsonProcessingException {
    return xmlMapper.writer().withRootName(root).writeValueAsString(o);
  }
}
