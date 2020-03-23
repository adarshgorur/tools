package com.peer.island.employee.data.process;

public class CommandFactory {

	public Command getCommand(CommandArgument commandArgument) {

		Command command = null;
		if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.ADD)) {
			command = new CommandAddEmployee();
		} else if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.DELETE)) {
			command = new CommandDeleteEmployee();
		} else if (OperationType.valueOf(commandArgument.getOperation()).equals(OperationType.DISPLAY)) {
			command = new CommandDisplayEmployee();
		}

		else {
			command = new InvalidCommand();
		}
		return command;
	}

}
