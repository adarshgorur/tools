package com.peer.island.employee.data.validation;

import java.util.function.Function;
import java.util.function.Predicate;

public interface CommandValidation extends Function<String[], ValidationResult> {
	static CommandValidation isCommandSupported() {
		return testCommand(
				(String[] arguments) -> 
	
				((arguments[0].equalsIgnoreCase("ADD"))
						|| (arguments[0].equalsIgnoreCase("DELETE")) ||arguments[0].equalsIgnoreCase("DISPLAY")),
				"Unrecognized option:Supported option ADD,DELETE and DISPLAY is supported");
	}
	
	
	static CommandValidation isValidArguments() {
		return testCommand(
				(String[] arguments) -> 
	
				((arguments.length>=2)),
				"Invalid Arguments. Usage: DISPLAY/ADD/DELETE [--file=File_location] [Employee_Parameters]");
	}

	static CommandValidation testCommand(Predicate<String[]> p, String message) {
		return commandObject -> p.test(commandObject) ? new Valid("Success") : new Invalid(message);
	}

	default CommandValidation and(CommandValidation other) {
		return commandObject -> {
			final ValidationResult result = this.apply(commandObject);
			return result.isValid() ? other.apply(commandObject) : result;
		};
	}
}
