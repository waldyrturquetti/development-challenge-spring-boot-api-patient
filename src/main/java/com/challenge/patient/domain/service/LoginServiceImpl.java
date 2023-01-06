package com.challenge.patient.domain.service;

import com.challenge.patient.application.dto.LoginDTO;
import com.challenge.patient.exception.ForbiddenException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class LoginServiceImpl implements LoginService{
    private final Environment environment;

    public LoginServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Object login(LoginDTO loginDTO) throws IOException {

        URL url = new URL(environment.getProperty("firebase.url.login") +
                environment.getProperty("firabase.api.key"));

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(HttpMethod.POST.name());
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginDTO);

        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return new Gson().fromJson(String.valueOf(response), Object.class);
        } else {
            throw new ForbiddenException("Invalid Email or Password");
        }
    }
}
