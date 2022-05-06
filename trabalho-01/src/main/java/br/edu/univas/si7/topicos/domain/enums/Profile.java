package br.edu.univas.si7.topicos.domain.enums;

import java.util.stream.Stream;

public enum Profile {

	ADMIM(1, "ROLE_ADMIM"),
	CUSTOMER(2, "ROLE_CUSTOMER");
	
    private int code;
    private String description;

    private Profile(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Profile toEnum(String description) {

        return Stream.of(Profile.values())
          .filter(t -> t.getDescription().equals(description))
          .findFirst()
          .orElseThrow(() -> new IllegalArgumentException("Invalid profile: " + description));
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
