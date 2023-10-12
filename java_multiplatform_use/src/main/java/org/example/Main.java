package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Exam a = new Exam("DY", 9, "Radino");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(a);
        System.out.println(json);
    }
}