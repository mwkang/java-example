package com.minwoo.kang.xml.serialize.xstream;

import static org.assertj.core.api.Assertions.assertThat;

import com.minwoo.kang.xml.serialize.Sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Created on 2017. 5. 27..
 */
public class XstreamSerializationTest {

  @Test
  public void objectToXml() throws Exception {
    Sample sample = Sample.of("My name is ...", "It is email", "I am a content");
    assertThat(sample).isNotNull();

    String xml = XstreamSerialization.toXml(sample);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();
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

    String xml = XstreamSerialization.toXml(map);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();
  }

  @Test
  public void listToXml() throws Exception {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");

    String xml = XstreamSerialization.toXml(list);
    System.out.println(xml);
    assertThat(xml).isNotEmpty();
  }
}
