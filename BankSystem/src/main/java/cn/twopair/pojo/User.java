package cn.twopair.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ljjtpcn
 */
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String idNumber;
    private String password;
    private String sex;
    private String phone;
}
