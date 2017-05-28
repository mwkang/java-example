package com.minwoo.kang.xml.serialize.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.minwoo.kang.xml.serialize.Sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Created on 2017. 5. 27..
 */
public class JacksonSerializationTest {

  @Test
  public void objectToXml() throws Exception {
    Sample sample = Sample.of("My name is ...", "It is email", "I am a content");

    String xml = JacksonSerialization.toXml(sample);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();

    String xml2 = JacksonSerialization.toXmlWithRoot(sample, "root");
    System.out.println(xml2);
    assertThat(xml2).isNotEmpty();
  }

  @Test
  public void mapToXml() throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("a", "value a");
    map.put("b", "value b");

    List<String> cValue = new ArrayList<>();
    cValue.add("list a");
    cValue.add("list b");
    map.put("c", cValue);

    String xml = JacksonSerialization.toXml(map);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();

    String xml2 = JacksonSerialization.toXmlWithRoot(map, "root");
    System.out.println(xml2);
    assertThat(xml2).isNotEmpty();
  }

  @Test
  public void listToXml() throws Exception {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");

    String xml = JacksonSerialization.toXml(list);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();

    String xml2 = JacksonSerialization.toXmlWithRoot(list, "root");
    System.out.println(xml2);
    assertThat(xml2).isNotEmpty();
  }

  @Test(expected = JsonMappingException.class)
  public void notSupportCharacters() throws Exception {
    Map<String, String> map = new HashMap<>();
    map.put("a", "A\u0001B");
    map.put("b", "A&lt;B");

    JacksonSerialization.toXml(map);
  }
}
