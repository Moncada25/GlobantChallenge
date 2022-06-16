package com.globant.challenge.wordpress.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Environment {

  private String url;
  private String browser;
}
