package com.peer.island.employee.data.process;

import java.io.File;

import com.peer.island.employee.data.parser.Employees;
import com.peer.island.employee.data.parser.XmlBinder;
import com.peer.island.employee.data.utility.Constants;

public class CommandDisplayEmployee implements Command {

	@Override
	public Response  execute(CommandArgument argument) {
		XmlBinder<Employees> xmlBinder=new XmlBinder<Employees>(Employees.class);
		Employees employees=xmlBinder.getUnmarshaller(new File(argument.getPropertiesMap().get(Constants.FILE_FLAG)));
		return new Response(employees.toString());
	}

}
