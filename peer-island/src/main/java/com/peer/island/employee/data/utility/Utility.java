package com.peer.island.employee.data.utility;

import java.util.HashMap;
import java.util.Map;

import com.peer.island.employee.data.process.CommandArgument;

public class Utility {

	public static CommandArgument ParseArguments(String[] args) {

		Map<String,String> map=new HashMap<String, String>();
		for (int i = 0, j = 1; i < args.length - 1; i++, j++) {

			String[] key_value=args[j].split("=");
			map.put(key_value[0],key_value[1]);

		}

		return new CommandArgument(args[0], map);
	}

}
