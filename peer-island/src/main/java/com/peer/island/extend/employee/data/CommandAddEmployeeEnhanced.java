package com.peer.island.extend.employee.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBException;

import com.peer.island.employee.data.parser.XmlBinder;
import com.peer.island.employee.data.process.Command;
import com.peer.island.employee.data.process.CommandArgument;
import com.peer.island.employee.data.process.Response;
import com.peer.island.employee.data.utility.Constants;

public class CommandAddEmployeeEnhanced implements Command {

	@Override
	public Response execute(CommandArgument argument) {
		// TODO Auto-generated method stub

		Address address = new Address(argument.getPropertiesMap().get(ConstantsExtended.ADDRESS_DOORNO),
				argument.getPropertiesMap().get(ConstantsExtended.ADDRESS_STREET),
				argument.getPropertiesMap().get(ConstantsExtended.ADDRESS_TOWN),
				argument.getPropertiesMap().get(ConstantsExtended.ADDRESS_STATE));
		EmployeeExtend employee = new EmployeeExtend(argument.getPropertiesMap().get(Constants.NAME_FLAG),
				argument.getPropertiesMap().get(Constants.AGE_FLAG),
				argument.getPropertiesMap().get(Constants.DESIGNATION_FLAG),address);
		XmlBinder<Employees> xmlBinder = new XmlBinder<Employees>(Employees.class);
		Employees employees = xmlBinder
				.getUnmarshaller(new File(argument.getPropertiesMap().get(Constants.FILE_FLAG)));
		employees.getEmployee().add(employee);
		try {
			xmlBinder.getMarshaller().marshal(employees,
					new FileOutputStream(new File(argument.getPropertiesMap().get(Constants.FILE_FLAG))));
		} catch (FileNotFoundException | JAXBException e) {
			return new Response(employee.toString() + " addition was not succesfull. " + e.getLocalizedMessage());
		}

		return new Response(employee.toString() + " added succesfully");

	}

}
