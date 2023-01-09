package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String LogTest(){
        String name = "Spring";

        System.out.println("name = " + name);


        log.trace(" trace my log="+ name); //연산이 먼저 일어나기 때문에 쓸모없는 리소스를 사용하게 된다. 사용하지 않는걸 권장

        log.trace(" trace log={}", name);

        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        return "ok";
    }

}
