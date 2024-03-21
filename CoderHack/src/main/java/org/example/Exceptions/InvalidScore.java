package org.example.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidScore extends RuntimeException{
   private String message;
}
