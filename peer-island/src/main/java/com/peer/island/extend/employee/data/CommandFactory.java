package com.peer.island.extend.employee.data;

import com.peer.island.employee.data.process.Command;
import com.peer.island.employee.data.process.CommandArgument;
import com.peer.island.employee.data.process.InvalidCommand;
import com.peer.island.employee.data.process.OperationType;

public class CommandFactory {

	public Command getCommand(CommandArgument commandArgument) {

		Command command = null;
		if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.DISPLAY)) {
			command = new CommandDisplayEmployeeEnhanced();
		} else if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.ADD)) {
			command = new CommandAddEmployeeEnhanced();
		} else if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.DELETE)) {
			command = new CommandDeleteEmployeeEnhanced();
		}

		else {
			command = new InvalidCommand();
		}
		return command;
	}

}
