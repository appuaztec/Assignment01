package common;

import org.apache.commons.codec.binary.Base64;

public class EncodeDecode {

    public static String perfromEncode(String rswString) {
        if (rswString == null) {
            return null;
        }

        String res = null;
        byte[] encode = Base64.encodeBase64(rswString.getBytes());
        res = new String(encode);
        return res;
    }

    public static String perfromDecode(String encodedString) {

        if (encodedString == null) {
            return null;
        }

        String res = null;
        byte[] decode = Base64.decodeBase64(encodedString);
        res = new String(decode);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(perfromEncode("Appu@xyz123"));
    }

}
