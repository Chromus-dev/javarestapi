package com.example.javarestapi;

// import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charmap")
public class CharMapController {

    @PostMapping("")
    public String postCharMap(@RequestBody CharMapPostBody reqBody) {
        // System.out.println(ToStringBuilder.reflectionToString(reqBody));
        // System.out.println(reqBody.map);

        CharMap map = new CharMap(reqBody.map, reqBody.mapTo, reqBody.caseSensitive);

        return map.translate(reqBody.str);
    }
}
