package com.test;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpClientTest extends BaseUrl {
    String a = "qwerty";
    String b = "asdf";
    String c = "zxczv";
    HttpClient client = HttpClient.newHttpClient();

    @Test
    public void createUser() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .headers("firstName", "" + a + "", "lastName", "" + b + a)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assertions.assertTrue(response.body().matches("\\[\\{ID\\=\\d+\\, FIRSTNAME\\=qwerty\\, LASTNAME\\=asdfqwerty\\}\\]"));
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }

    @Test
    public void createFirst() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .header("firstName", "1" + b + a + c)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assertions.assertTrue(response.body().matches("\\[\\{ID\\=\\d+\\, FIRSTNAME\\=1asdfqwertyzxczv\\, LASTNAME\\=\\}\\]"));
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }

    @Test
    public void createLast() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .header("lastName", "2" + c)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assertions.assertTrue(response.body().matches("\\[\\{ID\\=\\d+\\, FIRSTNAME\\=\\, LASTNAME\\=2zxczv\\}\\]"));
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }

    @Test
    public void createEmptry() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .headers("firstName", "", "lastName", "")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        Assertions.assertTrue(response.body().matches("\\[\\{ID\\=\\d+\\, FIRSTNAME\\=\\, LASTNAME\\=\\}\\]"));
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }

    @Test
    public void delUser() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/3"))
                .DELETE()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }

    @Test
    public void updateUser() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/4?restletMethods=PUT"))
                .headers("firstName", "qwe11" + c, "lastName", "asd11" + a)
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }
    @Test
    public void updateFirst() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/1?restletMethods=PUT"))
                .header("firstName", "first"+a)
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());
    }
    @Test
    public void updateLast() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/1?restletMethods=PUT"))
                .header("lastName", "last" + b)
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }
    @Test
    public void updateEmpty() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/1?restletMethods=PUT"))
                .headers("firstName", "", "lastName", "")
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }
    @Test
    public void getUsers() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl))
                .GET()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
        System.out.println(response.body());
        System.out.println(response.statusCode());

    }
}
