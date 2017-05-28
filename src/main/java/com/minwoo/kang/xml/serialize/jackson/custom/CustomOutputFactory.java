package com.minwoo.kang.xml.serialize.jackson.custom;

import com.fasterxml.aalto.stax.OutputFactoryImpl;
import java.io.OutputStream;
import java.io.Writer;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;

/**
 * Created on 2017. 5. 28..
 */
class CustomOutputFactory extends XMLOutputFactory {

  private OutputFactoryImpl outputFactory = new OutputFactoryImpl();

  CustomOutputFactory() {
    System.out.println("CustomOutputFactory was created.");
  }

  @Override
  public XMLStreamWriter createXMLStreamWriter(Writer stream) throws XMLStreamException {
    return new CustomStreamWriter(outputFactory.createXMLStreamWriter(stream));
  }

  @Override
  public XMLStreamWriter createXMLStreamWriter(OutputStream stream) throws XMLStreamException {
    return new CustomStreamWriter(outputFactory.createXMLStreamWriter(stream));
  }

  @Override
  public XMLStreamWriter createXMLStreamWriter(OutputStream stream, String encoding)
      throws XMLStreamException {
    return new CustomStreamWriter(outputFactory.createXMLStreamWriter(stream, encoding));
  }

  @Override
  public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
    return new CustomStreamWriter(outputFactory.createXMLStreamWriter(result));
  }

  @Override
  public XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException {
    return outputFactory.createXMLEventWriter(result);
  }

  @Override
  public XMLEventWriter createXMLEventWriter(OutputStream stream) throws XMLStreamException {
    return outputFactory.createXMLEventWriter(stream);
  }

  @Override
  public XMLEventWriter createXMLEventWriter(OutputStream stream, String encoding)
      throws XMLStreamException {
    return outputFactory.createXMLEventWriter(stream, encoding);
  }

  @Override
  public XMLEventWriter createXMLEventWriter(Writer stream) throws XMLStreamException {
    return outputFactory.createXMLEventWriter(stream);
  }

  @Override
  public void setProperty(String name, Object value) throws IllegalArgumentException {
    outputFactory.setProperty(name, value);
  }

  @Override
  public Object getProperty(String name) throws IllegalArgumentException {
    return outputFactory.getProperty(name);
  }

  @Override
  public boolean isPropertySupported(String name) {
    return outputFactory.isPropertySupported(name);
  }
}
