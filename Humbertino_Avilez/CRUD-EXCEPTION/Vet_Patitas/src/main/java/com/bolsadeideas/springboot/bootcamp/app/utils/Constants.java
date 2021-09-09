package com.bolsadeideas.springboot.bootcamp.app.utils;

public class Constants {
	
	public enum ResponseConstants {
		SUCCESS("Successful"), FAILURE("Unsuccessful");

		private String description;

		ResponseConstants(final String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	public static final String NO_FOUND_ANIMAL = "ID Animal not found: ";
	public static final String ANIMAL_CREATED = "created animal";
	public static final String ANIMAL_FOUND = "found animal";
	public static final String ANIMAL_UPDATED = "updated animal";
	public static final String ANIMAL_DELETED = "deleted animal";
}
