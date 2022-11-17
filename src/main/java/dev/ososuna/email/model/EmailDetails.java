package dev.ososuna.email.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailDetails {
  private String recipient;
  private String msgBody;
  private String subject;
  private String attachment;
}
