package common;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;

public class PwdEncryptDcrypt {

    public void passEncryptDcrypt(By password) {
        String str = "abcd1234";
        byte[] encode = Base64.encodeBase64(str.getBytes());
        System.out.println("String before encoding: " + str);
        System.out.println("String after encoding : " + new String(encode));
        byte[] decode = Base64.decodeBase64(encode);
        System.out.println("String after decoding : " + new String(decode));

    }

}
