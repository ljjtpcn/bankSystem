package cn.twopair.pojo;

import lombok.*;

import java.util.Date;

/**
 * @ClassName Transfer
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/10 上午10:35
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Transfer {
    private String sendCardNumber;
    private String receiveCardNumber;
    private Date time;
    private Double money;

}
