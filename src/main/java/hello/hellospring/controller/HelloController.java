package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//hello 라고 들어오면 다음 메소드를 호출해줌
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return  "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name , Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody // 스프링 붙어있으면 그대로 넘기는데 객체라서 기본 json방식으로 데이터를 만들어서 응답을 반환
    // requestparam("name")이라서 ,name = spring이런식으로 넘겨줘야함.

    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
