/*package kg.zeroone.java.crudapp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
    @Value("${title}")
    String title;

    public Map<Integer, Student> studentMap = new HashMap<Integer, Student>(){{
        put(111, new Student(111," Azat"," Almaz uulu",  18));
        put(222, new Student(222," Enes"," Abi",  19));
    }};

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,
                       @RequestParam("age") int age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("title",title);
        return "hello";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student", studentMap);
        model.addAttribute("title",title);
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model){

        model.addAttribute("title",title);
        return "contact";
    }

    @GetMapping("/detail")
    public String studentDetail(@RequestParam("id") int id, Model model){
        Student student = studentMap.get(id);
        model.addAttribute("student", student);
        model.addAttribute("title", title);
        model.addAttribute("message", "ecer");
        return "detail";
    }

    @GetMapping("/add")
    public String addStudent( Model model){

        model.addAttribute("student",new Student());
        model.addAttribute("title",title);
        return "add";
    }

    @PostMapping("/add")
    public String addStudentPost(@ModelAttribute Student student, Model model){
        studentMap.put(student.getId(), student);
        model.addAttribute("title", title);
        model.addAttribute("student",student);
        model.addAttribute("message", "New student has been added.");

        return "detail";
    }

    @PostMapping("/delete")
    public String deleteStudentPost(@ModelAttribute int id, Student student, Model model) {
        studentMap.remove(id);
        model.addAttribute("title", title);
        model.addAttribute("student", student);
        model.addAttribute("message", "Student was been deleted.");

        return "delete";
    }
}*/
package kg.zeroone.java.crudapp.controller;

import kg.zeroone.java.crudapp.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
    @Value("${title}")
    String title;
    public Map<Integer, Student>studentMap=new HashMap<Integer,Student>(){{
        put(111,new Student(111,"Azat","Almaz uulu",18));
        put(222,new Student(222,"Aisuluu","Beishenbekova",17));
        put(333,new Student(333,"Miraida","Bazarbaeva",18));
        put(444,new Student(444,"Esentur","Zamirbekov",18));
        put(555,new Student(555,"Begimai","Shadybekova",18));}
    };


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("students",studentMap);
        model.addAttribute("title",title);
        return "index";
    }
    @GetMapping("/detail")
    public String studentDetails(@RequestParam("id")int id, Model model){
        Student student=studentMap.get(id);
        model.addAttribute("student",student);
        model.addAttribute("title",title);
        model.addAttribute("message"+ "Detail message student");
        return "detail";
    }

    @GetMapping("/add")
    public String addStudent( Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("title",title);
        return "add";
    }

    @PostMapping("/add")
    public String addStudentPost(@ModelAttribute Student student,Model model){
        studentMap.put(student.getId(),student);
        model.addAttribute("title",title);
        model.addAttribute("message","New student has been added");
        return "detail";
    }
    @GetMapping("/delete")
    public String studentDelete(@RequestParam("id")int id, Model model){
        Student student=studentMap.get(id);
        studentMap.remove(id);
        model.addAttribute("student",student);
        model.addAttribute("title",title);
        model.addAttribute("message"+ "Following student deleted");
        return "detail";
    }
    @GetMapping("/hello")
    public String about(@RequestParam("name") String name,@RequestParam ("age") int age,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("title",title);
        return "hello";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title",title);
        return "contact";
    }

    @GetMapping("/change")
    public String changeStudent( Model model){
        model.addAttribute("student", studentMap);
        model.addAttribute("title",title);
        return "change";
    }

    @PostMapping("/change")
    public String changeStudentPost(@RequestParam("id")int id, @ModelAttribute Student student,Model model) {
        studentMap.replace(student.getId(), student);
        model.addAttribute("title", title);
        model.addAttribute("message", "This student was be changed");
        return "detail";
    }
}

