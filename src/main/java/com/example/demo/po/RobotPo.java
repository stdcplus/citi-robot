package com.example.demo.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
public class RobotPo {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String question;

    @Field(type = FieldType.Text)
    private String answer;

    @Field(type = FieldType.Keyword)
    private String label;


}
