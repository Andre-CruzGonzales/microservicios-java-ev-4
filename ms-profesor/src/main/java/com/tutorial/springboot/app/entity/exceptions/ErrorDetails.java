package com.tutorial.springboot.app.entity.exceptions;

import java.util.Date;

import com.tutorial.springboot.app.entity.Profesor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	
	
}
