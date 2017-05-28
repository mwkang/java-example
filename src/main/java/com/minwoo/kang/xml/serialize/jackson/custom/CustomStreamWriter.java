package com.minwoo.kang.xml.serialize.jackson.custom;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created on 2017. 5. 28..
 */
class CustomStreamWriter implements XMLStreamWriter {

  private XMLStreamWriter w;

  public CustomStreamWriter(XMLStreamWriter w) {
    //Indent Output
    this.w = new IndentingXMLStreamWriter(w);
  }

  @Override
  public void writeStartElement(String localName) throws XMLStreamException {
    w.writeStartElement(localName);
  }

  @Override
  public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
    w.writeStartElement(namespaceURI, localName);
  }

  @Override
  public void writeStartElement(String prefix, String localName, String namespaceURI)
      throws XMLStreamException {
    w.writeStartElement(prefix, localName, namespaceURI);
  }

  @Override
  public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
    w.writeEmptyElement(namespaceURI, localName);
  }

  @Override
  public void writeEmptyElement(String prefix, String localName, String namespaceURI)
      throws XMLStreamException {
    w.writeEmptyElement(prefix, localName, namespaceURI);
  }

  @Override
  public void writeEmptyElement(String localName) throws XMLStreamException {
    w.writeEmptyElement(localName);
  }

  @Override
  public void writeEndElement() throws XMLStreamException {
    w.writeEndElement();
  }

  @Override
  public void writeEndDocument() throws XMLStreamException {
    w.writeEndDocument();
  }

  @Override
  public void close() throws XMLStreamException {
    w.close();
  }

  @Override
  public void flush() throws XMLStreamException {
    w.flush();
  }

  @Override
  public void writeAttribute(String localName, String value) throws XMLStreamException {
    w.writeAttribute(localName, value);
  }

  @Override
  public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
      throws XMLStreamException {
    w.writeAttribute(prefix, namespaceURI, localName, value);
  }

  @Override
  public void writeAttribute(String namespaceURI, String localName, String value)
      throws XMLStreamException {
    w.writeAttribute(namespaceURI, localName, value);
  }

  @Override
  public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
    w.writeNamespace(prefix, namespaceURI);
  }

  @Override
  public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
    w.writeDefaultNamespace(namespaceURI);
  }

  @Override
  public void writeComment(String data) throws XMLStreamException {
    w.writeComment(data);
  }

  @Override
  public void writeProcessingInstruction(String target) throws XMLStreamException {
    w.writeProcessingInstruction(target);
  }

  @Override
  public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
    w.writeProcessingInstruction(target, data);
  }

  @Override
  public void writeCData(String data) throws XMLStreamException {
    w.writeCData(data);
  }

  @Override
  public void writeDTD(String dtd) throws XMLStreamException {
    w.writeDTD(dtd);
  }

  @Override
  public void writeEntityRef(String name) throws XMLStreamException {
    w.writeEntityRef(name);
  }

  @Override
  public void writeStartDocument() throws XMLStreamException {
    w.writeStartDocument();
  }

  @Override
  public void writeStartDocument(String version) throws XMLStreamException {
    w.writeStartDocument(version);
  }

  @Override
  public void writeStartDocument(String encoding, String version) throws XMLStreamException {
    w.writeStartDocument(encoding, version);
  }

  @Override
  public void writeCharacters(String text) throws XMLStreamException {
    //I can do something here.
    System.out.println(text);

    //I override output.
    w.writeCharacters("Override Output");
  }

  @Override
  public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
    w.writeCharacters(text, start, len);
  }

  @Override
  public String getPrefix(String uri) throws XMLStreamException {
    return w.getPrefix(uri);
  }

  @Override
  public void setPrefix(String prefix, String uri) throws XMLStreamException {
    w.setPrefix(prefix, uri);
  }

  @Override
  public void setDefaultNamespace(String uri) throws XMLStreamException {
    w.setDefaultNamespace(uri);
  }

  @Override
  public NamespaceContext getNamespaceContext() {
    return w.getNamespaceContext();
  }

  @Override
  public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
    w.setNamespaceContext(context);
  }

  @Override
  public Object getProperty(String name) throws IllegalArgumentException {
    return w.getProperty(name);
  }
}
