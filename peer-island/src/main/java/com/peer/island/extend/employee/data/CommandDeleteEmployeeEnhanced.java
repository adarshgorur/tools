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

public class CommandDeleteEmployeeEnhanced implements Command {

	@Override
	public Response execute(CommandArgument argument) {

		EmployeeExtend employee = new EmployeeExtend(argument.getPropertiesMap().get(Constants.NAME_FLAG),
				argument.getPropertiesMap().get(Constants.AGE_FLAG),
				argument.getPropertiesMap().get(Constants.DESIGNATION_FLAG),new Address());
		XmlBinder<Employees> xmlBinder = new XmlBinder<Employees>(Employees.class);
		Employees employees = xmlBinder.getUnmarshaller(new File(argument.getPropertiesMap().get(Constants.FILE_FLAG)));
		int index = employees.getEmployee().indexOf(employee);
		if (index < 0) {
			return new Response(employee.toString() + " deletion was not succesfull");
		}
		employees.getEmployee().remove(index);
		try {
			xmlBinder.getMarshaller().marshal(employees,
					new FileOutputStream(argument.getPropertiesMap().get(Constants.FILE_FLAG)));
		} catch (FileNotFoundException | JAXBException e) {
			return new Response(employee.toString() + "  was not succesfull. " + e.getLocalizedMessage());
		}

		return new Response(employee.toString() + " deletion succesfull");

	}

}
