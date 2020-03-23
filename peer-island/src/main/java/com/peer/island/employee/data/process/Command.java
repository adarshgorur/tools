package com.peer.island.employee.data.process;

public interface  Command {

	public Response execute(CommandArgument argument);

}
