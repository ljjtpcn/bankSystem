package cn.twopair.pojo;

import lombok.*;

import java.util.Date;

/**
 * @ClassName Withdrawal
 * @Description TODO
 * @Author ljjtpcn
 * @Date 2022/5/10 上午10:37
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class Withdrawal {
    private String cardNumber;
    private Date time;
    private Double money;
}
