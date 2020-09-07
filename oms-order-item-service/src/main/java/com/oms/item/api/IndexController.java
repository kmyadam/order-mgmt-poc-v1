package com.oms.item.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "<!DOCTYPE html>\r\n" + 
        		"<html lang=\"en\">\r\n" + 
        		"<head>\r\n" + 
        		"    <meta charset=\"UTF-8\">\r\n" + 
        		"    <title>OMS Product Service</title>\r\n" + 
        		"</head>\r\n" + 
        		"<body>\r\n" + 
        		"	<p>OMS Product Service</p>\r\n" + 
        		"    <a href='/swagger-ui.html'>Swagger UI</a>\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
    }
}
