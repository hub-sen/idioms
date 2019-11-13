package com.shisen.idioms.blog.part7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description
 * </pre>
 */
@AllArgsConstructor
@Setter
@Getter
public class Device {

	private Boolean available;
	private String name;

	public void checkOut() {
		available = false;
	}

	public void checkIn() {
		available = true;
	}

}
