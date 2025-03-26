package my.group.dto;

import lombok.Data;

@Data
public class EmailDTO {

    private String recipient;
    private String subject;
    private String messageBody;
}
