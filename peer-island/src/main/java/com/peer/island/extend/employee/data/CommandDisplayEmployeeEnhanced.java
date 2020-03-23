package com.peer.island.extend.employee.data;

import java.io.File;
import com.peer.island.employee.data.parser.XmlBinder;
import com.peer.island.employee.data.process.Command;
import com.peer.island.employee.data.process.CommandArgument;
import com.peer.island.employee.data.process.Response;
import com.peer.island.employee.data.utility.Constants;

public class CommandDisplayEmployeeEnhanced implements Command {

	@Override
	public Response  execute(CommandArgument argument) {
		XmlBinder<Employees> xmlBinder=new XmlBinder<Employees>(Employees.class);
		Employees employees=xmlBinder.getUnmarshaller(new File(argument.getPropertiesMap().get(Constants.FILE_FLAG)));
		return new Response(employees.toString());
	}

}
