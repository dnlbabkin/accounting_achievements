package com.example.accounting;

import com.example.accounting.models.StudentModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class AchievementsTest {

    @Autowired
    private JacksonTester<StudentModel> json;

    @Test
    public void serializationJsonTest() throws Exception{
        StudentModel studentModel = new StudentModel("test_name", "test_surname", 3, "test_achievement");

        JsonContent<StudentModel> result = this.json.write(studentModel);

        assertThat(result).hasJsonPathStringValue("$.name");
        assertThat(result).extractingJsonPathStringValue("$.name").isEqualTo("test_name");
        assertThat(result).extractingJsonPathStringValue("$.surname").isEqualTo("test_surname");
        assertThat(result).extractingJsonPathNumberValue("$.course").isEqualTo(3);
        assertThat(result).extractingJsonPathStringValue("$.achievement").isEqualTo("test_achievement");
    }

    @Test
    public void deserializationJsonTest() throws Exception{
        String content = "{\n" +
                "    \"name\": \"John\",\n" +
                "    \"surname\": \"Smith\",\n" +
                "    \"course\": 2,\n" +
                "    \"achievement\": \"Sertificate Java Oracle\"\n" +
                "}";

        StudentModel result = this.json.parse(content).getObject();

        assertThat(result.getName()).isEqualTo("John");
        assertThat(result.getSurname()).isEqualTo("Smith");
        assertThat(result.getCourse()).isEqualTo(2);
        assertThat(result.getAchievement()).isEqualTo("Sertificate Java Oracle");
    }
}
