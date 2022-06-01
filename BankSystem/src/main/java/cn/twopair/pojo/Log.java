package cn.twopair.pojo;

import lombok.*;

import java.util.Date;

/**
 * @ClassName Log
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/10 上午10:31
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
public class Log {
    private String id;
    private String cardNumber;
    private Date dealTime;
    private Double money;
    private String type;
    private String comment;
    private String user;
}
