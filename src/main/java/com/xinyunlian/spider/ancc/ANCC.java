package com.xinyunlian.spider.ancc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xinyunlian.spider.ancc.dto.RetDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class ANCC {

    public static void main(String[] args) {
        try {
            // TODO Auto-generated method stub
            ANCC a = new ANCC();
            //System.out.println(a.loadJson("6949341800266"));
            String json = a.loadJson("aa6949341800266");
            System.out.println(json);
            System.out.println(a.loadJson("3s6949341800256"));
            System.out.println(a.loadJson("ttt6949341800276"));
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy hh:mm:ss").create();
            RetDto sasaa = gson.fromJson(json, RetDto.class);


        }catch (Exception ex)
        {

        }
    }

    /**
     * 获取json数据
     *
     * 通过编码获取物品相关信息
     *
     * @param id 物品编码
     * @return json数据
     */
    public String loadJson(String id) throws AuthException {
        String geturl = getUrl(id);
        StringBuilder json = new StringBuilder();
        HttpURLConnection uc=null;
        BufferedReader in = null;
        try {
            URL urlObject = new URL(geturl);
            uc = (HttpURLConnection) urlObject.openConnection();
            uc.setConnectTimeout(5000);
            if(uc.getResponseCode()!=200)
            {
                throw new AuthException(uc.getResponseCode()+"");
            }
            in= new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            return json.toString();
        }catch (AuthException ex){
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(in!=null)
                    in.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
            uc.disconnect();
        }
        return null;

    }

    /**
     * 构建URL
     *
     * 构建真实数据url
     *
     * @param num 物品编码
     * @return ANCC链接
     */
    private String getUrl(String num) {
        StringBuilder url = new StringBuilder("http://webapi.chinatrace.org/api/getProductData?productCode=")
                .append(num);
        int s = url.indexOf("/api/");
        String dataBeforeMac = url.substring(s, url.length());
        url.append("&mac=");
        String mac = getMac("V7N3Xpm4jpRon/WsZ8X/63G8oMeGdUkA8Luxs1CenTY=", dataBeforeMac);
        return url.append(mac).toString();
    }

    /**
     * 计算Mac校验值
     *
     * 用于后台校验用户渠道，防止破译
     *
     * @param key 计算密钥
     * @param data 数据
     * @return mac 校验值
     */
    private String getMac(String key, String data) {
        byte[] operateByteArray = { 87, -77, 119, 94, -103, -72, -114, -108, 104, -97, -11, -84, 103, -59, -1, -21, 113,
                -68, -96, -57, -122, 117, 73, 0, -16, -69, -79, -77, 80, -98, -99, 54 };
        try {
            Mac localMac = Mac.getInstance("HmacSHA256");
            byte[] dateByteArray = data.getBytes("ASCII");
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(operateByteArray, "HMACSHA256");
            localMac.init(localSecretKeySpec);
            return toHex(localMac.doFinal(dateByteArray)).toUpperCase();
        } catch (Exception localException) {
            localException.printStackTrace();
            return null;
        }
    }

    /**
     * 位运算值
     *
     * 用于计算mac校验值
     *
     * @param dateByteArray 数据字节数组
     * @return 十六进制串
     */
    private String toHex(byte[] dateByteArray) {
        int i = dateByteArray.length * 2;
        StringBuilder buffer = new StringBuilder(i);
        int m = dateByteArray.length;
        int k = 0;
        while (true) {
            if (k >= m)
                return buffer.toString();
            char tempChar = Character.forDigit((dateByteArray[k] & 0xF0) >> 4, 16);
            buffer.append(tempChar);
            tempChar = Character.forDigit(dateByteArray[k] & 0xF, 16);
            buffer.append(tempChar);
            k++;
        }
    }
}
