import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import Models.*;

public class Client implements ClientAPI{
    public static void main(String[] args)
    {
        Client client = new Client();
        // Teacher teach = new Teacher();
        // teach.Email = "helo@gmail.com";
        // teach.Name = "hello world";
        // teach.Password  = "121212";
        // teach.Phone = "0202020202";
        // client.post_teacher(teach);
        ArrayList<Student> stds = (ArrayList)client.get_students();
        for (int i = 0; i < stds.size(); i++) {
            System.out.println(stds.get(i).toString());
        }
       // System.out.println(stds.toString());
    }
    @Override
    public List<Student> get_students()
    {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
        .build();
        HttpResponse response = null;
        Student[] stds = null;
        try
        {
            String endpoint = "http://localhost:5231";
            URI uri = URI.create(endpoint + "/Student");
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
            .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            stds = gson.fromJson((String)response.body(), Student[].class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // System.out.println("Status Code: " + response.statusCode());
        // System.out.println("Body: " + response.body());
        ArrayList<Student> arr = new ArrayList<>();
        Collections.addAll(arr, stds);
        return arr;
    }

    @Override
    public void post_teacher(Teacher teach)
    {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
        .build();
        HttpResponse response = null;

        try
        {
            Gson gson = new Gson();
            
            String endPoint = "http://localhost:5231";
            URI uri = URI.create(endPoint + "/Student");
            var request = HttpRequest.newBuilder()
            .uri(uri)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(teach)))
            .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Body: " + response.body());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public List<Teacher> get_teachers() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Lesson> get_Lessons() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void post_student(Student student) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void post_lesson(Lesson lesson) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void update_student(Student student, int id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void update_teacher(Teacher teacher, int id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void update_lesson(Lesson lesson, int id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void delete_student(int id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void delete_teacher(int id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void delete_lesson(int id) {
        // TODO Auto-generated method stub
        
    }

}
