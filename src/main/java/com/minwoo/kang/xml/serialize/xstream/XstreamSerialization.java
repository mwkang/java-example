package com.minwoo.kang.xml.serialize.xstream;

import com.thoughtworks.xstream.XStream;

/**
 * Created on 2017. 5. 27..
 */
class XstreamSerialization {

  private static final XStream xStream = new XStream();

  static String toXml(Object o) {
    return xStream.toXML(o);
  }
}
