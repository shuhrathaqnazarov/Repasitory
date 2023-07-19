package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Response;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main<T> {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        boolean isCorrect = true;
        while (isCorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("enter location -> ");
            String location = scanner.nextLine();

            HttpRequest request = HttpRequest.newBuilder(URI.create("http://api.weatherapi.com/v1/current.json" +
                            "?key=ca82b8e4aed4423a92545220230507&" +
                            "q=" + location))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            String body = response.body();

            Response responseObject = gson.fromJson(body, Response.class);
            if (responseObject.getLocation() == null) {
                System.out.println("location error");
                }else {
                    System.out.println(responseObject);
                System.out.println("         responseObject.current.getTemp_c() = " + responseObject.current.getTemp_c());
                isCorrect=false;
                }
        }
    }
}