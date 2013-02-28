package com.zhentao.review;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareJson {
    public static void main(String[] args) throws JsonProcessingException, IOException {
        String json1 = "{\"a\":1}";
        compare(json1, json1);
    }

    public static boolean compare(String json1, String json2) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree1 = mapper.readTree(json1);
        JsonNode tree2 = mapper.readTree(json2);
        return tree1.equals(tree2);
    }
}
