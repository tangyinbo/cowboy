package com.cowboy.test.spel;/**
 * Created by Administrator on 2017/12/21/0021.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-21 11:29
 **/
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpelProBean {
    private String name = "tagyinbo2fsfsfsfs2";

    public static String testName = "kakakakakkaka";

    public static String getMyName(){
        System.out.println("getMyName....");
        return "this is my Name" + LocalDate.now().toString();
    }

    public static List<Sp> getSps(){
        List<Sp> sps = IntStream.range(0,3).boxed().map(
                i->{
                    int a = 0;
                    return new Sp(i,"name"+i,"desc"+i);
                }
        ).collect(Collectors.toList());
        return sps;
    }

}
