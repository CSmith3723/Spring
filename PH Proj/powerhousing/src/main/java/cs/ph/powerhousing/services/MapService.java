package cs.ph.powerhousing.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchByCity(String cityName) {
        // Endpoint for searching addresses
        String endpoint = String.format("https://www.google.com/maps/embed/v1/place?key=%s&q=%s",
                apiKey, cityName);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Subscription-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
