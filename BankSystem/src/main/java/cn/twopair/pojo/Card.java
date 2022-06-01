package cn.twopair.pojo;

import lombok.*;

import java.util.Date;

/**
 * @ClassName Card
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/10 上午10:02
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class Card {
    private String cardNumber;
    private String ofIdNumber;
    private String password;
    private Date startTime;
    private Double money;
    private String type;
    private Boolean status;

}
