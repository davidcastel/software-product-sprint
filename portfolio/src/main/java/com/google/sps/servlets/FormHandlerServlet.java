package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the values entered in the form.
        String emailValue = request.getParameter("email-input");
        String textValue = request.getParameter("text-input");

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted : " + textValue + "\n By : " + emailValue);

        // Create instance of DataStore
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        // Create a key with a "kind"
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Email");
        FullEntity emailEntity = Entity.newBuilder(keyFactory.newKey()).set("Email", emailValue)
                .set("Message", textValue).build();

        datastore.put(emailEntity);

        // Write the value to the response so the user can see it.
        response.sendRedirect("/");
    }
}