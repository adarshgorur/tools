package com.peer.island.employee.data.parser;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlBinder<T> {

	public final Class<T> typeParameterClass;

	public XmlBinder(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	@SuppressWarnings("unchecked")
	public T getUnmarshaller(File file) {
		JAXBContext jaxbContext = null;
		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbContext = JAXBContext.newInstance(typeParameterClass);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (T) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Marshaller getMarshaller() {
		JAXBContext jaxbContext = null;
		Marshaller jaxbMarshaller = null;
		try {
			jaxbContext = JAXBContext.newInstance(typeParameterClass);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			return jaxbMarshaller;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
