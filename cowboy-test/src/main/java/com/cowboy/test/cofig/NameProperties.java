package com.cowboy.test.cofig;/**
 * Created by Administrator on 2017/12/6/0006.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-12-06 14:34
 **/
@ConfigurationProperties(prefix = "tangyinbo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameProperties {
    private String name;
    private String age;
}
