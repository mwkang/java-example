package com.minwoo.kang.xml.serialize.jackson.custom;

import static org.assertj.core.api.Assertions.assertThat;

import com.minwoo.kang.xml.serialize.Sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Created on 2017. 5. 28..
 */
public class CustomJacksonSerializationTest {

  @Test
  public void objectToXml() throws Exception {
    Sample sample = Sample.of("My name is ...", "It is email", "I am a content");

    String xml = CustomJacksonSerialization.toXml(sample);
    System.out.println(xml);
    assertThat(xml).contains(
        "Override Output"); //output was changed by CustomStreamWriter.writeCharacters(java.lang.String)

    String xml2 = CustomJacksonSerialization.toXmlWithRoot(sample, "root");
    System.out.println(xml2);
    assertThat(xml2).contains("Override Output");
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

    String xml = CustomJacksonSerialization.toXml(map);
    System.out.println(xml);
    assertThat(xml).contains("Override Output");

    String xml2 = CustomJacksonSerialization.toXmlWithRoot(map, "root");
    System.out.println(xml2);
    assertThat(xml2).contains("Override Output");
  }

  @Test
  public void listToXml() throws Exception {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");

    String xml = CustomJacksonSerialization.toXml(list);
    System.out.println(xml);
    assertThat(xml).contains("Override Output");

    String xml2 = CustomJacksonSerialization.toXmlWithRoot(list, "root");
    System.out.println(xml2);
    assertThat(xml2).contains("Override Output");
  }
}
