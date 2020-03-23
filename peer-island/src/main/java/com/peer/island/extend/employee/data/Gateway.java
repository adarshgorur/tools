package com.peer.island.extend.employee.data;

import java.util.Scanner;
import org.apache.log4j.Logger;
import com.peer.island.employee.data.process.CommandArgument;
import com.peer.island.employee.data.process.Response;
import com.peer.island.employee.data.utility.Utility;
import com.peer.island.employee.data.validation.CommandValidation;
import com.peer.island.employee.data.validation.ValidationResult;

public class Gateway {

	private static final Logger LOGGER = Logger.getLogger(Gateway.class);

	private static CommandFactory commandFactory = new CommandFactory();

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		Gateway.commandFactory = commandFactory;
	}

	public static void main(String[] args) {

		// display --file=C:\eclipse-project\peer-island\input\employee_data.xml
		// add --file=C:\eclipse-project\peer-island\input\employee_data.xml --name=adarsh --age=25 --designation=staff_engineer --address.doorno=323 --address.street=bellandur --address.town=bangalore --address.state=karnataka 
		// delete --file=C:\eclipse-project\peer-island\input\employee_data.xml --name=adarsh --age=25 --designation=staff_engineer
		LOGGER.info("Starting the command line interface");

		while (true) {
			Scanner scanner = new Scanner(System.in);
			scanner.useDelimiter(System.getProperty("line.separator"));
			System.out.println("Type :Exit to exit the command line interface.");
			System.out.println(
					"Type in expressions to have them evaluated. Usage: DISPLAY/ADD/DELETE [File_location] [Employee_Parameters] ");
			String inputData = scanner.next().toUpperCase();
			if (inputData.equalsIgnoreCase("EXIT")) {
				System.exit(0);
				scanner.close();
			}

			ValidationResult result = validateCommand(inputData);

			if (!result.isValid()) {

				System.out.println(result.getReason().get());

			} else {
				CommandArgument commandArgument = Utility.ParseArguments(inputData.split(" "));
				com.peer.island.employee.data.process.Command command = commandFactory.getCommand(commandArgument);
				Response response = command.execute(commandArgument);
				System.out.println((response.getMessage()));
			}
		}
	}

	public static ValidationResult validateCommand(String inputData) {

		CommandValidation validation = CommandValidation.isCommandSupported().and(CommandValidation.isValidArguments());
		return validation.apply(inputData.split(" "));

	}
}
