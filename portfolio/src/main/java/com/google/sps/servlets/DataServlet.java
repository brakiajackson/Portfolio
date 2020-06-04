// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    
  private List<String> messages = new ArrayList<String>();

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String name = request.getParameter("name");
	response.getOutputStream().println("<h1>Hello " + name + "!</h1>");
	String message = request.getParameter("message");
	String chatMessage = name + ": " + message;
	messages.add(chatMessage);
	response.getOutputStream().println("<p>Your message has been received.</p>");
	response.getOutputStream().println("<p>Click <a href=\"/data\">here</a> to go back to the comments.</p>");

    
	

  }




  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.getOutputStream().println("<h1>Comments</h1>");
	response.getOutputStream().println("<hr/>");
		
	for(int i = 0; i < messages.size(); i++){
		response.getOutputStream().println("<p>" + messages.get(i) + "</p>");
	}
	response.getOutputStream().println("<hr/>");
		
	response.getOutputStream().println("<form action=\"/data\" method=\"POST\">");
	response.getOutputStream().println("<input type=\"text\" name=\"name\" value=\"Ada\">");
	response.getOutputStream().println("<input type=\"text\" name=\"message\" value=\"Type here.\">");
	response.getOutputStream().println("<input type=\"submit\" value=\"Send\">");
	response.getOutputStream().println("</form>");
	}




  

  private String convertToJsonUsingGson(ArrayList<String> comments_list) {
    Gson gson = new Gson();
    String json = gson.toJson(comments_list);
    return json;
  }

  
}


