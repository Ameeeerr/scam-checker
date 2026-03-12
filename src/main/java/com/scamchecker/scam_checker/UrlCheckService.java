package com.scamchecker.scam_checker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;

@Service
public class UrlCheckService {

    @Value("${safe.browsing.api.key}")
    private String apiKey;

    public String checkUrl(String url) {
        String apiUrl = "https://safebrowsing.googleapis.com/v4/threatMatches:find?key=" + apiKey;

        // Build the request body
        Map<String, Object> client = Map.of(
                "clientId", "scam-checker",
                "clientVersion", "1.0"
        );

        Map<String, Object> threatEntry = Map.of("url", url);

        Map<String, Object> threatInfo = Map.of(
                "threatTypes", List.of("MALWARE", "SOCIAL_ENGINEERING", "UNWANTED_SOFTWARE", "POTENTIALLY_HARMFUL_APPLICATION"),
                "platformTypes", List.of("ANY_PLATFORM"),
                "threatEntryTypes", List.of("URL"),
                "threatEntries", List.of(threatEntry)
        );

        Map<String, Object> body = Map.of(
                "client", client,
                "threatInfo", threatInfo
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);

        // Empty response means URL is SAFE
        String responseBody = response.getBody();
        if (responseBody == null || responseBody.trim().equals("{}") || !responseBody.contains("matches")) {
            return "{\"result\": \"SAFE\", \"message\": \"No threats detected for this URL\"}";
        } else {
            return "{\"result\": \"DANGEROUS\", \"message\": \"Threat detected!\", \"details\": " + responseBody + "}";
        }
    }
}